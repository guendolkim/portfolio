package com.kh.portfolio.common.svc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.common.dao.CodeDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class CodeSVCImplTest {

	@Autowired
	CodeDAO codeDAO;
	
	@Test
	@DisplayName("코드타입 검사")
	void getCode() {
		String str = "1000";
		log.info("값은 : "+codeDAO.getCodesByCodetype(str));
	}
}
