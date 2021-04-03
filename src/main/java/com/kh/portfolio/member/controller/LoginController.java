package com.kh.portfolio.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.portfolio.member.svc.MemberSVC;

@Controller
public class LoginController {
	private static final Logger logger
		= LoggerFactory.getLogger(LoginController.class);
	
	private final MemberSVC memberSVC;
	
	@Autowired
	public LoginController(MemberSVC memberSVC) {
		this.memberSVC = memberSVC;
	}
	
	//로그인양식
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "/member/loginForm";
	}
	//로그인처리
	@PostMapping("/loginSave")
	public String loginSave(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw,
			Model model,
			HttpSession	session //Session에 올리는 거다.
			) {
		logger.info("id:"+user_id);
		logger.info("pw:"+user_pw);
		
		//1. 회원인경우
		if(memberSVC.existMember(user_id)) {
			model.addAttribute("svr_msg","");
			//1-1 회원번호일치
			if(memberSVC.isMember(user_id, user_pw)) {
				//session은 서버에 영향을 주는 친구
				session.setAttribute("member", memberSVC.listOneMember(user_id));
				model.addAttribute("svr_msg","");
				return "/mainPage"; //메인으로 돌아가기 위해서 index를 반환한다.
			//1-2 회원번호불일치
			}else {
				//model은 jsp에 영향을 주는 친구,
				model.addAttribute("svr_msg","가입되지 않은 아이디 또는 잘못된 비밀번호입니다.");
				return "/member/loginForm";
			}
		//2. 비회원인경우
		}else {
			model.addAttribute("svr_msg","가입되지 않은 아이디 또는 잘못된 비밀번호입니다.");
			return "/member/loginForm";
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		//세션에 저장된 정보 제거
		session.invalidate();
		
		return "redirect:/";
	}
}






