package com.kh.portfolio.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.portfolio.member.svc.MemberSVC;
import com.kh.portfolio.member.vo.MemberVO;
import com.kh.portfolio.recipe.svc.RecipeSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@Slf4j
public class mypageController {
	final MemberSVC memberSVC;
	final RecipeSVC recipeSVC;
	
	//내정보
	@GetMapping("/myPage")
	public String mypage() {
		
		return "/mypage/myPage";
	}
	
	//내가 작성한 레시피 페이지
	@GetMapping("/myRecipePage/{member_id}")
	public String myRecipePage(
			@PathVariable String member_id,
			Model model) {
		String view = null;
		log.info("member_id"+member_id); //레시피 아이디 넘어왔나?
		//레시피 리스트는 왜 안넘어오지???
		log.info("레시피 넘어왔나 확인용"+recipeSVC.onlyRecipeList(member_id));
		model.addAttribute("recipeList", recipeSVC.onlyRecipeList(member_id));
		view = "/mypage/myRecipePage";
		
		return view;
	}
	
	//주문 내역 페이지
	@GetMapping("/orderPage")
	public String myPageOrder() {
		
		return "/mypage/orderPage";
	}
	
	//회원수정양식
	@GetMapping("/modifyPage")
	public String modifyForm(
			Model model,
			HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("member"); //현재 접속해있는 memberVO의 정보를 가져온다.
		//세션정보가 없으면 로그인 화면으로 이동
		if(memberVO == null) {
			return "redirect:/loginForm";
		}
		
		MemberVO member = memberSVC.listOneMember(memberVO.getUser_id());
		member.setUser_pw(""); //memberVO를 넘겨주는데 패스워드 부분만 지워서 밑에 model로 넘겨준다.
		
		model.addAttribute("memberVO", member);

		return "/mypage/modifyPage";
	}
	
	//회원수정처리
	@PostMapping("/modifyPageSave")
	public String modifySave(
			@Valid MemberVO memberVO,
			BindingResult errResult,
			Model model, //포워드 방식으로 view에 전달시
			RedirectAttributes redirectAttrs, //리다이렉트 방식으로 view에 전달시
			HttpSession session //올린 정보를 받아오는 건지 올리는 건지???
		) {
		String viewName = null;
		
		log.info("회원수정처리:" + memberVO.toString());
		
//		//유효성체크 오류발생시
//		if(errResult.hasErrors()) {
//			return "/mypage/modifyPage";
//		}
		
		int result = memberSVC.modifyMember(memberVO);
		//수정 성공
		if(result == 1 ) {
//				model.addAttribute("svr_msg", "회원정보가 수정되었습니다!"); //포워드
			
			//세션의 회원정보 갱신
			//현재 세션정보 제거
			session.removeAttribute("member");
			//새로운 정보로 세션생성
			session.setAttribute("member", memberSVC.listOneMember(memberVO.getUser_id()));
			
			redirectAttrs.addFlashAttribute("svr_msg", "회원정보가 수정되었습니다!"); //리다이렉트
			viewName = "redirect:/member/modifyForm";
		}else {
		//수정 실패	
			model.addAttribute("svr_msg", "회원정보가 수정 실패!");
			viewName = "/mypage/modifyPage";
		}
		return viewName;
	}
		
	//회원탈퇴양식	
	@GetMapping("/exitPage")
	public String outMemberForm() {
		
		return "/mypage/exitPage";
	}
		
	//회원탈퇴	/member/outMember
	@PostMapping("/exitPageSave")
	public String outMemberSave(
			@RequestParam("user_id") String user_id,
			@RequestParam("currentpw") String currentpw,
			HttpSession session,
			Model model
			) {
		String viewName = null;
		
		int result = memberSVC.outMember(user_id, currentpw);
		//1)탈퇴성공
		if(result == 1) {
			
			//로그아웃 처리후 초기화면으로
			session.invalidate();
			viewName = "redirect:/mainPage";
		}else {
		//2)탈퇴실패
			
			model.addAttribute("svr_msg", "비밀번호가 일치하지 않습니다!");
			viewName = "/mypage/exitPage";
		}	
		return viewName;
	}

}
