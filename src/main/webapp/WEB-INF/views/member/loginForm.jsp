<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>오뭐먹 : 로그인</title>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/member/loginForm.css">
<script defer src="${contextPath }/js/member/loginForm.js"></script>
</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <div class="main">
        <div class="content">
            <div class="section_login">
                <h3>로그인</h3>
                <div class="write_form">
                    <div class="write_view login_view">
                        <form action="${contextPath }/loginSave" id="loginForm" method="post">
                            <div class="small_title">아이디</div>
                            <input type="text" id="id" name="user_id" placeholder="아이디를 입력해주세요">
                            <div id="err_msg_id"></div>
                            <div class="space"></div>
                            <div class="small_title">비밀번호</div>
                            <input type="password" name="user_pw" id="pw" placeholder="비밀번호를 입력해주세요">
                            <div id="err_msg_pw"></div>
                            <div class="checkbox_save">
                                <div class="login_search"><a href="${contextPath }/member/findIdForm" class="atag">아이디 찾기</a> | 
                                <a href="${contextPath }/member/findPwForm" class="atag">비밀번호 찾기</a></div>
                            </div>
                            <div class="svr_msg">${svr_msg }</div>
                            <button id="loginBtn" type="submit" class="btn_type1">로그인</button>
                        </form>
                        <a href="${contextPath }/member/joinForm" class="btn_type2 btn_member"><div class="txt_type submit">회원가입</div></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>