'use strict';

import *as commonLib from '/portfolio/js/common/common.mjs';
//버튼 !
const $findPwBtn = document.getElementById('findPwBtn');

$findPwBtn.addEventListener("click", commonLib.debounce(findPw, 500));

// 이제 생성될 곳
const $findedPw = document.getElementById('findedPw');
const url = "/portfolio/member/findPwSave";
const $user_id = document.getElementById('user_id');
const $user_tel = document.getElementById('user_tel');
const $user_birth = document.getElementById('user_birth');

function findPw(evt) {
	console.log("버튼 클릭됨!!");
	//유효성체크
	if (validChk()) {
		//ajax 호출
		//const birth = $birth.value.replaceAll('-','');
		const jsonObj = {
			member_id: $user_id.value,
			tel: $user_tel.value,
			birth: $user_birth.value
		}
		console.log("jsonObj는 얼마에요?" + jsonObj);

		/*$findPwBtn.lastChild.textContent = '조회중';
		$findPwBtn.disabled = true; //활성화
		$findPwBtn.querySelector('span').classList.remove('visually-hidden');*/

		ajaxCall.post(url, jsonObj, handler);
	}
}

function handler(jsonObj) {
	setTimeout(() => {
			//controller에서 rtcd가 00으로 넘어오면 이걸 생성.
		if (jsonObj.rtcd === '00') {
			$findedPw.textContent = jsonObj.result;
			
			//controller에서 넘어오는 rtcd가 01일 경우에 실행.
		} else {
			$findedPw.textContent = jsonObj.errmsg;
		}

		/*$findPwBtn.lastChild.textContent = '비밀번호 찾기';
		$findPwBtn.disabled = false; //활성화
		$findPwBtn.querySelector('span').classList.add('visually-hidden');*/
	}, 1000);
}

function validChk() {
	let result = true;

	if($user_id.value == "") {
		$findedPw.textContent = '아이디를 입력하세요!';
		$user_id.focus();
		$user_id.select();
		return false;
	}
	if($user_tel.value == "") {
		$findedPw.textContent = '전화번호를 입력하세요!';
		$user_tel.focus();
		$user_tel.select();
		return false;
	}
	if($user_birth.value == "") {
		$findedPw.textContent = '생년월일을 입력하세요!';
		$user_birth.focus();
		$user_birth.select();
		return false;
	}
	return result;
}



