package com.kh.portfolio;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.kh.portfolio.buy.svc.BuySVC;
import com.kh.portfolio.recipe.svc.RecipeSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class HomeController {
	final RecipeSVC recipeSVC;
	final BuySVC buySVC;
	
	//메인페이지
	@GetMapping({"/","/mainPage"})
	public String welcomePage(Model model) {
		model.addAttribute("mainPageList", recipeSVC.mainPageList());
		model.addAttribute("highestSaleCntList", buySVC.highestSaleCntList());
		model.addAttribute("newestItemList", buySVC.newestItemList());
		return "/mainPage";
	}
	
	//bootstrap
	@GetMapping("/bootstrap")
	public String bootstrap() {
		
		return "/test/bootstrap";
	}
}







