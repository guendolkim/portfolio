'use strict';

const $loginBtn = document.getElementById('loginBtn');
$loginBtn.addEventListener('click', loginHandler);

function loginHandler(evt){
	evt.preventDefault();//기본이벤트 막기
	console.log('로그인클릭됨!');
	/* 유효성체크 */
	//1)아이디체크
	//1-1)입력유무 
	if (id.value.trim().length == 0) {
/*		document.getElementsByClassName('svr_msg').style.display = "none";*/
		document.getElementById('err_msg_id').textContent = '아이디를 입력해주세요';
		id.focus();
		return;
	} else {
		/*document.getElementById('svr_msg').style.display = "block";*/
		document.getElementById('err_msg_id').textContent = '';
	}
	//2)비밀번호체크
	if (pw.value.trim().length == 0) {
		/*document.getElementsByClassName('svr_msg').style.display = "none";*/
		document.getElementById('err_msg_pw').textContent = '비밀번호를 입력해주세요';
		pw.focus();
		return;
	} else {
		/*document.getElementById('svr_msg').style.display = "block";*/
	}
	loginForm.submit();
}
/*function validchk(){
	let flag = true;
	if(id.value.trim().length==0){
		flag = false;
		return flag;
	}
}

function submit(e){
	e.preventDefault();
	if(validchk()){
		loginForm.submit();
	}
}*/

