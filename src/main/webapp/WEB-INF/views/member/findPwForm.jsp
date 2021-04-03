<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/member/findPwForm.css">
<script defer src="${contextPath }/js/member/findPwForm.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<!-- ajax사용 -->
<script defer type="module" src="${contextPath }/js/common/common.mjs"></script>
<script defer type="module" src="${contextPath }/js/member/findPwForm.js"></script>
<script defer src="${contextPath }/js/common/ajax.js"></script>
</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>
    <!-- <div class="main">
        <div class="content">
            <div class="section_login">
                <h3>비밀번호 찾기</h3>
                <div class="write_form">
                    <div class="write_view login_view">
                        <form action="">
                            <div class="small_title">아이디</div>
                            <input type="text" placeholder="아이디를 입력해주세요">
                            <div class="space"></div>
                            <div class="small_title">생년월일</div>
                            <input type="date" placeholder="비밀번호를 입력해주세요">
                            <div class="checkbox_save"></div>
                            <button type="submit" class="btn_type1" id="findBtn">확인</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> -->
    <div class="main">
        <div class="content">
            <div class="section_login">
                <h3>비밀번호 찾기</h3>
                <div class="write_form">
                    <div class="write_view login_view">
                        
                            <div class="small_title">아이디</div>
                            <input type="text" id="user_id" name="user_id" placeholder="아이디를 입력해주세요">
                            <div class="space"></div>
                            <div class="small_title">전화번호</div>
                            <input type="text" id="user_tel" name="user_tel" placeholder="전화번호를 입력해주세요">
                            <div class="space"></div>
                            <div class="small_title">생년월일</div>
                            <input type="date" id="user_birth" name="user_birth">
                            <div class="checkbox_save"></div>
                            <button type="button" class="btn_type1" id="findPwBtn">확인</button>
                            <div><span id="findedPw"></span></div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>