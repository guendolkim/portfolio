 package com.kh.portfolio.recipe.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.recipe.vo.MaterialVO;

import com.kh.portfolio.recipe.vo.RecipeVO;
import com.kh.portfolio.recipe.vo.StepVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class RecipeDAOImpl implements RecipeDAO {
	
	@Autowired
	JdbcTemplate jt = new JdbcTemplate();
	
	
	
	/**
	 * 레시피 리스트 출력
	 * @param RECIPE_ID
	 * @return
	 */
//	@Override
//	public List<RecipeVO> list() {
//		StringBuilder sql = new StringBuilder();
//		sql.append("select recipe_name,  ");
//		sql.append("    recipe_c_date,  ");
//		sql.append("    member_user_id,  ");
//		sql.append("    RECIPE_ID  "); //레시피 아이디를 추가
//		sql.append("from recipe  ");
//
//		return jt.query(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class));
//	}

	/**
	 * 작성한 레시피만 보여줄 리스트
	 * @return
	 */
	public List<RecipeVO> onlyRecipeList(String member_user_id){
		String sql = "select * from recipe where member_user_id = ? ";
		log.info("여기는 recipeDAO이고 memberuser 값은 넘어왔나?:"+member_user_id);
		List<RecipeVO> result = jt.query(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class), member_user_id);
		log.info("여기는 recipeDAO이고 지금 값은 넘어왔나?:"+result);
		return result;
	}
	
	/*
	 * 저장을 누른 레시피를 보여줄 리스트
	 */
	public List<RecipeVO> likeRecipeList(String user_id){
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from recipe ");
		sql.append("where recipe_id in ");
		sql.append("(select recipe_recipe_id ");
		sql.append("from recipe_like ");
		sql.append("where member_user_id = ? ) ");
		
		return jt.query(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class), user_id);
	}
	
	/**
	 * 메인에 보여줄 놈들
	 * 
	 */
	public List<RecipeVO> mainPageList(){
		StringBuilder sql = new StringBuilder();
		sql.append("select *  ");
		sql.append("from( ");
		sql.append("select row_number() over(order by recipe_c_date)as num, ");
		sql.append("        recipe_name, ");
		sql.append("        recipe_id, ");
		sql.append("        member_user_id, ");
		sql.append("        recipe_c_date ");
		sql.append("from recipe)t1 ");
		sql.append("where t1.num between 1 and 12 ");
		
		return jt.query(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class));
	}
	
	/**
	 * 페이징을 위한 리스트 출력
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	@Override
	public List<RecipeVO> list(int startRec, int endRec) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from ");
		sql.append("(select row_number() over (order by r1.recipe_c_date)as num, ");
		sql.append("        recipe_name, ");
		sql.append("        recipe_id, ");
		sql.append("        member_user_id, ");
		sql.append("        recipe_c_date ");
		sql.append("from recipe r1)t1 ");
		sql.append("where t1.num between ? and ? ");

		List<RecipeVO> result = jt.query(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class), startRec, endRec); 
		
		return result;
	}
	
	
	/**
	 * 상세레시피 출력-레시피
	 * @return
	 */
	@Override
	public RecipeVO recipe(String recipeNum) {
		StringBuilder sql = new StringBuilder();
		sql.append("select *  ");
		sql.append("from recipe ");
		sql.append("where recipe_id = ? ");
		
		return jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<RecipeVO>(RecipeVO.class), recipeNum);
	}

	/**
	 * 상세레시피 출력-재료
	 * @return
	 */
	@Override
	public List<MaterialVO> material(String recipeNum) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from material ");
		sql.append("where recipe_recipe_id = ? ");
		
		return jt.query(sql.toString(), new BeanPropertyRowMapper<MaterialVO>(MaterialVO.class), recipeNum);
	}

	/**
	 * 상세페이지 출력-조리 순서
	 * @return
	 */
	@Override
	public List<StepVO> step(String recipeNum) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("from step ");
		sql.append("where recipe_recipe_id = ? ");
		
		return jt.query(sql.toString(), new BeanPropertyRowMapper<StepVO>(StepVO.class), recipeNum);
	}

	/**
	 * 레시피 입력-레시피 메인
	 * @param RecipeVO
	 * @return
	 */
	@Override
	public int inputRecipe(RecipeVO recipeVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into recipe( ");
		sql.append("RECIPE_ID, ");
		sql.append("MEMBER_USER_ID, ");
		sql.append("RECIPE_MAIN, ");
		sql.append("RECIPE_NAME, ");
		sql.append("RECIPE_CONTENTS, ");
		sql.append("RECIPE_CATEGORY, ");
		sql.append("RECIPE_WHAT_SITUATION, ");
		sql.append("RECIPE_METHOD, ");
		sql.append("RECIPE_MATERIAL, ");
		sql.append("RECIPE_HOW_MANY, ");
		sql.append("RECIPE_HOW_LONG, ");
		sql.append("RECIPE_DIFFICULTY, ");
		sql.append("RECIPE_TAG) ");
		sql.append("values( ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("? ) ");
		try {
			return jt.update(sql.toString(), 
					recipeVO.getRecipe_id(),
					recipeVO.getMember_user_id(),
					recipeVO.getFile().getBytes(),
					recipeVO.getRecipe_name(),
					recipeVO.getRecipe_contents(),
					recipeVO.getRecipe_category(),
					recipeVO.getRecipe_what_situation(),
					recipeVO.getRecipe_method(),
					recipeVO.getRecipe_material(),
					recipeVO.getRecipe_how_many(),
					recipeVO.getRecipe_how_long(),
					recipeVO.getRecipe_difficulty(),
					recipeVO.getRecipe_tag());
		} catch (DataAccessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 레시피 입력-순서
	 * @param stepVO
	 * @return
	 */
	@Override
	
	public int inputStep(StepVO stepVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into step( ");
		sql.append("STEP_ID, ");
		sql.append("STEP_sequence, ");
		sql.append("STEP_CONTENTS, ");
		sql.append("STEP_PICTURE, "); 
		sql.append("RECIPE_RECIPE_ID) ");
		sql.append("values( ");
		sql.append("'STEP_' || STEP_ID_SEQ.nextval, ");
		sql.append(" STEP_SEQUENCE_SEQ.nextval, ");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ? ) ");
		
			int[] result = jt.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				try {
					
				ps.setNString(1, stepVO.getListStepVO().get(i).getStep_contents());
				ps.setBytes(2, stepVO.getListStepVO().get(i).getFile().getBytes());
				ps.setString(3, stepVO.getListStepVO().get(i).getRecipe_recipe_id());
				}
				catch(Exception E) {
					
				}
			}
			
			@Override
			public int getBatchSize() {
				
				return stepVO.getListStepVO().size();
			}
		});
		int cnt = 1;
		for(int j : result) {
			cnt *= j;
		}
		if(cnt == 1) {
			return 1;
		}else {
			return 0;
		}
	}

	/**
	 * 레시피 입력-재료
	 * @param materialVO
	 */
	@Override
	public int inputMaterial(MaterialVO materialVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into material( ");
		sql.append("material_id, ");
		sql.append("material_title, ");
		sql.append("material_contents, ");
		sql.append("recipe_recipe_id ) ");
		sql.append("values( ");
		sql.append("'MATERIAL_' || MATERIAL_ID_SEQ.nextval, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("? ) ");
		
		int[] result = jt.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, materialVO.getListMaterialVO().get(i).getMaterial_title());
				ps.setString(2, materialVO.getListMaterialVO().get(i).getMaterial_contents());
				ps.setString(3, materialVO.getListMaterialVO().get(i).getRecipe_recipe_id());
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return materialVO.getListMaterialVO().size();
			}
		});
		int cnt = 1;
		for(int j : result) {
			cnt *= j;
		}
		if(cnt == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}
	

	/**
	 * recipe_id값 생성기.
	 */
	@Override
	public String getRecipeId() {
		
		return jt.queryForObject("select 'RECIPE_' || RECIPE_ID_SEQ.nextval from dual ", String.class);
	}
	
	/**
	 * 게시판 전체 레코드 수
	 * @return
	 */	
	@Override
	public long totalRecordCount() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as totalRecCnt ");
		sql.append("  from recipe ");
		
		return jt.queryForObject(sql.toString(), Long.class);
	}
	
	/**
	 * 레시피 좋아요 저장하기
	 */
	@Override
	public int recipeLike(String user_id, String recipe_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into recipe_like( ");
		sql.append("recipe_like_id, ");
		sql.append("recipe_recipe_id, ");
		sql.append("member_user_id) values( ");
		sql.append("RECIPE_LIKE_ID_SEQ.nextval, ");
		sql.append("?, ");
		sql.append("? ) ");
		
		return jt.update(sql.toString(),recipe_id,user_id);
	}
	/**
	 * 레시피 좋아요저장되어 있는 지 확인
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	@Override
	public int recipeInsertChk(String user_id, String recipe_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) ");
		sql.append("from recipe_like ");
		sql.append("where recipe_recipe_id = ? ");
		sql.append("and member_user_id = ? ");
		return jt.queryForObject(sql.toString(), Integer.class, recipe_id, user_id);
	}
	/**
	 * 레시피 좋아요저장되어 있는 지 확인
	 * @param user_id
	 * @param recipe_id
	 * @return
	 */
	@Override
	public int recipeLikeDelete(String user_id, String recipe_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from recipe_like ");
		sql.append("where recipe_recipe_id = ? ");
		sql.append("and member_user_id = ? ");
		return jt.queryForObject(sql.toString(), Integer.class, recipe_id, user_id);
	}
	/**
	 * 게시판 전체 레코드 수 (검색어 포함)
	 * @return
	 */	
	@Override
	public long totalRecordCount(String searchType, String keyWord) {
		StringBuilder sql = new StringBuilder();
		return 0;
	}
	
	/**
	 * 레시피 조회수 증가
	 * @param recipe_id
	 * @return
	 */
	@Override
	public int recipeViewCount(String recipe_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("update recipe ");
		sql.append("set recipe_view_count = recipe_view_count + 1 ");
		sql.append("where recipe_id = ? ");
		int result = jt.update(sql.toString(), recipe_id);
		
		return result;
	}
	
	
}
