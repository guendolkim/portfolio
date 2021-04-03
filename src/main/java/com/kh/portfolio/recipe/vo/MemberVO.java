package com.kh.portfolio.recipe.vo;

import java.sql.Timestamp;
import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberVO {
	private long user_id;
	private String user_pw;
	private String user_tel;
	private String user_nickname;
	private String user_gender;
	private String user_address;
	private LocalDate user_birth;
	private Timestamp user_cdate;
	private Timestamp user_udate;
	private byte[] user_photo;
	private String user_contents;
	
//	private MultipartFile file;   //view에서 첨부파일을 바인딩하기위해 필요
//	private String fsize;
//	private String ftype;
//	private String fname;
//	private byte[] pic;
//	
//	
//	private String picBase64;
}
