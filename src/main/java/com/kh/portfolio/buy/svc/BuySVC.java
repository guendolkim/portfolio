package com.kh.portfolio.buy.svc;

import java.util.List;
import java.util.Map;

import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;

public interface BuySVC {
	
	/**
	 * 구매 리스트
	 * @param keyword
	 * @return
	 */
	List<BuyVO> keywordSearch(String keyword);
	
	// 요청 페이지
	Map<String, Object> list(int reqPage);
	
	/**
	 * 구매 리스트
	 * @param keyword
	 * @return
	 */
	List<BuyVO> listDetail(String item_id);
	
	/**
	 * 장바구니에 있는 지 확인
	 * @param item_id
	 * @param user_id
	 * @return 중복되는 게 있다면 true, 아니면 false
	 */
	public String chkIncart(CartVO cartVO);
	
	/**
	 * 카트에 물품 담기
	 * @param item_id
	 * @param user_id
	 * @return
	 */
	public int insertCart(CartVO cartVO);
	
	/**
	 * 최신 물품 리스트
	 * @return
	 */
	List<BuyVO> newestItemList();
	/**
	 * 판매량 순
	 * @return
	 */
	List<BuyVO> highestSaleCntList();
	
	//구매등록
		int buyEnroll(BuyVO buyVO);
	
	
}
