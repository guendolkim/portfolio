<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/WEB-INF/views/include/common.jsp"%> --%>
<!-- contextPath 루트 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!-- css 추가 -->
<link rel="stylesheet" href="${contextPath }/css/include/reset.css">
<link rel="stylesheet" href="${contextPath }/css/mainpage/main.css">
<link rel="stylesheet" href="${contextPath }/css/mainpage/slick.css">
<link rel="stylesheet"
	href="${contextPath }/css/mainpage/slick-theme.css">
<!-- xicon ?? -->
<link rel="stylesheet"
	href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<!-- js 추가 -->

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script defer src="${contextPath }/js/mainpage/slick.js"></script>
<script defer src="${contextPath }/js/mainpage/main.js"></script>
<!--content-->
<link rel="stylesheet" href="${contextPath }/css/include/reset.css">
<main>
<div class="firstbackImg">
	<%-- <img class="firstback" src="${contextPath }/img/banner/recipe.png"> --%>
<p style="color:orange; font-size:70px;  font-weight:bold;">레시피</p><br />
<p style="color:gray; font-size:20px; font-weight:bold; margin-top:10px;">"매일 요리가 새로워집니다"</p><br />
<p style="color:gray; font-size:20px;  font-weight:bold; margin-top:10px;">함께 요리하는 공유 레시피 플렛폼 "오늘 뭐먹지?"</p>
</div>
	<div class="wrapper">
		<!-- <div class="content"> -->
		<div class="content-img">
			<div class="container main_img">
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/carrot.jpg"
						alt="dd"></a>
				</div>
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/tomato2.jpg"
						alt="dd"></a>
				</div>
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/berry.jpg"
						alt="dd"></a>
				</div>
			</div>
		</div>
		</div>
		<div class="mid_wrapper">
			<div >
				<div class="main-tit">
					<h1 style="margin:10px 0;">최신 등록 레시피</h1>
				</div>
			</div>
			<div>
				<div class="goods-list">
				
					<c:forEach var="mainPageList" items="${mainPageList }">
						<div class="slider">						
							<a class="a_tag" href="${contextPath }/recipe/recipeDetail/${mainPageList.recipe_id}">
								<img src="http://placehold.it/200/300" alt="">
							</a>
							<div class="info_goods">
								<span class="name">${mainPageList.recipe_name }</span> <span
									class="price">${member_user_id }</span>
							</div>						
						</div>
					</c:forEach>
				 
				</div>
			</div>
		</div>
		
		<!--inner_special-->
		<div class="mid_wrapper">
			<div class="inner">
				<div class="inner_special">
					<div class="left">
						<div class="left-list">
							<h3 class="tit">
								레시피 <span class="tit2"> 여러분들도 도전해 보세요 </span>
							</h3>
						</div>
					</div>
					<div class="right">
						<div class="right-item">
							<a href=""><img src="${contextPath }/img/mainPage/2-3.jpg"
								alt="ddd" id="right_img"></a>
							<a href=""><img src="${contextPath }/img/mainPage/salad.jpg"
								alt="ddd" id="right_img2"></a>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="mid_wrapper">
			<div>
				<div class= "main-tit">
					<h1 class="">최신 상품</h1>
				</div>
			</div>
		<div class="evt-item">
			<div class="evt-box">
				<div class="evt-goods">
					<c:forEach var="newestItemList" items="${newestItemList }">
						<div class="evt_img">
							<a href="${contextPath }/buy/buyDetail/${newestItemList.item_id}">
								<img src="http://placehold.it/300" alt="dddd">
							</a>
	<!-- 메인 맨 밑 사진들 설명창 -->				<%-- 		<div class="info_goods">
								<span class="name">${newestItemList.item_name }</span> <span
									class="price">${newestItemList.item_price }</span>
							</div> --%>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

		<div>
			<div class="container main-tit">
			</div>
		</div>
		<div>
			<div class="container goods-list">

				<%-- 				<c:forEach var="highestSaleCntList" items="${highestSaleCntList }">
					<div class="slider">
						<a href="${contextPath }/buy/buyDetail/${newestItemList.item_id}"> 
							<img src="http://placehold.it/300" alt="ddd">
						</a>
						<div class="info_goods">
							<span class="name">${highestSaleCntList.item_name }</span> 
							<span class="price">${highestSaleCntList.item_price }</span>
						</div>
					</div>
				</c:forEach> --%>
			</div>
		</div>
	
</main>