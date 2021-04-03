<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이레시피 페이지</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/mypage/myRecipePage.css" />
<script defer src="${contextPath }/js/mypage/myRecipePage.js"></script> 
<script defer src="${contextPath }/js/mypage/mypage.js"></script>

</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<div class="wrapper">
	<div class="content_mypage">
		<div class="myPage">
			<p>마이페이지</p>
			<div class="pageList">
				<a href="${contextPath }/mypage/myPage"><div class="orderlist">주문 내역</div></a>
				<a href="${contextPath }/mypage/saveRecipe"><div class="review">저장한 레시피</div></a>
				<a href="${contextPath }/mypage/myRecipePage/${sessionScope.member.user_id}"><div class="myrecipe">작성한 레시피</div></a>
				<a href="${contextPath }/mypage/modifyPage"><div class="modify">개인 정보 수정</div></a>
				<a href="${contextPath }/mypage/exitPage"><div class="exit">회원탈퇴</div></a>
			</div>
		</div>

		<div class="oderedList">
			<div class="list_title">
				<b>마이 레시피</b>&nbsp;&nbsp;올려주신 레시피를 한 곳에 요약정리합니다.
			</div>
			<div class="list">
				<p>
					레시피가 총 <b>2</b> 개 있습니다.
				</p>
			</div>
			<div class="receipes">
				<c:forEach var="recipeList" items="${recipeList }">
					<img src="http://via.placeholder.com/150x150/" class="id_1" alt="">
					<p>
						<b>${recipeList.recipe_name }</b>
					</p>
					<p>소개 : ${recipeList.recipe_content } </p>
					<p>순서 - 1. 호두를 끓는 물에 살짝 데친다. 2. 블루베리, 저지방우유, 호두를 믹서기에 넣고 갈아준다.
						3. 기호에 따라 올리고당을 넣어도 좋다.</p>
					<hr>
				</c:forEach>		
			</div>
		</div>
	</div>
</div>
<!-- footer부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	
</body>
</html>