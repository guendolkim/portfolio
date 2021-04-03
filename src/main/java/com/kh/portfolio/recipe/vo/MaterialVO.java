package com.kh.portfolio.recipe.vo;

import java.util.List;

import lombok.Data;

@Data
public class MaterialVO {
	private String material_id;
	private String material_title;
	private String material_contents;
	private String recipe_recipe_id;
	
	private List<MaterialVO> listMaterialVO;
}
