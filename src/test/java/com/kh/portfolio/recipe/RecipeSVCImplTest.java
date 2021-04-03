package com.kh.portfolio.recipe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.kh.portfolio.recipe.svc.RecipeSVC;
import com.kh.portfolio.recipe.vo.MaterialVO;

import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
@Slf4j // 로거 기록
@Transactional // SVC에서는 commit , junit에서는 rollback처리됨
public class RecipeSVCImplTest {
	
	/*
	 * @Autowired RecipeSVC recipeSVC;
	 * 
	 * @Test
	 * 
	 * @DisplayName("리스트 출력")
	 * 
	 * @Disabled
	 */
	/*
	 * void list() { log.info("ddd: "+recipeSVC.list()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("상세 페이지 출력")
	 * 
	 * @Disabled void detail() { long recipeNum = 1; log.info("자세한 내용은 여기서 확인하세요: "
	 * +recipeSVC.recipeDetail(recipeNum)); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("레시피 입력")
	 * 
	 * @Disabled void Enroll() { RecipeEnroll recipeEnroll = new RecipeEnroll();
	 * 
	 * RecipeVO recipeVO = new RecipeVO(); MaterialVO materialVO = new MaterialVO();
	 * StepVO stepVO = new StepVO();
	 * 
	 * recipeEnroll.setRecipeVO(recipeVO); recipeEnroll.setMaterialVO(materialVO);
	 * recipeEnroll.setStepVO(stepVO);
	 * 
	 * 
	 * recipeEnroll.getRecipeVO().setRecipe_id(10);
	 * recipeEnroll.getRecipeVO().setMember_user_id("user_001");
	 * recipeEnroll.getRecipeVO().setRecipe_name("짜장면");
	 * recipeEnroll.getRecipeVO().setRecipe_contents("짜장면을 만들어 보았습니다.");
	 * recipeEnroll.getRecipeVO().setRecipe_category("면");
	 * recipeEnroll.getRecipeVO().setRecipe_what_situation("혼자 밥 먹을 때");
	 * recipeEnroll.getRecipeVO().setRecipe_method("볶아서");
	 * recipeEnroll.getRecipeVO().setRecipe_material("볶음밥, 밥");
	 * recipeEnroll.getRecipeVO().setRecipe_how_many("2명");
	 * recipeEnroll.getRecipeVO().setRecipe_how_long("1시간");
	 * recipeEnroll.getRecipeVO().setRecipe_difficulty("전문가");
	 * recipeEnroll.getRecipeVO().setRecipe_tag("안녕#혼밥#짜장");
	 * 
	 * recipeEnroll.getStepVO().setStep_id("step_28");
	 * recipeEnroll.getStepVO().setStep_contents("자장을 반으로 갈라");
	 * recipeEnroll.getStepVO().setStep_picture(null);
	 * recipeEnroll.getStepVO().setRecipe_recipe_id(1);
	 * 
	 * recipeEnroll.getMaterialVO().setMaterial_id("038");
	 * recipeEnroll.getMaterialVO().setMaterial_title("된장");
	 * recipeEnroll.getMaterialVO().setMaterial_contents("한 스푼");
	 * recipeEnroll.getMaterialVO().setRecipe_recipe_id(1);
	 * 
	 * if(recipeSVC.recipeEnroll(recipeEnroll) == 1) { log.info("성공"); }else {
	 * log.info("실해"); } }
	 */
	/*@Test
	@DisplayName("마이페이지 레시피 출력")
//	@Disabled
	void recipeListChk() {
		String member_user = "test1@test.com";
		
		log.info("마이페이지 리스트 출려"+recipeSVC.onlyRecipeList(member_user));
	}*/
}
