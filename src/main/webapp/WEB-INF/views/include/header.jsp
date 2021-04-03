<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/include/mainCommon.css" />
<link rel="stylesheet" href="${contextPath }/css/include/reset.css" />
<script defer src="${contextPath }/js/include/header.js"></script> 

<!--header-->
<div class="wrapper">
<header>
	<div class="logo-wrapper">
		<a href="${contextPath }/mainPage"><img src="${contextPath }/img/LOGO.png" alt="오늘뭐먹지로고"></a>
	</div>

<!--nav-->
<nav>
	<ul class="gnb">
		<li><a href="#none">전체카테고리</a></li>
		<li><a href="${contextPath }/recipe/recipeList">레시피</a></li>
		<li><a href="${contextPath }/buy/buyList">구매</a></li>
		<li><a href="${contextPath }/board/list">커뮤니티</a></li>
		<li><a href="${contextPath }/mypage/myPage">마이페이지</a></li>
	</ul>
	<div class="searchbox">
		<input type="search" id="nav-input" name="keyword" placeholder="검색어를 입력하세요" /><button type="submit" id="searchBtn"><i class="fa fa-search" aria-hidden="true"></i></button>
		<div class="write">
			<a id="recipeWriteBtn">
				<i class="fa fa-pencil fa-2x"></i>
			</a>
		</div>
		<div class="cart"><a href="${contextPath }/buy/cart"><i class="fa fa-shopping-cart fa-2x"></i></a></div>
	</div>
	</nav>
</header>
</div>