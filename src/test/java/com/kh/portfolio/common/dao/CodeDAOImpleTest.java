package com.kh.portfolio.common.dao;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.common.vo.CodeVO;
import com.kh.portfolio.jdbctemplatetest.SelectJdbcTemplateTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class CodeDAOImpleTest {


	@Autowired
	CodeDAO codeDAO;

	@Test
	@DisplayName("코드목록조회by코드유형")
	void getCodesByCodetype() {
		
		List<CodeVO> list = codeDAO.getCodesByCodetype("1000");
		log.info("값이 안나오나요?");
		log.info("값은? " + list.toString());
		for(CodeVO list2 : list) {
			log.info(list2.toString());
		}
		
	}
	
}














