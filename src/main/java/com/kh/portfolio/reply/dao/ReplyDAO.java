package com.kh.portfolio.reply.dao;

import java.util.List;

import com.kh.portfolio.reply.vo.ReplyVO;

public interface ReplyDAO {

	//댓글작성
	int write(ReplyVO replyVO);
	
	//댓글수정
	int modify(ReplyVO replyVO);
	
	//댓글삭제
	int delete(long recipenum);
	
	//댓글조회
	ReplyVO replyView(long rnum);
	
	//댓글목록
	List<ReplyVO> list(long recipenum, long startRec, long endRec);

	
	//대댓글 작성
	int reReply(ReplyVO replyVO);
	//이전댓글 step업데이트
	int updateStep(int rgroup, int rstep);
	
	/*
	 * //호감,비호감 int vote(VoteVO voteVO);
	 * 
	 * //호감,비호감 카운트 VoteCntVO voteCnt(Long rnum);
	 */

	//총레코드
	int totalRecordCount(long recipenum);
}
