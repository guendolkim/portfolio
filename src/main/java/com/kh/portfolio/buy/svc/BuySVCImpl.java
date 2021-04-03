package com.kh.portfolio.buy.svc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.portfolio.buy.dao.BuyDAO;
import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;
import com.kh.portfolio.common.paging.PageCriteria;
import com.kh.portfolio.recipe.vo.RecipeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuySVCImpl implements BuySVC {

	final BuyDAO buyDAO;
	final PageCriteria pc;
	
	/**
	 * 구매 리스트
	 * @param keyword
	 * @return
	 */
	@Override
	public List<BuyVO> keywordSearch(String keyword) {
		
		return buyDAO.keywordSearch(keyword);
	}
	//구매 페이징 구현
	@Override
	public Map<String, Object> list(int reqPage) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		pc.getRc().setReqPage(reqPage);
		
		pc.setTotalRec(buyDAO.totalRecordCount());
		
		pc.calculatePaging();
		
		int startRec 	= pc.getRc().getStartRec();
		int endRec 		= pc.getRc().getEndRec();
		List<BuyVO> list = buyDAO.list(startRec, endRec);
		//5)map객체에 게시글 목록, pc담기
		map.put("buyList", list);
		map.put("pc",pc);

		return map;
	}
	
	/**
	 * 구매 리스트
	 * @param keyword
	 * @return
	 */
	@Override
	public List<BuyVO> listDetail(String item_id) {
		List<BuyVO> listDetail = buyDAO.listDetail(item_id);
		return listDetail;
	}
	
	/**
	 * 장바구니에 있는 지 확인
	 * @param item_id
	 * @param user_id
	 * @return 중복되는 게 있다면 true, 아니면 false
	 */
	@Override
	public String chkIncart(CartVO cartVO) {
		String chk = buyDAO.chkIncart(cartVO);
		return chk;
	}
	
	/**
	 * 카트에 물품 담기
	 * @param item_id
	 * @param user_id
	 * @return
	 */
	@Override
	public int insertCart(CartVO cartVO) {
		int result = buyDAO.insertCart(cartVO);
		return result;
	}
	
	/**
	 * 최신 물품 리스트
	 * @return
	 */
	@Override
	public List<BuyVO> newestItemList() {
		
		return buyDAO.newestItemList();
	}
	
	/**
	 * 판매량 순
	 * @return
	 */
	@Override
	public List<BuyVO> highestSaleCntList() {

		return buyDAO.highestSaleCntList();
	}
	
	@Override
	public int buyEnroll(BuyVO buyVO) {
		
		return buyDAO.buyEnroll(buyVO);
	}
	
	
}
