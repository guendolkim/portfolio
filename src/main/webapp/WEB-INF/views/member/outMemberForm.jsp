<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- common.jsp 적용 -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/member/outMemberForm.css" />
<script defer src="${contextPath }/js/member/outMemberForm.js"></script> 
</head>
<body>
<div class="main">
        <div class="content">
            <div class="section_login">
                <h3>본인 확인란</h3>
                <div class="write_form">
                    <div class="write_view login_view">
                        <form action="${contextPath }/member/outMemberSave" method="post" id="form">
                            <div class="small_title">비밀번호</div>
                            <input type="password" name="currentpw" placeholder="현재 비밀번호를 입력해주세요">
                            <div class="space"></div>
                            <input type="hidden" name="member_id" value="${sessionScope.member.user_id }">
                            <div class="checkbox_save"></div>
                            <button type="button" id="outSubmit" class="btn_type1">확인</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<c:if test="${svr_msg=='비밀번호가 일치하지 않습니다!' }">
		<script type="text/javascript">
			window.alert("비밀번호가 맞지 않습니다!")
		</script>
	</c:if>

</body>
</html>