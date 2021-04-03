package com.kh.portfolio.buy.vo;

import lombok.Data;

@Data
public class CartVO {
	private String cart_id;//CART_ID	VARCHAR2(40 BYTE)
	private String item_item_id;//ITEM_ITEM_ID	VARCHAR2(40 BYTE)
	private int item_quantity;//ITEM_QUANTITY	NUMBER(38,0)
	private int sum_price;//SUM_PRICE	CHAR(10 BYTE)
	private String member_user_id;//MEMBER_USER_ID	VARCHAR2(40 BYTE)
}
