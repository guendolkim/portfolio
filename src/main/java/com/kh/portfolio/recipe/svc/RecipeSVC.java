package com.kh.portfolio.recipe.svc;


import java.util.List;
import java.util.Map;



import com.kh.portfolio.recipe.vo.MaterialVO;

import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

public interface RecipeSVC {


	/**
	 * 레시피만 보여줄 리스트
	 * @return
	 */
	public List<RecipeVO> onlyRecipeList(String member_user_id);
	
	/*
	 * 저장을 누른 레시피를 보여줄 리스트
	 */
	public List<RecipeVO> likeRecipeList(String user_id);
	
	
	/**
	 * 페이징을 위한 리스트 출력
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	Map<String, Object> list(int reqPage);
	
	/**
	 * 메인에 보여줄 리스트
	 * @return
	 */
	public List<RecipeVO> mainPageList();
	
	/**
	 * 레시피 상세 페이지 출력
	 * @return
	 */
	Map<String, Object> recipeDetail(String recipeNum);


	//===================  레시피 입력  ===============================	
	/**
	 * 레시피 입력
	 * @param recipeVO
	 * @param materialVO
	 * @param stepVO
	 * @return
	 */
	public int recipeEnroll_recipe(
							RecipeVO recipeVO,
							MaterialVO materialVO,
							StepVO stepVO);
	
	public int recipeEnroll(MaterialVO materialVO,
							StepVO stepVO);

	/**
	 * 레시피 좋아요저장되어 있는 지 확인
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	public int recipeInsertChk(String user_id, String recipe_id);
	/**
	 * 레시피 저장하기
	 * @return
	 */
	public int recipeLike(String user_id, String recipe_id);
	
	/**
	 * 레시피 아이디 값 받아오기
	 * @return
	 */
	public String getRecipeId();
	
	/**
	 * 레시피 조회수 증가
	 * @param recipe_id
	 * @return
	 */
	int recipeViewCount(String recipe_id);
	
}
