package com.kh.portfolio.recipe.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StepVO {
	private String step_id;
	private long   step_sequence;
	private String step_contents;
	private byte[] step_picture;
	private String recipe_recipe_id;
	private MultipartFile file;
	private List<StepVO> listStepVO;
	private String picBase64;
}
