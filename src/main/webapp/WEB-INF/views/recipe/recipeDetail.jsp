<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/portfolio/css/recipe/recipeDetail.css">
<%@include file="/WEB-INF/views/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 상세 페이지</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/recipe/recipeDetail.css" />
<script defer src="${contextPath }/js/recipe/recipeDetail.js"></script> 

</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<div class="wrapper">
	<div class="content_recipe">
		<div class="firstImg">
			<img src="data:image/jpeg;base64,${recipeVO.picBase64}" onerror="this.src='${contextPath }/img/LOGO.png'" >
		</div>
		<form>
			<div class="firstBox">
				<img id="profile" src="https://picsum.photos/300/300" alt="프로필사진_스펀지밥">
				<button type="button" id="recipeLike">저장</button>
				<button type="button" id="shareBtn">공유</button>
				<ul>
					<li id="r1">${recipeVO.recipe_name }</li>
					<li id="r2">${recipeVO.recipe_contents }</li>
					<li id="r3">by&nbsp;<a href="${contextPath }/mypage/mypage">${recipeVO.member_user_id }</a></li>
					<li id="r4"><b>⏰</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>👨‍👦‍👦</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>😫</b> </li>
					<li id="r5"><span>${recipeVO.recipe_how_long }</span>&nbsp;|
								<span>${recipeVO.recipe_how_many }</span>&nbsp;|
								<span>${recipeVO.recipe_difficulty }</span></li>
				</ul>
			</div>
			<div class="secondbox">
				<p>[재료]</p>
				<div class="ibox">
					<c:forEach var="materialVO" items="${materialVO }">
						<p>
							<span id="title">${materialVO.material_title }</span> | 
							<span id="contents">${materialVO.material_contents }</span>
						</p>
						<p></p>
					</c:forEach>
				</div>
			</div>
			<div class="thirdbox">
				<p>조리 순서</p>
				<c:forEach var="stepVO" items="${stepVO }">
					<div class="step">
						<p>${stepVO.step_contents }</p>
						<img id="other_main" src="data:;base64,${stepVO.picBase64}" onerror="this.src='${contextPath }/img/LOGO.png'" width="250px" height="250px">
					</div>
				</c:forEach>
			</div>
			<div class="fourthbox">
				<p>[댓글]</p>
				<div class="replybox">댓글 넣어줘요~</div>
			</div>
		</form>
	</div>
</div>
<!-- 댓글 작성란 -->
<%@include file="/WEB-INF/views/reply/reply.jsp"%>
<script>
	const recipeInfo= {
			"recipe_id": '${recipeVO.recipe_id}',
			"user_id"  : '${sessionScope.member.user_id}'
	}
</script>
</body>
</html>