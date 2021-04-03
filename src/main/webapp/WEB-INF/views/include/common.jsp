<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jspl 사용을 위해서 등록함 -->
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--  css나 js 링크 예시
<link rel="stylesheet" href="${contextPath }/css/board/writeForm.css">
<script defer src="${contextPath }/js/board/writeForm.js"></script> 
--%>

<!-- contextPath 루트 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath }" />     
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!--font awesome-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>      
  <!--폰트-->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Noto+Sans+KR:wght@100;400;900&display=swap"/> -->  
  <!-- css reset -->
  <link rel="stylesheet" href="${contextPath}/css/include/reset.css" />
  <!-- bootstrap -->
  <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/5.0.0-beta3/css/bootstrap.css" />
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Noto sant 폰트 -->
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  
  <!-- Option 2: Separate Popper and Bootstrap JS -->
  <script defer src="${contextPath }/webjars/popper.js/2.5.4/umd/popper.js"></script>
  <script defer src="${contextPath }/webjars/bootstrap/5.0.0-beta3/js/bootstrap.js"></script>