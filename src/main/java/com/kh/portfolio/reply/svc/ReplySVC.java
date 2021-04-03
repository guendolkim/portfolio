package com.kh.portfolio.reply.svc;

import java.util.List;
import java.util.Map;

import com.kh.portfolio.reply.vo.ReplyVO;

public interface ReplySVC {

	//댓글작성
	int write(ReplyVO replyVO);
	
	//댓글목록
	Map<String,Object> list(long recipenum, int reqPage);

	//댓글조회
	ReplyVO replyView(long recipenum);
	
	//댓글수정
	int modify(ReplyVO replyVO);
		
	//댓글삭제
	int delete(long recipenum);
	
	//대댓글 작성
	int reReply(ReplyVO replyVO);
		
	//호감,비호감
//	VoteCntVO vote(VoteVO voteVO);

	//총레코드
	int totalRecordCount(long recipenum);	
}
