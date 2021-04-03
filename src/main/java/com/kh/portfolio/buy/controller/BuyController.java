package com.kh.portfolio.buy.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.portfolio.buy.svc.BuySVC;
import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;
import com.kh.portfolio.common.paging.PageCriteria;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/buy")
@RequiredArgsConstructor
@Slf4j
public class BuyController {
	
	public final BuySVC buySVC;	

	/**
	 * 구매 리스트 출력
	 * @param model
	 * @return
	 */
	@GetMapping({"/buyList",
				"/buyList/{reqPage}"})
	public String buyList(@PathVariable(value="reqPage", required = false) Optional<Integer> reqPage,
								Model model) { //
		Map<String, Object> map = buySVC.list(reqPage.orElse(1));
		
		//게시글 목록
		model.addAttribute("buyList",(List<BuyVO>)(map.get("buyList")));
		//페이징 정보     
		model.addAttribute("pc", (PageCriteria)(map.get("pc")));
		
		return "/buy/buyList";
	}
	
	/**
	 * 구매상세페이지
	 * @return
	 */
	@GetMapping("/buyDetail/{item_id}")
	public String buyDetail(
			@PathVariable(value="item_id") String item_id,
			Model model) {
			
		log.info("id는 "+item_id);
		model.addAttribute("listDetail", buySVC.listDetail(item_id));		
		
		return "/buy/buyDetail";
	}
	
	/**
	 * 카트에 물건 담기
	 * @return
	 */
	@ResponseBody
	@PostMapping(
			value="/cartSave",
			consumes = "application/json",
			produces = "application/json")
	public String cart(
			@RequestBody Map<String, Object> param) {
		CartVO cartVO = new CartVO();	
		
		cartVO.setMember_user_id(param.get("user_id").toString());
		cartVO.setItem_item_id(param.get("item_id").toString());
		String isAlreadExist = buySVC.chkIncart(cartVO);
		
		//상품이 장바구니에 없는 경우
		if(!(isAlreadExist.equals("true"))) {
			return "empty"; 
		}else {
			return "exist";
		}
	}
	
	/**
	 * 구매 상세 설명란
	 * @return
	 */
	@PostMapping("/description")
	public String description(@RequestParam String item_id) {
		//이거는 저장하고 바로 리다이렉트되는 걸로?
		return "/buyDetail/{item_id}";
	}
	
	/**
	 * 장바구니
	 * @return
	 */
	@GetMapping("/cart")
	public String cart() {
		return "/buy/cart";
	}
	
	/**
	 * 결제 창
	 * @return
	 */
	@GetMapping("/paymentForm")
	public String paymentForm() {
		return "/buy/paymentForm";
	}
	
	/**
	 * 구매상품 등록폼
	 * @return
	 */
	@PostMapping("/buyEnrollForm")
	public String buyEnrollForm() {
		
		return "${contextPath}/buyEnrollForm";
	}
	/**
	 * 구매상품 등록폼
	 * @return
	 */
	@PostMapping("/buyEnroll")
	public String buyEnroll(BuyVO buyVO) {
		String view = null;
		int result = 0;
		
		result = buySVC.buyEnroll(buyVO);
		
		if(result == 0) {
			view = "/portfolio/buy/buyEnrollForm_ok";
		}
		view = "/portfolio/buy/buyEnrollForm";
		
		return view;
	}
}
	

