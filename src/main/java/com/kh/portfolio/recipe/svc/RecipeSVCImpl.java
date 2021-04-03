package com.kh.portfolio.recipe.svc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.kh.portfolio.common.paging.PageCriteria;
import com.kh.portfolio.recipe.dao.RecipeDAO;
import com.kh.portfolio.recipe.vo.MaterialVO;

import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeSVCImpl implements RecipeSVC {

	final RecipeDAO recipeDAO;
	final PageCriteria pc;

	/**
	 * 메인에 보여줄 리스트
	 * @return
	 */
	@Override
	public List<RecipeVO> mainPageList() {
		List<RecipeVO> result = recipeDAO.mainPageList();
		return result;
	}
	
	/**
	 * 레시피만 보여주는 리스트
	 */
	@Override
	public List<RecipeVO> onlyRecipeList(String member_user_id) {
		List<RecipeVO> result = recipeDAO.onlyRecipeList(member_user_id);
		log.info("여기는 recipeSVC이고 지금 값은 넘어왔나?:"+recipeDAO.onlyRecipeList(member_user_id));
		log.info("여기는 recipeSVC이고 memberuser 값은 넘어왔나?:"+member_user_id);
		return result;
	}
	
	/*
	 * 저장을 누른 레시피를 보여줄 리스트
	 */
	@Override
	public List<RecipeVO> likeRecipeList(String user_id) {
		List<RecipeVO> result = recipeDAO.likeRecipeList(user_id);
		return result;
	}
	
	/**
	 * 페이징을 위한 리스트 출력
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	@Override
	public Map<String, Object> list(int reqPage) {
		Map<String, Object> map = new HashMap<>();
		//1) 요청페이지- reqPage는 내가 누르는 번호이다.
		pc.getRc().setReqPage(reqPage); //메서드를 통해 값이 생성된다.
		//2) 총 레코드 정보
		pc.setTotalRec(recipeDAO.totalRecordCount());
		//3) 페이징계산
		pc.calculatePaging();
		//4) 목록 가져오기
		int startRec 	= pc.getRc().getStartRec();
		int endRec 		= pc.getRc().getEndRec();
		List<RecipeVO> list = recipeDAO.list(startRec, endRec);
		//5)map객체에 게시글 목록, pc담기
		map.put("recipeList", list);
		map.put("pc",pc);

		return map;
	}
	
	/**
	 * 레시피 상세 페이지 출력
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> recipeDetail(String recipeNum) {
		// 맵은 키와 값. 두 가지를 받아서 만들 수 있다. 우선 3가지를 불러와야하는데 하나는 하나, 두 개는 리스트 형식으로 온다.
		// 각각 맵에 키랑 같도록 매핑한 다음에 컨트롤러로 넘겨서, 컨트롤러에서 알아서 처리하도록 만들 수 있나??
		RecipeVO recipeVO = recipeDAO.recipe(recipeNum);
		List<MaterialVO> materialVO = recipeDAO.material(recipeNum);
		List<StepVO> stepVO = recipeDAO.step(recipeNum);
	
	
		
		if(stepVO.size() != 0) {
			for(int i=0; i<stepVO.size(); i++) { 
				stepVO.get(i).setPicBase64((conversionToBase64(stepVO.get(i).getStep_picture()))); 
			}
		}				 
		if(recipeVO!= null) {
			for(int i=0; i<stepVO.size(); i++) { 
				recipeVO.setPicBase64((conversionToBase64(recipeVO.getRecipe_main()))); 
			}
		}else {
			stepVO.get(0).setPicBase64((conversionToBase64(stepVO.get(0).getStep_picture())));
		}
		
			 
					 
			

		// 굳이 위 처럼 한 이유가 있을까요??
		Map<String, Object> map = new HashMap<>();

		map.put("recipe", recipeVO);
		map.put("material", materialVO);
		map.put("step", stepVO);

		return map;
	}

	//이미지 base64로 변환후 img태그에 적용하기위함
	//Base64의 핵심은 바이너리 데이터를 ASCII코드로 변경하는 인코딩방식
	private String conversionToBase64(byte[] pic) {
		if(pic != null) {
			
			byte[] encoded = Base64.encodeBase64(pic);
			return new String(encoded);
		}else {
			return null;
		}
		
	}
	
	/**
	 * 레시피 입력
	 * @param recipeEnroll
	 * @return
	 */
	public int recipeEnroll_recipe(RecipeVO recipeVO, 
								   MaterialVO materialVO,
								   StepVO stepVO) {
		int result;
		int i = recipeDAO.inputRecipe(recipeVO);
		if(i == 1) {
			log.info("레시피님 넘어오셨군요..");
			result = recipeEnroll(materialVO, stepVO);
		}else {
			log.info("레시피님 넘어오지못하셨군요..");
			result = 0;
		}
		
		return result;
	}
	
	public int recipeEnroll(MaterialVO materialVO,
							StepVO stepVO) {
		log.info("잔당들 불러와짐.");
		int material = recipeDAO.inputMaterial(materialVO);
		int step = recipeDAO.inputStep(stepVO);
	
		return material*step;
	}
	
	/**
	 * 레시피 저장하기 or 삭제하기
	 * @return
	 */
	@Override
	public int recipeLike(String user_id, String recipe_id) {
		if(recipeDAO.recipeInsertChk(user_id, recipe_id) == 0) {
			 recipeDAO.recipeLike(user_id, recipe_id);
			 return 1;
		}else {
			 recipeDAO.recipeLikeDelete(user_id, recipe_id);
			 return 0;
		}                                                
	}
	/**
	 * 레시피 좋아요저장되어 있는 지 확인
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	@Override
	public int recipeInsertChk(String user_id, String recipe_id) {
		
		return recipeDAO.recipeInsertChk(user_id, recipe_id);
	}
	
	/**
	 * 레시피 아이디 값 받아오기
	 * @return
	 */
	public String getRecipeId() {
		return recipeDAO.getRecipeId();
	}
	
	/**
	 * 레시피 조회수 증가
	 * @param recipe_id
	 * @return
	 */
	@Override
	public int recipeViewCount(String recipe_id) {
		int result = recipeDAO.recipeViewCount(recipe_id);
		return result;
	}
	



}
