package com.kh.portfolio.recipe.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RecipeVO {
	private String recipe_id;
	private String member_user_id;
	private String recipe_name;
	private String recipe_contents;
	private String recipe_view_count;
	private String recipe_like_count;
	private Timestamp recipe_c_date;
	private Timestamp recipe_u_date;
	private String recipe_category;
	private String recipe_what_situation;
	private String recipe_method;
	private String recipe_material;
	private String recipe_how_many;
	private String recipe_how_long;
	private String recipe_difficulty;
	private String recipe_tag;
	
	
	private byte[] recipe_main;
	private MultipartFile file;
	private String picBase64;
	/*
	 * private String step_id; private long step_sequence; private String
	 * step_contents; private byte[] step_picture; private String recipe_recipe_id;
	 */
	
}
