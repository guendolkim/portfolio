package com.kh.portfolio.recipe;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.recipe.dao.RecipeDAO;
import com.kh.portfolio.recipe.vo.MaterialVO;
import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
@Slf4j // 로거 기록
//@Transactional // SVC에서는 commit , junit에서는 rollback처리됨
//@RequiredArgsConstructor
public class RecipeDAOImplTest {

	@Autowired
	RecipeDAO recipeDAO;
	
	@Test
	@DisplayName("레시피 좋아요")
	@Disabled
	void recipeLike() {
		String user_id = "test1@test.com";
		String recipe_id = "1";
		log.info("recipe번호는? "+ recipeDAO.recipeLike(user_id, recipe_id));
	}
	
	
	@Test
	@DisplayName("메인 리스트 출력")
	@Disabled
	void mainList() {
		List<RecipeVO> list = recipeDAO.mainPageList();
		for(int i=0; i<list.size(); i++) {
			log.info("list는 " + list);

		}
	}
	
	@Test
	@DisplayName("게시글 리스트 출력")
	@Disabled
	void list() {
		int startRec = 1;
		int endRec = 10;
		List<RecipeVO> list = recipeDAO.list(startRec, endRec);
		log.info("list:"+list);
	}
	
	@Test
	@DisplayName("레시피")
	@Disabled
	void recipe() {
		long num = 1;
		log.info("레시피 출력문: " + recipeDAO.recipe(num));
	}
	
	@Test
	@DisplayName("재료")
	@Disabled
	void material() {
		long num = 1;
		log.info("재료 출력문: " + recipeDAO.material(num));
	}
	
	@Test
	@DisplayName("순서")
	@Disabled
	void step() {
		long num = 1;
		log.info("순서 출력문: " + recipeDAO.step(num));
	}
	
	@Test
	@DisplayName("레시피 입력-메인")
	@Disabled
	void recipeMain() {
		RecipeVO recipeVO = new RecipeVO();
		
		for(int i=0; i<200; i++) {
			recipeVO.setRecipe_id("recipe"+i);
			/* recipeVO.setMember_user_id("'MATERIAL' || MATERIAL_ID_SEQ.nextval"); */
			recipeVO.setMember_user_id("test1@test.com");
			recipeVO.setRecipe_name("짜장면");
			recipeVO.setRecipe_contents("짜장면을 만들어 보았습니다.");
			recipeVO.setRecipe_category("면");
			recipeVO.setRecipe_what_situation("혼자 밥 먹을 때");
			recipeVO.setRecipe_method("볶아서");
			recipeVO.setRecipe_material("볶음밥, 밥");
			recipeVO.setRecipe_how_many("2명");
			recipeVO.setRecipe_how_long("1시간");
			recipeVO.setRecipe_difficulty("전문가");
			recipeVO.setRecipe_tag("안녕#혼밥#짜장");
			int result = recipeDAO.inputRecipe(recipeVO);
			log.info("결과는" +result );
		}
		
	}
	
	@Test
	@DisplayName("레시피 입력-재료")
	@Disabled
	void materials(){
		MaterialVO materialVO = new MaterialVO();
		
		materialVO.setMaterial_title("된장");
		materialVO.setMaterial_contents("한 스푼");
		materialVO.setRecipe_recipe_id("1");
		
		int result = recipeDAO.inputMaterial(materialVO);
		log.info("결과는" +result );
		
	}
	
	@Test
	@DisplayName("레시피 입력-순서")
	@Disabled
	void steps() {
		StepVO stepVO = new StepVO();
		stepVO.setStep_id("s_002");
		stepVO.setStep_contents("자장을 반으로 갈라");
		stepVO.setStep_picture(null);
		stepVO.setRecipe_recipe_id(1);
		
		int result = recipeDAO.inputStep(stepVO);
		log.info("결과는" +result );
	}

	@Test
	@DisplayName("레시피 아이디 받아오기")
	@Disabled
	void getRecipeId() {
		log.info(recipeDAO.getRecipeId());
	}
	@Test
	@DisplayName("마이페이지 레시피 리스트 가져오기")
//	@Disabled
	void chkMypageList() {
		String member_id = "test1@test.com";
		log.info("chkd: "+recipeDAO.onlyRecipeList(member_id));
	}
	
}
