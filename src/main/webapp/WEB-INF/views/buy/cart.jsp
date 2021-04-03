<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/buy/cart.css" />
<script defer src="${contextPath }/js/buy/cart.js"></script>
</head>
<body>
	<!-- uppermost부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
	<!-- header부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

<div class="wrapper">
	<!-- cart -->
	<div class="content_cart">
		<div class="money_delivery">
			<div class="cart_info">
				<p>
					<i class="fa fa-map-marker"></i>&nbsp;배송지
				</p>
				<p>서울 강남구 압구정로 42길 25-3 (KH빌딩)</p>
				<button>배송지 변경</button>
			</div>

			<div class="cart_info2">
				<div class="paywon">
					<p>상품금액</p>
					<p>배송비</p>
					<p>결제예정금액</p>
				</div>
				<div class="realwon">
					<p>22,000원</p>
					<p>+3,000원</p>
					<P>25,000원</P>
				</div>
			</div>
			<div class="ordering">
				<a href="${contextPath }/buy/paymentForm">주문하기</a>
			</div>
		</div>

		<div class="cart_price">
			<h1>장바구니</h1>
			<div class="select1">
				<input type="checkbox" name='item' onclick='selectAll(this)'>
				전체선택 / <a href="#none">선택삭제</a>
			</div>
			<!--희망사항: 상온/냉장/냉동 상품;-->
			<div class="buytem">
				<p>
					<input type="checkbox" name='item'>[장인정신에브리데이] 구강항균 프로포리스
					키즈
				</p>
			</div>
			<form name="form" method="get">

				&nbsp; &nbsp; <input type="hidden" name="sell_price" value="22000">
				<!--판매액 정하는 부분 value가 판매액-->
				<input type="text" name="amount" value="1" size="4"
					onchange="change();"> <i class="fa fa-minus-square fa-1x"
					onclick="del();"></i> <i class="fa fa-plus-square fa-1x"
					onclick="add();"></i>&nbsp; &nbsp; &nbsp; &nbsp; 합계금액 <input
					type="text" name="sum" size="4" readonly>원
			</form>
		</div>
	</div>
<!-- footer부분을 이어주는 링크 -->
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>