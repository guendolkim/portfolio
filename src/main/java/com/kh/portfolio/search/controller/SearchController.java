package com.kh.portfolio.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.kh.portfolio.search.svc.SearchSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SearchController {
	final SearchSVC searchSVC;
	
	
	@GetMapping("/searchList")
	public String SearchList(
			@RequestParam("keyword") String keyword,
			Model model) {
	
		log.info("keyword: "+ keyword);
		
		model.addAttribute("keyword", keyword);
		model.addAttribute("searchList", searchSVC.searchList(keyword).get("recipeList"));
		return "search/searchList";
	}
}
