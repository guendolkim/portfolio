package com.kh.portfolio.recipe.dao;

import java.util.List;

import com.kh.portfolio.recipe.vo.MaterialVO;
import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

public interface RecipeDAO {
	
	/**
	 * 레시피 리스트 출력
	 * @param RECIPE_ID
	 * @return
	 */
//	List<RecipeVO> list();
	
	
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
	 * 메인에 보여줄 리스트
	 * @return
	 */
	public List<RecipeVO> mainPageList();
	
	/**
	 * 페이징을 위한 리스트 출력
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	List<RecipeVO> list(int startRec, int endRec);
	
	/**
	 * 상세레시피 출력-레시피
	 * @return
	 */
	public RecipeVO recipe(String recipeNum);
	
	/**
	 * 상세레시피 출력-재료
	 * @return
	 */
	List<MaterialVO> material(String recipeNum);
	
	/**
	 * 상세페이지 출력-조리 순서
	 * @return
	 */
	List<StepVO> step(String recipeNum);
	
//===================  레시피 입력  ===============================	
	/**
	 * 레시피 입력
	 * @param RecipeVO 
	 * @return
	 */
	public int inputRecipe(RecipeVO recipeVO);
	
	/**
	 * 레시피 순서
	 * @param stepVO
	 * @return
	 */
	public int inputStep(StepVO stepVO);
	
	/**
	 * 레시피 재료
	 * @param materialVO
	 * @return
	 */
	public int inputMaterial(MaterialVO materialVO);
	
	/**
	 * 레시피 아이디 값 받아오기
	 * @return
	 */
	public String getRecipeId();
	
	/**
	 * 레시피 저장하기
	 * @return
	 */
	public int recipeLike(String user_id, String recipe_id);
	
	/**
	 * 레시피 좋아요저장되어 있는 지 확인
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	public int recipeInsertChk(String user_id, String recipe_id);
	/**
	 * 레시피 좋아요 한 번 더 누르면 삭제하기
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	public int recipeLikeDelete(String user_id, String recipe_id);
	
	
	/**
	 * 게시판 전체 레코드 수
	 * @return
	 */
	long totalRecordCount(); 
	long totalRecordCount(String searchType, String keyWord); 
	
	/**
	 * 레시피 조회수 증가
	 * @param recipe_id
	 * @return
	 */
	int recipeViewCount(String recipe_id);
	
}
