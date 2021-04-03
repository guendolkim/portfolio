package com.kh.portfolio.member.svc;


import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC {

	private static final Logger logger
		= LoggerFactory.getLogger(MemberSVCImpl.class);
	
	private final MemberDAO memberDAO;

	
	//회원등록
	@Transactional
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("int joinMember(MemberVO memberVO) 호출됨!" + memberVO);
		
		return memberDAO.joinMember(memberVO);
	}
	
	//아이디 유무 확인
	@Override
	public int userChk(String user_id) {
		
		return memberDAO.userChk(user_id);
	}
	
	//회원 기본사진 등록
//	@Override
//	public int inputProfile(MemberVO memberVO) {
//		memberVO.setFile(file);
//		return 0;
//	}
	
	//회원수정
	@Transactional
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		
//나중에 프로필 어떻게 할 지 생각하고 수정하기 기본 프로필을 설정하고 나중에 변경할까
		
		//첨부 파일 존재시(회원프로파일사진) multipartfile에서 첨부파일관련 정보 추출
		if(memberVO.getFile().getSize() > 0) {

			try {
				//파일사이즈
				memberVO.setUser_fsize(String.valueOf(memberVO.getFile().getSize()));
				//파일타입
				memberVO.setUser_ftype(memberVO.getFile().getContentType());
				//파일이름
				memberVO.setUser_fname(memberVO.getFile().getOriginalFilename());
				//첨부파일
				memberVO.setUser_photo(memberVO.getFile().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return  memberDAO.modifyMember(memberVO);
	}

	//회원 개별조회
	@Override
	public MemberVO listOneMember(String user_id) {
		MemberVO memberVO = memberDAO.listOneMember(user_id);
		
		//프로파일사진이 있으면 이미지파일 -> base64변환
		if(memberVO.getUser_photo() != null) {
			memberVO.setPicBase64(conversionToBase64(memberVO.getUser_photo()));
		}
		return memberVO;
	}

	//이미지 base64로 변환후 img태그에 적용하기위함
	//Base64의 핵심은 바이너리 데이터를 ASCII코드로 변경하는 인코딩방식
	private String conversionToBase64(byte[] pic) {
		byte[] encoded = Base64.encodeBase64(pic);
		return new String(encoded);
	}

	//회원 탈퇴
	@Override
	public int outMember(String user_id, String currentpw) {

		return memberDAO.outMember(user_id, currentpw);
	}

	//회원 존재
	@Override
	public boolean existMember(String user_id) {
		
		return memberDAO.existMember(user_id);
	}

	//회원 인증
	@Override
	public boolean isMember(String user_id, String user_pw) {
		
		return memberDAO.isMember(user_id, user_pw);
	}

	//회원 비밀번호 변경
	@Override
	public int changePw(String user_id, String currentpw, String nextpw) {
		
		return memberDAO.changePw(user_id, currentpw, nextpw);
	}

	//회원 아이디 찾기 by(전화번호,생년월일)
	@Override
	public String findMemberId(String user_tel, String user_birth) {

		return memberDAO.findMemberId(user_tel, user_birth);
	}

	@Override
	public String findPW(String user_id, String user_tel, String user_birth) {

		return memberDAO.findPW(user_id, user_tel, user_birth);
	}

	//회원 이미지 찾기?
	@Override
	public byte[] findProfileImg(String user_id) throws Exception {

		return memberDAO.findProfileImg(user_id);
	}
	
	@Override
	public int inputProfile(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}


}
