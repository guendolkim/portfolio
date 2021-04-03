<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--common -->
	<%-- <%@ include file="/WEB-INF/views/include/common.jsp"%> --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Noto sant 폰트 -->
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  <c:set var="contextPath" value="${pageContext.request.contextPath }" /> 
  <!--font awesome-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>

  <!-- css적용 -->
	<link rel="stylesheet" href="${contextPath }/css/mainpage/main.css" /> 
	<link rel="stylesheet" href="${contextPath}/css/include/reset.css" />
	<link rel="stylesheet" href="${contextPath }/css/include/mainCommon.css" /> 
	 
  <title>메인페이지</title>
</head>
<body>
  <!--upper most-->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
  <!--header-->
  <!--nav-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
  <!--main-->
	<%@ include file="/WEB-INF/views/mainpage/main.jsp"%>
  <!--footer menu-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>	
  <!--footer-->
	
</body>
</html>