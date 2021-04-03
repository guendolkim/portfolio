package com.kh.portfolio.search.svc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.portfolio.search.dao.SearchDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchSVCImpl implements SearchSVC {

	final SearchDAO searchDAO;
		
	public Map<String, Object> searchList(String keyword){
		Map<String, Object> map = new HashMap<>();
		map.put("recipeList", searchDAO.searchList(keyword));
		
		return map;
	}
}

