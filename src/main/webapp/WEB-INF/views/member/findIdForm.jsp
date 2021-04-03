<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/member/findIdForm.css">
<script defer src="${contextPath }/js/member/findIdForm.js"></script>
</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <div class="main">
        <div class="content">
            <div class="section_login">
                <h3>아이디 찾기</h3>
                <div class="write_form">
                    <div class="write_view login_view">
                        <form action="${contextPath }/member/user_id">
                            <div class="small_title">전화번호</div>
                            <input type="text" placeholder="ex) 010-1234-5678" name="user_tel">
                            <div class="space"></div>
                            <div class="small_title">생년월일</div>
                            <input type="date" placeholder="비밀번호를 입력해주세요" name="user_birth">
                            <div class="checkbox_save"></div>
                            <button type="submit" class="btn_type1">확인</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>