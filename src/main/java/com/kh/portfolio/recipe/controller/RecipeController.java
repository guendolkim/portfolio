package com.kh.portfolio.recipe.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.portfolio.common.paging.PageCriteria;
import com.kh.portfolio.common.svc.CodeSVC;
import com.kh.portfolio.member.vo.MemberVO;
import com.kh.portfolio.recipe.svc.RecipeSVC;
import com.kh.portfolio.recipe.vo.MaterialVO;
import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/recipe")
@Slf4j
@RequiredArgsConstructor
public class RecipeController {
	final RecipeSVC recipeSVC;
	final CodeSVC codeSVC;
	
	//레시피 등록 selector관련된 자료.
	@ModelAttribute
	public void recipeEnroll(Model model){
		model.addAttribute("kind", codeSVC.getCodesByCodetype("1000"));
		model.addAttribute("situation", codeSVC.getCodesByCodetype("1010"));
		model.addAttribute("way", codeSVC.getCodesByCodetype("1020"));
		model.addAttribute("material", codeSVC.getCodesByCodetype("1030"));
		model.addAttribute("people", codeSVC.getCodesByCodetype("1040"));
		model.addAttribute("time", codeSVC.getCodesByCodetype("1050"));
		model.addAttribute("difficulty", codeSVC.getCodesByCodetype("1060"));
	}
	
	/**
	 * 레시피 리스트 출력
	 * @param model
	 * @return
	 */
	@GetMapping({"/recipeList",
				"/recipeList/{reqPage}"})
	public String recipeList(@PathVariable(value="reqPage", required = false) Optional<Integer> reqPage,
								Model model) { //
		Map<String, Object> map = recipeSVC.list(reqPage.orElse(1));
		
		log.info("recipeList 넘어왔는가?"+(List<RecipeVO>)(map.get("recipeList")));
		//게시글 목록
		model.addAttribute("recipeList",(List<RecipeVO>)(map.get("recipeList")));
			
		//페이징 정보     
		model.addAttribute("pc", (PageCriteria)(map.get("pc")));
		
		return "/recipe/recipeList";
	}
	
	/**
	 * 레시피 상세 페이지 출력
	 * @param model
	 * @return
	 */
	@GetMapping("/recipeDetail/{recipeNum}")
	public String recipeDetail(
			@PathVariable(value="recipeNum") String recipeNum,
			Model model) {
		Map<String, Object> map = recipeSVC.recipeDetail(recipeNum);
		
		//svc에서 받아온 map값을 model로 다시 보내기 위한 작업
		RecipeVO recipeVO = (RecipeVO)map.get("recipe");
		List<MaterialVO> materialVO = (List<MaterialVO>)map.get("material");
		List<StepVO> stepVO = (List<StepVO>)map.get("step");
		//model로 jsp로 넘겨주기 위해서 작업
		log.info("가져온 레시피 숫자는 :" + recipeNum);
		model.addAttribute("recipeVO", recipeVO);
		model.addAttribute("materialVO", materialVO);
		model.addAttribute("stepVO", stepVO);
		//레시피 조회수 증가
		recipeSVC.recipeViewCount(recipeNum);
		
		return "/recipe/recipeDetail";
	}
	
	/**
	 * 레시피 등록 양식 불러오기 
	 * @return
	 */
	@GetMapping("/recipeForm")
	public String recipeForm(Model model) {
		RecipeVO recipeVO = new RecipeVO();
		
		model.addAttribute("recipeVO", recipeVO);
		model.addAttribute("recipe_id_seq", recipeSVC.getRecipeId());
		return "/recipe/recipeForm";
	}
	

	/**
	 * 레시피 저장하기
	 * @return
	 */
	@ResponseBody
	@PostMapping(value="/recipeLike",		
			consumes = "application/json", 
			produces = "application/json")
	public ResponseEntity<Map<String,String>> recipeLike(
							@RequestBody Map<String, String> param){
		Map<String,String> map = new HashMap<String, String>();
		String user_id = param.get("user_id");
		String recipe_id = param.get("recipe_id");
		log.info("user_id는"+param.get("user_id"));
		log.info("user_id는"+param.get("recipe_id"));
		int result = recipeSVC.recipeLike(user_id, recipe_id);

		//result == 1이면 
		if(result == 1) {
			map.put("rtcd", "00");
			return new ResponseEntity<Map<String, String>>(map,HttpStatus.OK);
		}else {
			map.put("rtcd", "01");
			return new ResponseEntity<Map<String, String>>(map,HttpStatus.OK);
		}
	}
	
	/**
	 * 레시피 등록 처리
	 * @return
	 */
	@PostMapping("/recipeSave")
	public String recipeSave(
			@ModelAttribute RecipeVO recipeVO,
			@ModelAttribute MaterialVO materialVO,
			@ModelAttribute StepVO stepVO,
			BindingResult errResult) {
		
		log.info("recipeVO 값은?"+ recipeVO);
		log.info("materialVO 값은?"+ materialVO);
		log.info("stepVO 값은?"+ stepVO);
		
		int result = recipeSVC.recipeEnroll_recipe(recipeVO, materialVO, stepVO);
		log.info("result 값은? " + result);
		
		if(result == 1) {
			log.info("레시피 등록 성공!");
			return "redirect:/recipe/recipeList";
		}else {
			log.info("레시피 등록 실패!");
			return "redirect:";
		}

	}
}
