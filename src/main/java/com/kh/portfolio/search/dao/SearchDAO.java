package com.kh.portfolio.search.dao;

import java.util.List;

import com.kh.portfolio.recipe.vo.RecipeVO;

public interface SearchDAO {

	/**
	 * 일단은 레시피만 검색하기 위해서
	 * 페이징을 위한 리스트 출력
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	List<RecipeVO> searchList(String keyword);

	
}
