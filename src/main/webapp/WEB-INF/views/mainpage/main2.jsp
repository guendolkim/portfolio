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
	<div class="wrapper">
		<!-- <div class="content"> -->
		<div class="content-img">
			<div class= "main_img">
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/breaking.jpg"
						alt="dd"></a>
				</div>
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/potato.jpg"
						alt="dd"></a>
				</div>
				<div class="slide_img">
					<a href="#"><img src="${contextPath }/img/banner/recipe.jpg"
						alt="dd"></a>
				</div>
			</div>
		</div>
		</div>
		<div class="mid_wrapper">
			<div >
				<div class="main-tit">
					<h1>최신 등록 레시피</h1>
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
								일일특가 <span class="tit2"> 3월, 한 달간 진행되는 24시간 한정이벤트 </span>
							</h3>
						</div>
					</div>
					<div class="right">
						<div class="right-item">
							<a href=""><img src="${contextPath }/img/mainPage/salad.jpg"
								alt="ddd" id="right_img"></a>
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
							<div class="info_goods">
								<span class="name">${newestItemList.item_name }</span> <span
									class="price">${newestItemList.item_price }</span>
							</div>
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