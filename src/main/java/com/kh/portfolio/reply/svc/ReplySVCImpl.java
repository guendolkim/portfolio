package com.kh.portfolio.reply.svc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.portfolio.common.paging.PageCriteria;
import com.kh.portfolio.reply.dao.ReplyDAO;
import com.kh.portfolio.reply.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplySVCImpl implements ReplySVC {
	final ReplyDAO replyDAO;
	final PageCriteria pc;
	//댓글작성
	@Override
	public int write(ReplyVO replyVO) {
		return replyDAO.write(replyVO);
	}
	
	//댓글목록
	@Override
	public Map<String, Object> list(long recipenum, int reqPage) {
		Map<String,Object> map = new HashMap<>();

		//1)요청페이지
		pc.getRc().setReqPage(reqPage);
		//2)총레코드정보
		pc.setTotalRec(replyDAO.totalRecordCount(recipenum));
		//3)페이징계산
		pc.calculatePaging();
		
		//4)목록가져오기
		int startRec  = pc.getRc().getStartRec();
		int endRec 		= pc.getRc().getEndRec();
		List<ReplyVO> list = replyDAO.list(recipenum, startRec, endRec);
		
		//5)map객체에 게시글 목록, pc담기
		map.put("list", list);
		map.put("pc",pc);
		
		return map;		
	}

	//댓글조회
	@Override
	public ReplyVO replyView(long recipenum) {
		
		return null;
	}

	//댓글 수정
	@Override
	public int modify(ReplyVO replyVO) {
		
		return replyDAO.modify(replyVO);
	}

	//댓글 삭제
	@Override
	public int delete(long recipenum) {
		
		return replyDAO.delete(recipenum);
	}

	//대댓글 작성
	@Override
	public int reReply(ReplyVO replyVO) {
		//1)부모글 정보 읽어오기
		ReplyVO parentReplyVO  = replyDAO.replyView(replyVO.getPrnum());
		//2)이전댓글 step업데이트
		replyDAO.updateStep(parentReplyVO.getRgroup(), parentReplyVO.getRstep());
		//3)대댓글작성
		replyVO.setRecipenum(parentReplyVO.getRecipenum());
		replyVO.setRgroup(parentReplyVO.getRgroup());
		replyVO.setRstep(parentReplyVO.getRstep());
		replyVO.setRindent(parentReplyVO.getRindent());
		//4)부모댓글 아이디
		replyVO.setPrid(parentReplyVO.getPrid());
		//5)부모댓글 별칭
		replyVO.setPrnickname(parentReplyVO.getPrnickname());
		
		return replyDAO.reReply(replyVO);
	}

	//총 레코드
	@Override
	public int totalRecordCount(long recipenum) {
		
		return replyDAO.totalRecordCount(recipenum);
	}

}
