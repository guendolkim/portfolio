package com.kh.portfolio.buy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BuyDAOImpl implements BuyDAO {
	
	@Autowired
	JdbcTemplate jt = new JdbcTemplate();
	
	@Override
	public List<BuyVO> keywordSearch(String keyword) {
		StringBuilder str = new StringBuilder();
		String getKeyword = '%' + keyword + '%';
		
		str.append("select item_name ");
		str.append("from item i ");
		str.append("where i.item_name like ? ");
		str.append("order by i.item_c_date desc ");
		return jt.query(str.toString(), new BeanPropertyRowMapper(BuyVO.class), getKeyword);
	}
	
	/**
	 * 레시피 리스트 
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	@Override
	public List<BuyVO> list(int startRec, int endRec) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select  ");
		sql.append("    t1.num, ");
		sql.append("    t1.item_id, ");
		sql.append("    t1.item_name, ");
		sql.append("    t1.item_contents, ");
		sql.append("    t1.item_price ");
		sql.append("    from ( ");
		sql.append("SELECT ROW_number() over (order by item_c_date desc) as num, ");
		sql.append("    item_id, ");
		sql.append("    item_name, ");
		sql.append("    item_contents, ");
		sql.append("    item_price, ");
		sql.append("    item_stock, ");
		sql.append("    item_c_date, ");
		sql.append("    item_u_date, ");
		sql.append("    item_view_count, ");
		sql.append("    item_sell_count, ");
		sql.append("    item_review_count, ");
		sql.append("    item_review_average ");
		sql.append("FROM ");
		sql.append("    item)t1 ");
		sql.append("    where t1.num between ? and ? ");
		
		List<BuyVO> list =jt.query(sql.toString(), new BeanPropertyRowMapper<BuyVO>(BuyVO.class),startRec,endRec);
		
		return list;
	}
	
	//총 레코드 수 카운트 하는 거
	@Override
	public long totalRecordCount() {
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as totalRecCnt ");
		sql.append("  from item ");
		
		return jt.queryForObject(sql.toString(), Long.class);
	}
	@Override
	public long totalRecordCount(String searchType, String keyWord) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 구매 상세페이지
	 * @param item_id
	 * @return
	 */
	@Override
	public List<BuyVO> listDetail(String item_id) {
		
		StringBuilder sql =  new StringBuilder();
		sql.append("SELECT ");
		sql.append("    item_name, ");
		sql.append("    item_contents, ");
		sql.append("    item_price, ");
		sql.append("    item_id, ");
		sql.append("    item_stock ");
		sql.append("FROM ");
		sql.append("    item ");
		sql.append("where item_id = ? ");
		
		List<BuyVO> list = jt.query(sql.toString(), new BeanPropertyRowMapper<BuyVO>(BuyVO.class), item_id);
		
		return list;
	}
	
	/**
	 * 장바구니에 있는 지 확인
	 * @param item_id
	 * @param user_id
	 * @return 중복되는 게 있다면 true, 아니면 false
	 */
	public String chkIncart(CartVO cartVO) {
		StringBuilder sql =  new StringBuilder();
		sql.append("select decode(count(*), 0, 'false', 'true') ");
		sql.append("from cart ");
		sql.append("where item_item_id = ? ");
		sql.append("and member_user_id = ? ");
		
		String result = jt.queryForObject(sql.toString(), String.class, cartVO.getItem_item_id(), cartVO.getMember_user_id());
		return result;
	}
	
	/**
	 * 카트에 물품 담기
	 * @param item_id
	 * @param user_id
	 * @return
	 */
	public int insertCart(CartVO cartVO) {
		StringBuilder sql =  new StringBuilder();
		sql.append("insert into cart( ");
		sql.append("cart_id,  ");
		sql.append("item_item_id,  ");
		sql.append("member_user_id ) values ( ");
		sql.append("CART_ID_SEQ.nextval, ");
		sql.append("?, ");
		sql.append("? ) ");
		
		return jt.update(sql.toString(), cartVO.getItem_item_id(), cartVO.getMember_user_id());
	}
	
	/**
	 * 최신 물품 리스트
	 * @return
	 */
	@Override
	public List<BuyVO> newestItemList() {
		StringBuilder sql =  new StringBuilder();
		sql.append("select *  ");
		sql.append("from( ");
		sql.append("select row_number() over(order by item_c_date)as num, ");
		sql.append("        item_name, ");
		sql.append("        item_id, ");
		sql.append("        item_contents, ");
		sql.append("        item_c_date, ");
		sql.append("        item_price, ");
		sql.append("        item_photo ");
		sql.append("from item)t1 ");
		sql.append("where t1.num between 1 and 6 ");
		return jt.query(sql.toString(), new BeanPropertyRowMapper<BuyVO>(BuyVO.class));
	}
	/**
	 * 판매량 순
	 * @return
	 */
	@Override
	public List<BuyVO> highestSaleCntList() {
		StringBuilder sql =  new StringBuilder();
		sql.append("select *  ");
		sql.append("from( ");
		sql.append("select row_number() over(order by item_view_count)as num, ");
		sql.append("        item_name, ");
		sql.append("        item_id, ");
		sql.append("        item_contents, ");
		sql.append("        item_c_date, ");
		sql.append("        item_price, ");
		sql.append("        item_photo ");
		sql.append("from item)t1 ");
		sql.append("where t1.num between 1 and 6 ");
		return jt.query(sql.toString(), new BeanPropertyRowMapper<BuyVO>(BuyVO.class));
	}
	
	@Override
	public int buyEnroll(BuyVO buyVO) {
		
		StringBuilder sql =  new StringBuilder();
		
		sql.append("INSERT INTO item ( ");
		sql.append("    item_id, ");
		sql.append("    item_name, ");
		sql.append("    item_contents, ");
		sql.append("    item_price, ");
		sql.append("    item_stock, ");
		sql.append("    item_view_count, ");
		sql.append("    item_sell_count, ");
		sql.append("    item_review_count, ");
		sql.append("    item_review_average, ");
		sql.append("    item_unit, ");
		sql.append("    item_weight, ");
		sql.append("    item_delivery, ");
		sql.append("    item_package, ");
		sql.append("    item_mention, ");
		sql.append("    item_country, ");
		sql.append("    item_file, ");
		sql.append("    item_fsize, ");
		sql.append("    item_ftype, ");
		sql.append("    item_fname, ");
		sql.append("    item_photo ");
		sql.append(") VALUES ( ");
		sql.append("    'item_' || item_id_seq.nextval, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ?, ");
		sql.append("    ? ");
		sql.append(") ");
		
		int result = jt.update(sql.toString(), Integer.class,buyVO);
		
		
		return result;
	}
	
}
