<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 양식</title>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/member/joinForm.css" />
<script defer src="${contextPath }/js/member/joinForm.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
</head>
<body>
<!-- uppermost부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
<!-- header부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/header.jsp"%>

    <div class="content">
        <div class="page_article">
            <div class="type_form member_join">
                <form action="${contextPath }/member/joinSave" id="joinForm" method="post">
                    <!-- 회원 가입 대가리 -->
                    <div class="field_head">
                        <h3>회원가입</h3>
                    </div>
                    <p class="input_tiping"><span>입력 사항</span></p>
                    <hr>
                    <!-- 회원 가입 테이블 -->
                    <table class="tbl_comm">
                        <tbody>
                            <tr>
                                <th>
                                    아이디
                                </th>
                                <td id="member_id1">
                                    <input autocomplete="off"  type="text" class="input" name="user_id" id="user_id">                                    
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td id="member_id" >                      
                                    <div id="msg_member_id" class="commonFont">이메일 형식  ex) whatToEat@naver.com</div>
                                    <div id="msg_member_id1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    비밀번호
                                </th>
                                <td id="member_pw1">
                                    <input autocomplete="off" type="password" class="input" name="user_pw" id="user_pw" > 
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td id="member_pw">
                                    <div id="msg_member_pw" class="commonFont">4 ~ 10자리, 알파벳을 섞어서 입력해주세요</div>
                                    <div id="msg_member_pw1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    비밀번호 확인
                                </th>
                                <td id="member_repw1">
                                    <input type="password" class="input" name="user_repw" id="user_repw">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                </th>
                                <td id="member_repw">
                                    <div id="msg_member_repw" class="commonFont">비밀번호를 다시 입력해주세요</div>
                                    <div id="msg_member_repw1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    전화번호
                                </th>
                                <td id="member_tel1">
                                    <input autocomplete="off" type="text" class="input" name="user_tel" id="user_tel">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                </th>
                                <td id="member_tel">
                                    <div id="msg_member_tel" class="commonFont">ex) 010-1234-5678</div>
                                    <div id="msg_member_tel1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    닉네임
                                </th>
                                <td id="member_nick1">
                                    <input autocomplete="off" type="text" class="input" name="user_nickname" id="user_nickname">       
                                </td>
                            </tr>
                            <tr>
                                <th>
                                </th>
                                <td id="member_nick">
                                    <div id="msg_member_nick" class="commonFont">닉네임(별칭)을 입력해주세요</div>
                                    <div id="msg_member_nick1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    생일
                                </th>
                                <td id="member_birth1">
                                    <input type="date" class="input" name="user_birth" id="user_birth">
                                </td>
                            </tr>
                            <tr>
                                <th>
                                </th>
                                <td id="member_birth">
                                    <div id="msg_member_birth" class="commonFont">생일을 입력해주세요</div>
                                    <div id="msg_member_birth1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    성별
                                </th>
                                <td id="member_gender1">
                                    <label for="man" class="select_box"><input type="radio" name="user_gender"
                                            id="man">남성</label>
                                    <label for="woman" class="select_box"><input type="radio" name="user_gender"
                                            id="woman">여성</label>
                                    <label for="none" class="select_box"><input type="radio" name="user_gender"
                                            id="none">선택안함</label>      
                                </td>
                            </tr>
                            <tr>
                                <th>
                                </th>
                                <td id="member_gender">
                                    <div id="msg_member_gender" class="commonFont">성별을 골라주세요</div>
                                    <div id="msg_member_gender1" class="commonFont_msg"></div>
                                </td>
                            </tr>
                        </tbody>


                    </table>
                    <hr>

                    <div class="rapping"><button type="submit" class="btn active btn_join" >가입하기</button></div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>