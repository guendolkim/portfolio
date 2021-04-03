'use strict'

const $submit = document.getElementById('outSubmit');
const $form = document.getElementById('form');
$submit.addEventListener('click', (e) => {
	e.preventDefault();
	var chk = window.confirm("정말 탈퇴하시겠습니까?")
	if (chk == true) {
		$form.submit();
	} else {
		
		
	}
});