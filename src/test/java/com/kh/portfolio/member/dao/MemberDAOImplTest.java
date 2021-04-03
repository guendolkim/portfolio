package com.kh.portfolio.member.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.member.vo.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOImplTest {

	private final static Logger logger
		= LoggerFactory.getLogger(MemberDAOImplTest.class);
	
	@Autowired
	MemberDAO memberDAO;
	
	@Autowired
	JdbcTemplate jt;
	
	@Test
	@DisplayName("회원 가입")
	@Disabled
	void joinMember() {
		MemberVO memberVO = new MemberVO();
	
		memberVO.setUser_email("test2@test.com");
		memberVO.setUser_pw("1234");
		memberVO.setUser_tel("010-1234-5678");
		memberVO.setUser_nickname("테스터1");
		memberVO.setUser_gender("남");
		memberVO.setUser_birth(LocalDate.of(2001, 01, 01));
		
		int result = memberDAO.joinMember(memberVO);
		
		logger.info("cnt:"+result);
	}
	
	@Test
	@DisplayName("회원개별조회")
	@Disabled
	void listOneMember() {
		String id = "test2@test.com";
		MemberVO memberVO = memberDAO.listOneMember(id);
		logger.info(memberVO.toString());
	}
	@Test
	@DisplayName("회원존재유무")
	@Disabled
	void existMember() {
		String id = "test2@test.com";
		logger.info("회원존재유무:"+memberDAO.existMember(id));
	}
	@Test
	@DisplayName("회원인증")
	@Disabled
	void isMember() {
		String id = "test2@test.com";
		String pw = "1234";
		logger.info("회원인증:"+memberDAO.isMember(id,pw));
	}
	@Test
	@DisplayName("회원수정")
	@Disabled
	void modifyMember() {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setUser_tel("010-1111-1111");
		memberVO.setUser_nickname("관리자2");
		memberVO.setUser_gender("여");
		memberVO.setUser_birth(LocalDate.of(2020, 01, 01));
		memberVO.setUser_email("test2@test.com");
		memberVO.setUser_pw("1234");
		int result = memberDAO.modifyMember(memberVO);
		logger.info("회원수정:" + result);
	}
	
	@Test
	@DisplayName("회원비밀번호 변경")
	@Disabled
	void changePw() {
		String id = "test2@test.com";
		String currentpw = "1234";
		String nextpw = "4321";
		int result = memberDAO.changePw(id, currentpw, nextpw);
		
		logger.info("비밀번호 변경:" + result);
	}
	
	@Test
	@DisplayName("회원탈퇴")
	@Disabled
	void outMember() {
		String id = "test2@test.com";
		String currentpw = "4321";
		int result = memberDAO.outMember(id, currentpw);
		
		logger.info("회원탈퇴됨" + result);
	}
	
//	@Test
//	@DisplayName("batchInsert")
//	@Disabled
//	void batchInsert() {
//		
//		String id = "test@test.com";
//		List<String> hobbys = List.of("01","02","03");
//
//		String sql = "insert into hobby values( ? , ? )";
//		
//		int[] result = jt.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				ps.setString(1,hobbys.get(i));
//				ps.setString(2,id);
//			}
//			
//			@Override
//			public int getBatchSize() {
//				return hobbys.size();
//			}
//		});
//		
//		logger.info(hobbys.toString());
//		logger.info(result.toString());
//		
//		
//	}
	
	
	@Test
	@DisplayName("회원 아이디 찾기")
	@Disabled
	void findMemberID() {
		String tel = "010-1234-5678";
		String birth = "20010101";
//		Assertions.assertThrows(
//				EmptyResultDataAccessException.class, 
//				() -> {
//					memberDAO.findMemberId(tel, birth);
//				}
//		);
		String name = memberDAO.findMemberId(tel, birth);
		logger.info("찾은 비밀번호는 :" + name);
	}
	
	@Test
	@DisplayName("비밀번호 찾기")
//	@Disabled
	void findPw() {
		String member_id = "test1@test.com"; 
		String tel = "010-5678-9876";
		String birth = "1990-03-03";

//		Assertions.assertThrows(
//				EmptyResultDataAccessException.class, 
//				() -> {
//					memberDAO.findPW(member_id, tel, birth);
//				}
//		);
		String pw = memberDAO.findPW(member_id, tel, birth);
		logger.info("찾은 비밀번호는 :" + pw);
	}
	
}







