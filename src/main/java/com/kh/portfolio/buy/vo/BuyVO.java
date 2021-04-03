package com.kh.portfolio.buy.vo;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BuyVO {

private String item_id;//	ITEM_ID	VARCHAR2(40 BYTE)
private String item_name;//	ITEM_NAME	VARCHAR2(50 BYTE)
private String item_contents;//	ITEM_CONTENTS	CLOB
private int item_price;//	ITEM_PRICE	NUMBER(10,0)
private int item_stock;//	ITEM_STOCK	NUMBER(10,0)
private Timestamp item_c_date;//	ITEM_C_DATE	DATE
private Timestamp item_u_date;//	ITEM_U_DATE	DATE
private int item_view_count;//	ITEM_VIEW_COUNT	NUMBER(10,0)
private int item_sell_count;//	ITEM_SELL_COUNT	NUMBER(10,0)
private int item_review_count;//	ITEM_REVIEW_COUNT	NUMBER(10,0)
private int item_review_average;//	ITEM_REVIEW_AVERAGE	NUMBER(10,0)
private String item_unit;		
private String item_weight;	
private String item_delivery;	
private String item_package;	
private String item_mention; 	
private String item_country;
private MultipartFile item_file;
private String item_fsize;
private String item_ftype;
private String item_fname;
private byte[] item_photo;
}
