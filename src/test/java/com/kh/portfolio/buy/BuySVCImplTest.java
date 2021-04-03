package com.kh.portfolio.buy;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.buy.dao.BuyDAO;
import com.kh.portfolio.buy.svc.BuySVC;
import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
@Slf4j
public class BuySVCImplTest {
	@Autowired
	public BuySVC buySVC;
	
	@Test
	@DisplayName("카트에 삽입하기")
//	@Disabled
	void insertCart() {
		CartVO cartVO = new CartVO();
		cartVO.setCart_id("CART_ID_SEQ.nextval");
		cartVO.setItem_item_id("item_006");
		cartVO.setMember_user_id("test1@test.com");
		int result = buySVC.insertCart(cartVO);
		log.info("res ult 는"+result);
	}
}
