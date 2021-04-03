<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<link rel="stylesheet" href="${contextPath }/css/mypage/modifyPage.css" />
<script defer src="${contextPath }/js/mypage/modifyPage.js"></script>
<script defer src="${contextPath }/js/mypage/mypage.js"></script>
</head>
<body>

	<!-- upperMst -->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
	<!-- header -->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="wrapper">
		<div class="content_mypage">
			<div class="myPage">
				<p>마이페이지</p>
				<div class="pageList">
					<a href="${contextPath }/mypage/myPage"><div class="orderlist">주문
							내역</div></a> 
							<a href="${contextPath }/mypage/saveRecipe"><div class="review">저장한 레시피</div></a> <a
						href="${contextPath }/mypage/myRecipePage"><div
							class="myrecipe">작성한 레시피</div></a> <a
						href="${contextPath }/mypage/modifyPage"><div class="modify">개인
							정보 수정</div></a> <a href="${contextPath }/mypage/exitPage"><div
							class="exit">회원탈퇴</div></a>
				</div>
			</div>

			<!-- 회원정보수정 -->
			<div class="changeInfo">
				<form action="${contextPath }/mypage/modifyPageSave" id="modifyForm" method="post" enctype="multipart/form-data">
					<h3>개인 정보 수정</h3>
					<hr>
					<table class="table">
						<tr>
							<th id="imgArea"><img id="picView" src="data:;base64,${sessionScope.member.picBase64}"
								onerror="this.src='/portfolio/img/board/profile.png'" alt=""
								width="100px" height="100px"></th>
							<td id="picArea"><input type="file" id="file" name="file" class="input">
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td><input type="text" class="input"
								value="${member.user_id }" id="user_id" name="user_id" readonly="readonly"></td>
						</tr>
						<tr>
							<th>현재 비밀번호</th>
							<td><input type="password" class="input"  name="user_pw" id="beforePw"
								placeholder="현재 비밀번호를 입력해주세요"></td>
							<td><button type="button" id="pwChangeBtn">비밀변호 변경</button></td>
						</tr>
						<tr class="togglePw" style="display: none">
							<th>변경할 비밀번호</th>
							<td><input type="password" class="input" name="user_pw"
								id="user_pw" placeholder="변경할 비밀번호를 입력해주세요"></td>
						</tr>
						<tr>
							<th></th>
							<td id="member_pw">
								<div id="msg_member_pw1" class="commonFont_msg"></div>
							</td>
						</tr>
						<tr class="togglePw" style="display: none">
							<th>비밀번호 재확인</th>
							<td><input type="password" class="input" 
								id="user_repw" placeholder="변경할 비밀번호를 다시 입력해주세요"></td>
						</tr>
						<tr>
							<th></th>
							<td id="member_repw">
								<div id="msg_member_repw1" class="commonFont_msg"></div>
							</td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><input type="text" class="input" name="user_tel"
								id="user_tel" value="${member.user_tel }"></td>
						</tr>
						<tr>
							<th></th>
							<td id="member_tel">
								<div id="msg_member_tel1" class="commonFont_msg"></div>
							</td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td><input type="text" class="input" name="user_nickname"
								id="user_nickname" value="${member.user_nickname }"></td>
						</tr>
						<tr>
							<th></th>
							<td id="member_nick">
								<div id="msg_member_nick1" class="commonFont_msg"></div>
							</td>
						</tr>
						<tr>
							<th>성별</th>
							<td><label for="man" class="select_box"><input
									type="radio" name="user_gender" id="man">남성</label> <label
								for="woman" class="select_box"><input type="radio"
									name="user_gender" id="woman">여성</label> <label for="none"
								class="select_box"><input type="radio"
									name="user_gender" id="none">선택안함</label></td>
						</tr>
						<tr>
							<th></th>
							<td id="member_gender">
								<div id="msg_member_gender1" class="commonFont_msg"></div>
							</td>
						</tr>
					</table>
					<hr>
					<div class="rapping">
						<button type="submit" id="submitBtn" class="btn active btn_join">회원정보
							수정</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>

	const $imgArea = document.getElementById('imgArea');
	const $file = document.getElementById('file');
	const $hiddenPic = document.getElementById('hiddenPic');
	const $picView = document.getElementById('picView');

	 $imgArea.addEventListener('click',evt=>{
	  $file.click();
	 });
	$file.addEventListener('change',evt=>{
	  const url = URL.createObjectURL($file.files[0]);
		$picView.src = url;

	});
	
	const modifyInfo={
		"user_id": '${member.user_id}',
		"user_birth": '${member.user_birth}',
		"user_tel": '${member.user_tel}'
			}
</script>
<!-- footer부분을 이어주는 링크 -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>