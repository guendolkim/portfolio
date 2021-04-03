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
import com.kh.portfolio.buy.vo.BuyVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
@Slf4j
public class BuyDAOImplTest {

	@Autowired
	public BuyDAO buyDAO;
	@Test
	@DisplayName("키워드 가져오기")
	@Disabled
	void getKeyword() {
		String exam = "김치";
		List<BuyVO> keyword = buyDAO.keywordSearch(exam);
		log.info("리스트 목록은 "+keyword);
	}
	
	@Test
	@DisplayName("장바구니에 있나 물건이")
	@Disabled
	void chkInitem() {
		
		String item_id = "item_001";
		String user_id = "test122@test.com";
		
		String result = buyDAO.chkIncart(item_id, user_id);
		log.info(result);
	}
	

	@Test
	@DisplayName("장바구니에 물건 담기")
//	@Disabled
	void insertCart() {
		
		String item_id = "item_002";
		String user_id = "test1@test.com";
		
		int result = buyDAO.insertCart(item_id, user_id);
		log.info("값은?"+result);
	}
	
}
