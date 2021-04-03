<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${contextPath }/css/modal.css">
<script defer src="${contextPath }/js/common/modal.js"></script>
<link rel="stylesheet" href="${contextPath }/css/reply/reply.css">
<script defer type="module" src="${contextPath }/js/reply/reply.js"></script>
<script>
	//이 페이지에서 얻을 수 있는 정보들은 객체화 시켜서 저장한다.
	const replyInfo = {
		recipenum : '${recipeVO.recipe_id }', //최초원글 번호
		member_user_id : '${recipeVO.member_user_id}', //게시원글 id
		user_id : '${sessionScope.member.user_id}', //댓글작성자 id
		rnickname : '${sessionScope.member.user_nickname}', //댓글작성자 별칭
		url : '${contextPath}/reply' //공통url	 
	};
</script>
<!--댓글 영역-->
<div class="wrapper-comments">
	<!--댓글 작성-->
	<div class="comment write"></div>
	<!--댓글 목록-->
	<div class="comments"></div>
	<!--페이징-->
	<div class="paging"></div>
</div>