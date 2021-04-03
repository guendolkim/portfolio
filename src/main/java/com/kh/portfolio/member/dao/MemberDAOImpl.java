package com.kh.portfolio.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.common.vo.CodeVO;
import com.kh.portfolio.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger
		= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("int joinMember(MemberVO memberVO) 호출됨!" + memberVO );
		int result = 0;
		
		//sql문 생성
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member ( ");
		sql.append("user_id, ");    //이건 일렬번호
		sql.append("user_seq, "); //이건 아이디로 사용
		sql.append("user_pw, ");
		sql.append("user_tel, ");
		sql.append("user_nickname, ");
		sql.append("user_birth, ");
		sql.append("user_gender)  ");
		sql.append("VALUES ( ");
		sql.append("?, ");
		sql.append("'user_' || MEMBER_ID_SEQ.nextval, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?, ");
		sql.append("?) ");
		
		//sql문 실행
		result = jdbcTemplate.update(
				sql.toString(),
				memberVO.getUser_id(),
				memberVO.getUser_pw(),
				memberVO.getUser_tel(),
				memberVO.getUser_nickname(),
				memberVO.getUser_birth(),
				memberVO.getUser_gender());
		
		return result;
	}

	//유저 아이디 확인
	@Override
	public int userChk(String user_id) {
		
		return jdbcTemplate.queryForObject(
				"select user_id from member where user_id = ? ", 
				Integer.class, user_id);
	}
	
	// 회원 수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		
		//나중에 이거 체크하기
		//프로파일 이미지가 없으면 return되는 modifyMemberNoFile를 실행하고, 
//		if(memberVO.getFile().getSize() == 0) {
//			
//			return modifyMemberNoFile(memberVO);			
//		}
		
		//이건 뭐지
		StringBuilder sql = new StringBuilder();
		sql.append("update member set ");
		sql.append("       user_tel = ?, ");
		sql.append("       user_nickname = ?, ");
		sql.append("       user_gender = ?, ");
		sql.append("       user_birth = ?, ");
		sql.append("       user_udate = systimestamp, ");
		sql.append("       user_photo = ?, ");
		sql.append("       user_fsize = ?, ");
		sql.append("       user_ftype = ?, ");
		sql.append("       user_fname = ? ");
		sql.append("where  user_id = ? ");
		sql.append("  and  user_pw = ? ");
		
		logger.info("DAO : int modifyMember(MemberVO memberVO) " + memberVO);
		
		result = jdbcTemplate.update(
						sql.toString(),
						memberVO.getUser_tel(),
						memberVO.getUser_nickname(),
						memberVO.getUser_gender(),
						memberVO.getUser_birth(),								
						memberVO.getUser_photo(),
						memberVO.getUser_fsize(),
						memberVO.getUser_ftype(),
						memberVO.getUser_fname(),
						memberVO.getUser_id(),
						memberVO.getUser_pw());
		return result;
	}

	//회원수정 : 프로파일사진이 없는경우
	private int modifyMemberNoFile(MemberVO memberVO) {
		int result = 0;
			
		StringBuilder sql = new StringBuilder();
		sql.append("update member set ");
		sql.append("       user_tel = ?, ");
		sql.append("       user_nickname = ?, ");
		sql.append("       user_gender = ?, ");
		sql.append("       user_birth = ?, ");
		sql.append("       user_udate = systimestamp ");
		sql.append("where  user_id = ? ");
		sql.append("  and  user_pw = ? ");
				
		result = jdbcTemplate.update(
									sql.toString(),
									memberVO.getUser_tel(),
									memberVO.getUser_nickname(),
									memberVO.getUser_gender(),
									memberVO.getUser_birth(),								
									memberVO.getUser_id(),
									memberVO.getUser_pw());
		return result;
	}

	//회원 개별조회
	@Override
	public MemberVO listOneMember(String user_id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from member ");
		sql.append("where user_id = ?");
		
		MemberVO memberVO =	jdbcTemplate.queryForObject(
							sql.toString(), 
							new BeanPropertyRowMapper<MemberVO>(MemberVO.class), user_id);	
		return memberVO;
	}

	//회원 삭제
	@Override
	public int outMember(String user_id, String currentpw) {
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from member ");
		sql.append(" where user_id = ? ");
		sql.append("   and user_pw = ? ");		
		
		result = jdbcTemplate.update(sql.toString(), user_id, currentpw);	
		return result;
	}

	//회원 존재
	@Override
	public boolean existMember(String user_id) {
		boolean result = false;
		String sql ="select count(*) cnt from member where user_id = ? ";
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class, user_id);
		result = (cnt == 1) ? true : false;		
		return result;
	}

	//회원 인증
	@Override
	public boolean isMember(String user_id, String user_pw) {
		boolean result = false;
		String sql ="select count(*) cnt from member where user_id = ? and user_pw = ?";
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class, user_id, user_pw);
		result = (cnt == 1) ? true : false;		
		return result;
	}

	//회원비밀번호 변경
	@Override
	public int changePw(String user_id, String currentpw, String nextpw) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("update member ");
		sql.append("   set user_pw = ? ");
		sql.append(" where user_id = ? ");
		sql.append("   and user_pw = ? ");		
		
		int result = jdbcTemplate.update(sql.toString(), nextpw, user_id, currentpw);
		
		return result;
	}

	//회원 아이디 찾기 by(전화번호,생년월일)
	@Override
	public String findMemberId(String user_tel, String user_birth) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select user_email from member ");
		sql.append(" where user_tel = ? ");
		sql.append("   and user_birth = ? ");
		
		return jdbcTemplate.queryForObject(sql.toString(),String.class, user_tel, user_birth);
	}

	//회원 비밀번호 찾기???
	@Override
	public String findPW(String user_id, String user_tel, String user_birth) {
		StringBuilder sql = new StringBuilder();		
		
		sql.append("select user_pw ");
		sql.append("  from member ");
		sql.append(" where user_id = ? ");
		sql.append("   and user_tel = ? ");
		sql.append("   and user_birth = ? ");
		
		return jdbcTemplate.queryForObject(sql.toString(),String.class, user_id, user_tel, user_birth);
	}
	
	//프로파일 이미지 조회
	@Override
	public byte[] findProfileImg(String user_id) throws Exception {
		String sql = "select user_photo from member where user_id = ? ";
		
		byte[] bytes = jdbcTemplate.queryForObject(sql, 
				new RowMapper<byte[]>() {
					@Override
					public byte[] mapRow(ResultSet rs, int rowNum) throws SQLException {
						byte[] bytes = rs.getBytes(1);	
						return bytes;
					}
				},
				user_id);
		return bytes;
	}
}


















