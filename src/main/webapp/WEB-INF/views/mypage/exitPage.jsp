<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 페이지</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<%-- <link rel="stylesheet" href="${contextPath }/css/include/mainCommon.css" /> --%>
<link rel="stylesheet" href="${contextPath }/css/mypage/exitPage.css" />
<script defer src="${contextPath }/js/mypage/mypage.js"></script>
<link rel="stylesheet" href="${contextPath }/css/include/font.css" />

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
				<a href="${contextPath }/mypage/myRecipePage"><div class="myrecipe">작성한 레시피</div></a>
				<a href="${contextPath }/mypage/modifyPage"><div class="modify">개인 정보 수정</div></a>
				<a href="${contextPath }/mypage/exitPage"><div class="exit">회원탈퇴</div></a>
			</div>
		</div>
		<div class="section_login">
			<h3>본인 확인</h3>
			<br>
			<div class="write_form">
				<div class="write_view login_view">
					<form action="${contextPath }/mypage/exitPageSave" method="post">
						<input type="hidden" name="user_id" value="${sessionScope.member.user_id }">
						<input type="password" name="currentpw" placeholder="현재 비밀번호를 입력해주세요">
						<div class="space"></div>
						<div class="checkbox_save"></div>
						<button type="submit" class="btn_type1">확인</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>