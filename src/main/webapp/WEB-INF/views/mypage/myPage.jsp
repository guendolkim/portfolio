<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/mypage/myPage.css" />
<script defer src="${contextPath }/js/member/joinForm.js"></script>
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
				<b>주문 내역</b>&nbsp;&nbsp;지난 2년간의 주문 내역 조회가 가능합니다
			</div>
			<select name="during" id="during">
				<option value="">전체기간</option>
				<option value="2021">2021년</option>
				<option value="2020">2020년</option>
			</select>
			<div class="list">
				<p>주문내역이 없습니다.</p>
			</div>
		</div>
	</div>
</div>	
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>