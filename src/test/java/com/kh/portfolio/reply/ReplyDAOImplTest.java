package com.kh.portfolio.reply;



import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.reply.dao.ReplyDAO;
import com.kh.portfolio.reply.vo.ReplyVO;


import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })

@Slf4j
public class ReplyDAOImplTest {
	
	@Autowired
	public ReplyDAO replyDAO;
	
	@Test
	@DisplayName("댓글작성")
	@Disabled
	void createReply() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setRnum(1);
		replyVO.setRecipenum("1");
		replyVO.setMemberid("test3@test.com");
		replyVO.setRcontent("hihi");
		replyDAO.write(replyVO);
	}
	@Test
	@DisplayName("댓글목록")
	@Disabled
	void replyTest() {
		List<ReplyVO> list = replyDAO.list(1,1,1);
		log.info("i 값은? " + list);
	}
	@Test
	@DisplayName("토탈 레코듯수")
	@Disabled
	void total() {
		int recipenum = 1;
		int i = replyDAO.totalRecordCount(recipenum);
		
		log.info("i는 "+i);
	}
	@Test
	@DisplayName("댓글조회")
	@Disabled
	void search() {
		long rnum = 1;
		ReplyVO replyVO = (ReplyVO)(replyDAO.replyView(rnum));
		log.info("replyVO는:" + replyVO);
	}
	@Test
	@DisplayName("댓글수정")
	@Disabled
	void modify() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setRcontent("안녕하세용");
		replyVO.setRnum(21);
		replyVO.setMemberid("test2@test.com");
		
		int i = replyDAO.modify(replyVO);
		log.info("i는"+i);
	}
	@Test
	@DisplayName("댓글delete")
	@Disabled
	void delete() {
		ReplyVO replyVO = new ReplyVO();
		
		int i = replyDAO.delete(5);
		log.info("i는"+i);
	}
	@Test
	@DisplayName("대댓글 작성")
	@Disabled
	void reply() {
		ReplyVO replyVO = new ReplyVO();

	
        replyVO.setRecipenum("1");
		replyVO.setMemberid("test2@test.com");
		replyVO.setRnickname("일류주방장");
		replyVO.setRcontent("두 번째 댓글");
		replyVO.setRgroup(21);
		replyVO.setRstep(0);
		replyVO.setRindent(0);
		replyVO.setPrnum((long) 21);
		replyVO.setPrid("test1@test.com");
		replyVO.setPrnickname("no");

		int i = replyDAO.reReply(replyVO);
		log.info("i는"+i);
	}
	@Test
	@DisplayName("이전댓글 step업데이트")
	@Disabled
	void updateStep() {
		ReplyVO replyVO = new ReplyVO();
		
		int i = replyDAO.updateStep(21, 0);
		
		log.info("i는"+i);
	}
}
