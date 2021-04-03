'use strict'
//const loginChk = document.getElementById('logout');
const $exitBtn = document.querySelector('.exit');
$exitBtn.addEventListener('click',(evt)=>{
	evt.preventDefault();
	
	console.log('탈퇴 버튼이 클릭되었습니다.');
	
	if(loginChk){
		location.href ="http://localhost:9080/portfolio/mypage/exitPage";
	}else{
		window.alert("로그인이 필요합니다!");
		location.href="http://localhost:9080/portfolio/loginForm";
	}
});
