package com.kh.portfolio.reply.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.reply.vo.ReplyVO;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class ReplyDAOImpl implements ReplyDAO {

	final JdbcTemplate jt;
	
	//댓글작성
	@Override
	public int write(ReplyVO replyVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into recipe_rboard(  ");
		sql.append("	  	rnum,  ");
		sql.append("	  	recipenum,  ");
		sql.append("	  	memberid,  ");
		sql.append("	  	rnickname,  ");
		sql.append("	  	rcontent, ");
		sql.append("	  	rgroup, ");
		sql.append("	  	rstep, ");
		sql.append("	  	rindent ");
		sql.append("	  )  ");
		sql.append("	  values(  ");
		sql.append("	  	rboard_rnum_seq.nextval,  ");
		sql.append("	  	?,  ");
		sql.append("	  	?,  ");
		sql.append("	  	?,  ");
		sql.append("	  	?,  ");
		sql.append("	  	rboard_rnum_seq.currval, ");
		sql.append("	  	0, ");
		sql.append("	  	0	  	 ");
		sql.append("	  ) ");
		return jt.update(sql.toString(), 
									replyVO.getRecipenum(),
									replyVO.getMemberid(),
									replyVO.getRnickname(),
									replyVO.getRcontent());
	}
	
	//댓글목록
	@Override
	public List<ReplyVO> list(long recipenum, long startRec, long endRec) {
		StringBuilder sql = new StringBuilder();
		sql.append("select   ");
		sql.append("			   t1.rnum,  ");
		sql.append("			   t1.recipenum,  ");
		sql.append("			   t1.memberid, t1.rnickname,  ");
		sql.append("			   t1.rcontent,  ");
		sql.append("			   t1.rcdate, t1.rudate,  ");
		sql.append("			   t1.rgroup, t1.rstep, t1.rindent,  ");
		sql.append("			   t1.prnum,  t1.prid,  t1.prnickname,  ");
		sql.append("			   nvl(t2.good,0) rgood,   ");
		sql.append("               nvl(t2.bad,0) rbad  ");
		sql.append("			  from  ");
		sql.append("			    (select *  ");
		sql.append("			       from(select row_number() over( order by rgroup desc,rstep asc ) as num,  ");
		sql.append("			                   t1.rnum,  ");
		sql.append("			                   t1.recipenum,  ");
		sql.append("			                   t1.memberid, t1.rnickname,  ");
		sql.append("			                   t1.rcontent,  ");
		sql.append("			                   t1.rcdate, t1.rudate,  ");
		sql.append("			                   t1.rgroup, t1.rstep, t1.rindent,  ");
		sql.append("			                   t1.prnum,  t1.prid,  t1.prnickname,  ");
		sql.append("			                   t3.user_photo, t3.user_ftype  ");
		sql.append("			              from recipe_rboard t1, recipe t2, member t3  ");
		sql.append("			             where t1.recipenum = t2.recipe_id  ");
		sql.append("			               and t1.memberid  = t3.user_id  ");
		sql.append("			               and t1.recipenum = ? ) t1  ");
		sql.append("			      where num between ? and ? ) t1,  ");
		sql.append("			     (select rnum,   ");
		sql.append("			            count(decode(vote,'GOOD',1)) good,  ");
		sql.append("			            count(decode(vote,'BAD',1))  bad  ");
		sql.append("			       from recipe_rboard_vote  ");
		sql.append("			      group by rnum) t2  ");
		sql.append("			  where t1.rnum = t2.rnum(+)   ");
		
		List<ReplyVO> list = jt.query(sql.toString(), new BeanPropertyRowMapper<ReplyVO>(ReplyVO.class), recipenum, startRec, endRec);
		return list;
	}
	
	
	//댓글조회
	@Override
	public ReplyVO replyView(long rnum) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("       t1.rnum, ");
		sql.append("       t1.recipenum, ");
		sql.append("       t1.memberid, t1.rnickname, ");
		sql.append("       t1.rcontent, ");
		sql.append("       t1.rcdate, t1.rudate, ");
		sql.append("       t1.rgroup, t1.rstep, t1.rindent, ");
		sql.append("       t1.prnum,  t1.prid,  t1.prnickname		 ");
		sql.append("        from recipe_rboard t1 ");
		sql.append("     where rnum = ? ");
		
		ReplyVO replyVO = (ReplyVO)(jt.queryForObject(sql.toString(), new BeanPropertyRowMapper(), rnum));
		
		return replyVO;
	}

	//댓글수정
	@Override
	public int modify(ReplyVO replyVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("update recipe_rboard ");
		sql.append("	      set rcontent = ?, ");
		sql.append("	          rudate = systimestamp ");
		sql.append("	 		where rnum = ? ");
		sql.append("	 		  and memberid  = ? ");
		
		int result = jt.update(sql.toString(),replyVO.getRcontent(),replyVO.getRnum(),replyVO.getMemberid());
		return result;
	}
	//댓글삭제
	@Override
	public int delete(long rnum) {
		String sql = "delete from recipe_rboard where rnum = ? ";
		int result = jt.update(sql,rnum);
		return result;
	}

	//대댓글 작성
	@Override
	public int reReply(ReplyVO replyVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into recipe_rboard( ");
		sql.append("	  	rnum, ");
		sql.append("	  	recipenum, ");
		sql.append("	  	memberid, ");
		sql.append("	  	rnickname, ");
		sql.append("	  	rcontent, ");
		sql.append("	  	rgroup, ");
		sql.append("	  	rstep, ");
		sql.append("	  	rindent, ");
		sql.append("	  	prnum, prid, prnickname ");
		sql.append("	  ) ");
		sql.append("	  values( ");
		sql.append("	  	rboard_rnum_seq.nextval, ");
		sql.append("	  	?, ");
		sql.append("	  	?, ");
		sql.append("	  	?, ");
		sql.append("	  	?, ");
		sql.append("	  	?, ");
		sql.append("	  	? + 1, ");
		sql.append("	  	? + 1, ");
		sql.append("	  	?, ?, ? )	 	 ");
		
		int result = jt.update(sql.toString(),
								replyVO.getRecipenum(),
								replyVO.getMemberid(),
								replyVO.getRnickname(),
								replyVO.getRcontent(),
								replyVO.getRgroup(),
								replyVO.getRstep(),
								replyVO.getRindent(),
								replyVO.getPrnum(),
								replyVO.getPrid(),
								replyVO.getPrnickname());
		return result;
	}
	//이전댓글 step업데이트
	@Override
	public int updateStep(int rgroup, int rstep) {
		StringBuilder sql = new StringBuilder();
		sql.append("update recipe_rboard ");
		sql.append("		   set rstep = rstep + 1 ");
		sql.append("     where rgroup = ? ");
		sql.append("       and rstep > ? ");
		
		int result = jt.update(sql.toString(), rgroup, rstep);
		return result;
	}
	//총레코드
	@Override
	public int totalRecordCount(long recipenum) {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(recipenum) cnt ");
		sql.append("		  from recipe_rboard t1, recipe t2 ");
		sql.append("     where t1.recipenum = t2.recipe_id ");
		sql.append("       and t1.recipenum = ? ");
		
		return jt.queryForObject(sql.toString(), Integer.class, recipenum);
	}

}
