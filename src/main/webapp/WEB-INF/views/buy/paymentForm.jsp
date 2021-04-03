<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/buy/paymentForm.css" />
<script defer src="${contextPath }/js/buy/paymentForm.js"></script> 

</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>


<div class="wrapper">
	<div class="content">
		<div class="title">
			<ul>
				<li id="aa">01 장바구니 ▶ <b>02 주문서작성/결제</b> ▶ 03 주문완료
				</li>
				<li id="bb">주문서작성/결제</li>
			</ul>
		</div>

		<div class="order-detail">
			<p>주문상세내역</p>
			<table class="option">
				<tr id="t1">
					<td>상품/옵션정보</td>
					<td>수량</td>
					<td>상품금액</td>
					<td>합계금액</td>
					<td>배송비</td>
				</tr>
				<tr id="t2">
					<td>[美친특가] 100% 국내산 천연조미료 톡톡채소&요리키트</td>
					<td>1개</td>
					<td>990원</td>
					<td>990원</td>
					<td>2만원 이상 무료배송</td>
				</tr>
			</table>
		</div>

		<div class="delivery-info">
			<p>배송정보</p>
			<table class="deliver">
				<tr id="t3">
					<td>배송지확인</td>
					<td>
						<form>
							<input type="radio" name="basic" value="1">기본배송지 <input
								type="radio" name="self" value="2" checked>직접입력하기
						</form> <!-- 라디오 얘네 왜 복수선택 되는 지 모르겠어요 ㅠㅠ 도움!!! -->
				</tr>
				<tr id="t4">
					<td><b>*</b>받으실분</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t5">
					<td><b>*</b>받으실 곳</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;"
						readonly>&nbsp;
						<button type="button"
							style="border-color: #eee; height: 30px; border: 1px #bbbbbb solid; border border-radius: 10px; font-size: 12px; color: #666666">우편번호검색</button>
						<br /> &nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;"
						readonly>&nbsp;&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t6">
					<td>전화번호</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t7">
					<td><b>*</b>휴대폰 번호</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t8">
					<td>남기실 말씀</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
			</table>
		</div>

		<div class="buyer-info">
			<p>주문자 정보</p>
			<table class="buyer">
				<tr id="t9">
					<td><b>*</b>주문하시는 분</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t10">
					<td>전화번호</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t11">
					<td><b>*</b>휴대폰번호</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
				<tr id="t12">
					<td><b>*</b>이메일</td>
					<td>&nbsp;<input type="text" size=25
						style="border: 1px solid #bbbbbb; border-radius: 6px; height: 25px;" /></td>
				</tr>
			</table>
		</div>

		<div class="pay-info">
			<p>결제정보</p>
			<table class="receipt">
				<tr id="t13">
					<td>상품 합계 금액</td>
					<td>&nbsp;990원</td>
				</tr>
				<tr id="t14">
					<td>배송비</td>
					<td>&nbsp;2,500원</td>
				</tr>
				<tr id="t15">
					<td>최종 결제 금액</td>
					<td>&nbsp;3,490원</td>
				</tr>
			</table>
		</div>

		<div class="pay">
			<p>결제수단 선택/결제</p>
		</div>
		<div class="payment">
			<div class="creditcard">신용카드</div>
			<div class="depositwb">무통장입금</div>
			<div class="phone">휴대폰결제</div>
			<div class="kakao">카카오페이</div>
			<div class="payco">페이코</div>
			<div class="banktransfer">계좌이체</div>
		</div>

		<div class="agree0">
			<input type="checkbox">결제 필수사항 동의
		</div>

		<div class="agree1">상품 공급사 개인정보 제공 동의에 대한 내용을 확인 하였으며 이에 동의합니다.</div>

		<div class="information">
			- 제공받는 자 : (주)이지에이치엘디 / 상품공급사<br> - 이용목적 : 판매자와 구매자의 거래의 원활한 진행,
			본인의사의확인, 고객 상담 및 불만처리, 상품과 경품 배송을 위한 배송지 확인 등<br> - 제공항목 : 구매자
			이름, 전화번호, ID, 휴대폰번호, 이메일주소, 상품 구매정보, 상품 수취인 정보(이름, 주소, 전화번호)<br>
			- 보유/이용기간 : 배송완료 후 한달
		</div>

		<div class="agree2">구매하실 상품의 결제정보를 확인하였으며, 구매진행에 동의합니다.</div>


		<div class="paymentBtn">
			<button>결제하기</button>
		</div>
	</div>
</div>
</body>
</html>