package com.kh.portfolio.buy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.portfolio.buy.vo.BuyVO;
import com.kh.portfolio.buy.vo.CartVO;

import lombok.RequiredArgsConstructor;


public interface BuyDAO {

	
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
	
	
	//일단은 키워드 검색하는 쿠러ㅣ문
	List<BuyVO> keywordSearch(String keyword);
	
	/**
	 * 레시피 리스트 
	 * @param startRec
	 * @param endRec
	 * @return
	 */
	List<BuyVO> list(int startRec, int endRec); 
	
	/**
	 * 구매 상세페이지
	 * @param item_id
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
	
	//총 레코드 수 검색하는 쿼리
	long totalRecordCount(); 
	long totalRecordCount(String searchType, String keyWord);
	
	//구매등록
	int buyEnroll(BuyVO buyVO);
}
