<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<%-- <link rel="stylesheet" href="${contextPath }/css/member/loginForm.css"> --%>
<%-- <script defer src="${contextPath }/js/member/loginForm.js"></script> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매리스트</title>
<!--common 적용-->
<!-- css적용 -->
<%-- <link rel="stylesheet" href="${contextPath }/css/recipe/recipeList.css" /> --%>
<!--js 적용-->
<script defer src="${contextPath }/js/recipe/recipeList.js"></script>

<style>
    /* *{outline: 1px solid red;}  */

        .container{
        	display:block;
            width:2000px;
            margin: 20px auto; 
            
        }
        .content{
 
            width:1200px;
             display: flex;     
            flex-wrap: wrap; 
      		margin: 0 auto;
			
      		
        }
        ul{
            list-style-type: none;
            padding-left: 0;
            text-align:center;
        }
        li{
        	
        	display: inline-block;
        	
        }
        .content>li{
         margin:10px 10px 10px 10px;
        }
        span{display: block;}
        .pagination {
        margin:20px 0 40px 0;
        }
    </style>
</head>
<body>
  <!--upper most-->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
  <!--header-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="container">
        <div class="content">
        	<c:forEach var="buyList" items="${buyList }">
	            <li>
	                <div>
	                <a href="${contextPath }/buy/buyDetail/${buyList.item_id}"><img src="https://picsum.photos/280/300" alt="사진 없음"></a>
	                <input type="hidden" value="${buyList.item_id}" />
	                </div>	                
	                <span>${buyList.item_name }</span>
	                <span>${buyList.item_contents }</span>
	                <span>${buyList.item_price }</span>
	                <span>${buyList.item_id}</span>
	            </li>
            </c:forEach>
        </div>
    </div>
    <!-- 여기는 이제 버튼 드갈 곳 -->
    <!-- 페이징 -->
					<div class="text-center">
						<ul class="pagination pagination-sm justify-content-center">

 <!-- 만약 보여줄 이전 페이지가 있는 경우만 보이게 -->
							<c:if test="${pc.prev }">
				<!-- 첫페이지 버튼-->
								<li class="page-item"><a class="page-link"
									href="${contextPath}/buy/buyList/1">처음</a></li>
				<!-- 이전페이지 버튼-->
								<li class="page-item"><a class="page-link"
									href="${contextPath}/buy/buyList/${pc.startPage-1 }">이전</a></li>
							</c:if>
	<!-- 페이정 버튼이 표시될 곳 -->
							<c:forEach var="pageNum" begin="${pc.startPage }"	end="${pc.endPage }">
			<!-- 만약 현제 페이지와 요청페이지가 같은 경우 -->
								<c:if test="${pageNum == pc.rc.reqPage}">
									<li class="page-item active" aria-current="page"><a class="page-link"
										href="${contextPath}/buy/buyList/${pageNum}">${pageNum }</a></li>
								</c:if>
			<!-- 만약 현제 페이지와 요청페이지가 다른 경우 -->
								<c:if test="${pageNum ne pc.rc.reqPage}">
									<li class="page-item"><a class="page-link"
										href="${contextPath}/buy/buyList/${pageNum}">${pageNum }</a></li>
								</c:if>
							</c:forEach>

			<!-- 만약 보여줄 다음 페이지가 있는 경우만 보이도록 -->
							<c:if test="${pc.next}">
				<!-- 다음페이지 버튼-->
								<li class="page-item"><a class="page-link"
									href="${contextPath}/buy/buyList/${pc.endPage + 1}">다음</a></li>
				<!-- 최종페이지 버튼-->
								<li class="page-item"><a class="page-link"
									href="${contextPath}/buy/buyList/${pc.finalEndPage }">최종</a></li>
							</c:if>
						</ul>
					</div>
<!-- 페이징 끝 -->
    <!-- footer부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>