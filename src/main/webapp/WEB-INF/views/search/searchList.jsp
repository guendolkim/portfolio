<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<style>
/**{outline: 1px solid red;}*/
.container {
	display: block;
	width: 1200px;
	margin: 0 auto;
}

.content {
	width: 100%;
	/* display: flex;
            justify-content:flex-start;
            flex-wrap: wrap; */
}

ul {
	list-style-type: none;
	padding-left: 0;
	text-align: center;
}

li {
	display: inline-block;
}

span {
	display: block;
}
</style>
</head>
<body>
	<!-- uppermost부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
	<!-- header부분을 이어주는 링크 -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div class="container">
		<!-- 검색 결과가 있는 경우 -->
		<c:if test="${searchList != '[]'}">
			<ul class="content">
				<c:forEach var="searchList" items="${searchList }">
					<li>
						<div>
							<img src="https://picsum.photos/200/300" alt="사진 없음">
						</div> <span>${searchList.recipe_name }</span> <span>${searchList.recipe_c_date }</span>
						<span>${searchList.recipe_id }</span>
					</li>
				</c:forEach>
			</ul>
		</c:if>
		
		<hr>
		<!-- 검색 결과가 없는 경우 -->
		
			<c:if test="${searchList == '[]'}">
				<div>검색결과가 나타나지 않았습니다.</div>
			</c:if>
		
		
		<hr>
	</div>
</body>
</html>