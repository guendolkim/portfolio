package com.kh.portfolio.member.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.portfolio.common.Code;
import com.kh.portfolio.common.svc.CodeSVC;
import com.kh.portfolio.member.svc.MemberSVC;
import com.kh.portfolio.member.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j //사용시 log.info(), log.error() 등..
public class MemberController {
	
//	private static final Logger logger
//		= LoggerFactory.getLogger(MemberController.class);
	
	private final MemberSVC memberSVC;
	private final CodeSVC codeSVC;
	
	@Autowired
	public MemberController(MemberSVC memberSVC, CodeSVC codeSVC) {
		this.memberSVC = memberSVC;
		this.codeSVC = codeSVC;
	}
	
	@ModelAttribute
	public void initData(Model model) {
		model.addAttribute("region", codeSVC.getCodesByCodetype("1000"));
		model.addAttribute("hobby", codeSVC.getCodesByCodetype("1010"));	
		
		//성별
		List<Code> gender = new ArrayList<>();
		gender.add(new Code("남","남자"));
		gender.add(new Code("여","여자"));
		model.addAttribute("gender", gender);		
	}
	
	//회원가입양식
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "/member/joinForm";
	}
	
	//회원가입처리
	@PostMapping("/joinSave")
	public String joinSave(
			@RequestParam(value="user_id") String user_id,
			MemberVO memberVO, 
			BindingResult errResult) {
		
		int result = 0;
		
		log.info("memberVO : " + memberVO);
	
		//유효성체크 오류가 있다면
		if(errResult.hasErrors()) {
			log.info("join메소드 유효성 오류발생");
			return "/member/joinForm";
		}
		
		result = memberSVC.joinMember(memberVO);
		
		if(result == 1) {
			log.info("회원가입성공:" + memberVO);
			return "/mainPage";
		}else {
			log.info("회원가입실패:" + memberVO);
			return "redirect:/member/joinForm";
		}
	}

	//비밀번호 수정 양식
	@GetMapping("/changePWForm")
	public String changePWForm() {
		
		return "/member/changePWForm";
	}
	
	//비밀번호 변경 처리
	@PostMapping("/changePW")
	public String change(
			@RequestParam("member_id") String member_id,
			@RequestParam("currentpw") String currentpw, 
			@RequestParam("nextpw") String nextpw,
			Model model
			) {
		
		log.info("비밀번호변경:"+ member_id); 
		log.info("비밀번호변경:"+ currentpw); 
		log.info("비밀번호변경:"+ nextpw);
		
		String viewName = null;
		int result = memberSVC.changePw(member_id, currentpw, nextpw);
		//성공
		if(result == 1) {
			
			viewName = "redirect:/member/mypage";
		}else {
		//실패
			model.addAttribute("svr_msg", "비밀번호를 올바르게 입력하세요!");
			viewName = "/member/changePWForm";
		}
		return viewName;
	}
	
	
	//회원 이미지 조회
	@GetMapping("/findProfileImg/{user_id}/")
	public void findProfileImg(@PathVariable String user_id, HttpServletResponse res) {
		//res.setContentType("image/*");
		try {
			byte[] imageFile = memberSVC.findProfileImg(user_id);
			InputStream is = new ByteArrayInputStream(imageFile);
			IOUtils.copy(is, res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 아이디 찾 폼
	@GetMapping("/findIdForm")
	public String findMemberForm() {
		
		return "/member/findIdForm";
	}

	//회원 비밀번호 찾기 폼
	@GetMapping("/findPwForm")
	public String findPwForm() {
		
		return "/member/findPwForm";
	}
	
	//찾은 비밀번호 처리
	@ResponseBody
	@PostMapping("/findPwSave")
	public Map<String,Object> findPwSave(
			@RequestBody Map<String, String> reqDate){
		Map<String, Object> map = new HashMap<>();
		String pw = null;
		try {
			pw = memberSVC.findPW(
					 reqDate.get("member_id"), 
					 reqDate.get("tel"),
					 reqDate.get("birth"));
			map.put("rtcd", "00");
			map.put("result", pw);
		} catch(Exception e) {
			map.put("rtcd", "01");
			map.put("errmsg", "회원 정보가 없습니다.");
		}
		return map;
	}
}












