<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/include/uppermost.css" />   
<link rel="stylesheet" href="${contextPath }/css/include/reset.css" />   


 <!--uppermost 누나꺼 -->
 <div class="wrapper">
	 	<div class="userMenu">
			<c:if test="${empty sessionScope.member }">
				<span>
					<a href="${contextPath }/loginForm" class="a">로그인</a>｜
					<a href="${contextPath }/member/joinForm" class="b">회원가입</a>｜
					<a href="#" class="c">고객센터</a>
				</span>
			</c:if>
			<c:if test="${!empty sessionScope.member }">
				<span>
					<a href="${contextPath }/logout" class="a" id="logout">로그아웃</a>｜
					<a href="${contextPath }/mypage/myPage" class="b">마이페이지</a>｜
					<a href="#" class="c" id="c">고객센터</a>
				</span>
			</c:if>
		</div>
 </div>
 