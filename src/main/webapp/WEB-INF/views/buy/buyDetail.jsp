<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/buy/buyDetail.css" />
<script defer type="module" src="${contextPath }/js/buy/buyDetail.js"></script>
<script defer src="${contextPath }/js/common/ckeditor.js"></script>
<title>상세 구매 페이지</title>

<!-- ck editor -->
<!--script defer src="https://cdn.ckeditor.com/ckeditor5/25.0.0/classic/ckeditor.js"></script-->
<%-- <script defer src="${contextPath }/js/common/ckeditor.js"></script>
<script defer src="${contextPath }/js/board/readForm.js"></script> --%>

</head>
<body>
	
	<!-- uppermost부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
	<!-- header부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- 머리 부분 -->
	<div class="wrapper">
		<c:forEach var="listDetail" items="${listDetail }">
			<div class="grid-container">
				<div class="l100"></div>
				<div class="r100"></div>

				<div class="img_goods">
					<img src="avo.PNG" alt="아보카도">
				</div>

				<div class="name_goods">
					<p>${listDetail.item_name }</p>
					${listDetail.item_contents }
				</div>
	
				<div class="price_goods">
					<p>${listDetail.item_price }</p>
					로그인 후, 적립혜택이 제공됩니다.
					<hr size="1" width="600px" align="center" color="#eee">
				</div>

				<div class="unit_goods">
					판매 단위<span>${listDetail.item_unit }</span> <br />중량/용량<span>${listDetail.item_weight }</span>
					<hr size="1" width="600px" align="center" color="#eee">
					원산지 <span> ${listDetail.item_country }</span>
					<hr size="1" width="600px" align="center" color="#eee">
				</div>

				<div class="deli_goods">
					포장타입 <span>냉장/종이포장</span>
					<hr size="1" width="600px" align="center" color="#eee">
					안내사항
					<div class="deli_goods_info">
						-아보카도는 수령 후 즉시 지퍼백에서 꺼내어 보관 부탁드리겠습니다. 지퍼백 내부에 보관 시 습기로 인해 곰팡이 발생 및
						쉽게 변질되는 점 참고 부탁드리겠습니다. <br /> -아보카도 후숙 관련 팁은 컨텐츠에 기재되어 있습니다.
					</div>
					<hr size="1" width="600px" align="center" color="#eee">
				</div>

				<div class="select_price_goods">
					<p>구매수량 및 상품금액</p>

					<div class="cal">

						<form name="form" method="get">

							&nbsp; &nbsp; <input type="hidden" name="sell_price" value="2390">
							<!--판매액 정하는 부분 value가 판매액-->
							<input type="text" name="amount" value="1" size="4"
								onchange="change();"> <i
								class="fa fa-minus-square fa-1x" onclick="del();"></i> <i
								class="fa fa-plus-square fa-1x" onclick="add();"></i>&nbsp;
							&nbsp; &nbsp; &nbsp; 합계금액 <input type="text" name="sum" size="4"
								readonly>원
						</form>
					</div>
				</div>
				
				<div class="btn_goods">
					<button id="cartBtn">장바구니</button>
					&nbsp;
					<button id="paymentBtn">바로구매</button>

				</div>

				<div class="related_goods">
					<hr size="1" align="center" color="#eee">
				</div>


<div class="goods_board">
  <ul>
    <li id="tab1" class="btnCon"><a class="btn first" href="#tab1">상품정보</a>
      <div class="tabCon" >Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</div>
      
    </li>
    <li id="tab2" class="btnCon"><a class="btn" href="#tab2">상세정보</a>
      <div class="tabCon" >It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).</div>
      
    </li>    
    <li id="tab3" class="btnCon"><a class="btn" href="#tab3">상품후기</a>
      <div class="tabCon" >There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.</div>
      
    </li>
  </ul>
</div>
    
    
			</div>
		</c:forEach>
	</div>	
<script>location.href = "#tab1";</script>	
<%@ include file="/WEB-INF/views/include/footer.jsp"%>	
</body>
</html>