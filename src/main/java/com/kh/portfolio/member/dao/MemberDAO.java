package com.kh.portfolio.member.dao;

import com.kh.portfolio.member.vo.MemberVO;

public interface MemberDAO {
	//회원등록
	int joinMember(MemberVO memberVO);
	
	//아이디 유무 확인
	int userChk(String user_id);
	
	//회원 수정
	int modifyMember(MemberVO memberVO);	
	//회원 전체 조회
	
	//회원 개별조회
	MemberVO listOneMember(String user_id);
	
	//회원 탈퇴
	int outMember(String user_id, String currentpw);	
	
	//회원 존재
	boolean existMember(String user_id);
	
	//회원 인증
	boolean isMember(String user_id, String pw);
	
	//회원 비밀번호변경
	int	changePw(String user_id, String currentpw, String nextpw);
	
	//회원 아이디 찾기 by(전화번호,생년월일)
	String findMemberId(String user_tel,String user_birth);
	
	//비밀번호찾기
	String findPW(String user_id,String user_tel,String user_birth);	
	
	//프로파일 이미지 조회
	byte[] findProfileImg(String user_id) throws Exception;
	
		
}
