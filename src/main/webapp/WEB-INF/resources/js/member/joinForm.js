'use strict';


const $member_id1 = document.getElementById('member_id1');
const $member_pw1 = document.getElementById('member_pw1');
const $member_repw1 = document.getElementById('member_repw1');
const $member_tel1 = document.getElementById('member_tel1');
const $member_nick1 = document.getElementById('member_nick1');
const $member_birth1 = document.getElementById('member_birth1');


const $msg_member_id = document.getElementById('msg_member_id');
const $msg_member_pw = document.getElementById('msg_member_pw');
const $msg_member_repw = document.getElementById('msg_member_repw');
const $msg_member_tel = document.getElementById('msg_member_tel');
const $msg_member_nick = document.getElementById('msg_member_nick');
const $msg_member_birth = document.getElementById('msg_member_birth');
const $msg_member_gender = document.getElementById('msg_member_gender');


// 클릭시 도움말 표시 시작
$member_id1.addEventListener('click',evt=>{
  $msg_member_id.style.display='block';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_tel.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_birth.style.display='none';
$msg_member_gender.style.display='none';
  	msg_member_id1.textContent='';
});
$member_pw1.addEventListener('click',evt=>{
  $msg_member_pw.style.display='block';
  $msg_member_id.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_tel.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_birth.style.display='none';

$msg_member_gender.style.display='none';
	msg_member_pw1.textContent='';
});
$member_repw1.addEventListener('click',evt=>{
  $msg_member_repw.style.display='block';
  $msg_member_pw.style.display='none';
  $msg_member_tel.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_birth.style.display='none';
  $msg_member_id.style.display='none';
$msg_member_gender.style.display='none';
	msg_member_repw1.textContent='';
});
$member_tel1.addEventListener('click',evt=>{
  $msg_member_tel.style.display='block';
  $msg_member_repw.style.display='none';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_birth.style.display='none';
  $msg_member_id.style.display='none';
$msg_member_gender.style.display='none';
	msg_member_tel1.textContent='';
});
$member_nick1.addEventListener('click',evt=>{
  $msg_member_nick.style.display='block';
  $msg_member_tel.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_birth.style.display='none';
  $msg_member_id.style.display='none';
$msg_member_gender.style.display='none';
	msg_member_nick1.textContent='';
});
$member_birth1.addEventListener('click',evt=>{
  $msg_member_birth.style.display='block';
  $msg_member_nick.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_id.style.display='none';
  $msg_member_gender.style.display='none';
	msg_member_birth1.textContent='';
});
member_gender1.addEventListener('click',evt=>{
  $msg_member_id.style.display='none';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_tel.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_birth.style.display='none';
  $msg_member_gender.style.display='block';
  	msg_member_gender1.textContent='';
});



// 클릭시 도움말 표시 끝

//회원가입 버튼 입력 시 오류 체크 시작

const $btn_join = document.querySelector('.btn_join');

$btn_join.addEventListener('click', joinHandler);

function joinHandler(evt){
	console.log("전송버튼이 클릭됨");
  //회원가입 버튼 클릭시 도움말 표시 삭제
  $msg_member_nick.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_pw.style.display='none';
  $msg_member_repw.style.display='none';
  $msg_member_nick.style.display='none';
  $msg_member_id.style.display='none';
  $msg_member_birth.style.display='none';
  //submit클릭 막기
  evt.preventDefault(); 

  //유효성 체크 통과 못해을 경우 리턴
  if(!validationChk(evt)){
		return;
	}else{
		//유효성 통과시 제출
  		joinForm.submit();	
	}

  
}

function validationChk(){
  //아이디체크
  if(!isEmail(user_id.value)){
    $msg_member_id.style.display='none';
    //오류메세지
    msg_member_id1.textContent='아이디를 잘못 입력하셨습니다.';
    //포커스이동
    user_id.focus();user_id.select();
    return false;
  }else{
    msg_member_id1.textContent='';
  }
  //비밀번호 체크
  if(!isPasswd(user_pw.value)){
    $msg_member_pw.style.display='none';
    //오류메세지
    msg_member_pw1.textContent='4~10자리 영문, 숫자만 가능 합니다.';
    //포커스이동
    user_pw.focus();user_pw.select();
    return false;
  }else{
    msg_member_pw1.textContent='';
  }
  //비밀번호 일치여부 체크
  if(user_pw.value !== user_repw.value){
    msg_member_repw1.textContent='비밀번호가 일치하지 않습니다.';
    user_repw.focus();ueser_repw.select();
    return false;
  }else{
    msg_member_repw1.textContent='';
  }
  //전화번호 체크
  if(!isTel(user_tel.value)){
    $msg_member_tel.style.display='none';
    //오류메세지
    msg_member_tel1.textContent='전화번호 형식에 맞지 않습니다. ex)010-1234-5678';
    //포커스이동
    user_tel.focus();user_tel.select();
    return false;
  }else{
    msg_member_tel1.textContent='';
  }
  //닉네임(별칭) 체크
  if(!isNickname(user_nickname.value)){
    $msg_member_nick.style.display='none';
    //오류메세지
    msg_member_nick1.textContent='닉네임을 입력해주세요';
    //포커스이동
    user_nickname.focus();user_nickname.select();
    return false;
  }else{
    msg_member_nick1.textContent='';
  }

//생일 확인
	if(user_birth.value == ""){
		$msg_member_birth.style.display='none';
	   //오류메세지
	   msg_member_birth1.textContent='생일을 입력하지 않으셨습니다';
		user_birth.focus();user_birth.select();
		return false;
	}else{
		msg_member_birth1.textContent='';
	}
//성별 체크
	if(radioChk() == false){
		msg_member_gender.style.display='none';
	  	msg_member_gender1.textContent='성별을 선택해주세요';
	  return false;
	}else{
	  	msg_member_gender1.textContent='';
	}
	
	return true;
}







//아이디(이메일) 체크
function isEmail(user_id){
  const emailPattern = /^[\w]([-_\.]?[\w])*@[\w]([-_\.]?[\w])*\.[a-zA-Z]{2,3}$/;
  return emailPattern.test(user_id);
}

//비밀번호 체크
//대소문자 또는 숫자로 시작하고 끝나며 4 ~10자리인지 검사한다.
function isPasswd(user_pw){
  const passwdPattern = /^[\w]{4,10}$/; // /^[A-Za-z0-9]{4,10}$/
  return passwdPattern.test(user_pw); 
}

//별칭 유효성체크
//한글 알파벳 대소문자 또는 숫자로 시작하고 끝나며 4 ~10자리인지 검사한다.
function isNickname(user_nickname){
  const nicknamePattern = /^[가-힣ㄱ-ㅎㅏ-ㅣA-Za-z0-9]{4,10}$/;
  return nicknamePattern.test(user_nickname); 
}

//전화번호체크
function isTel(user_tel){
  const telPattern = /^\d{3}-\d{3,4}-\d{4}$/;
  return telPattern.test(user_tel); 
}

//숫자인지 체크
function isNum(num){
  const numPattern = /^[\d]*$/;
  return numPattern.test(num);
}

//생일 유효성 검사
function isBirth(user_birth){
	const birthPattern = /^[0-9]{4}-[0-9]{2}-[0-9]{2})$/;
	return birthPattern.test(user_birth);
}
//성별 검사
function radioChk(){
	const $gender = document.getElementsByName('user_gender');
	let result = false;
	for(let i=0; i<$gender.length; i++ ){
		if($gender[i].checked == true){
			result = true; 
			break;
		}
	  }
	return result;
}

//4~10자리수의 숫자인지 체크
function isNum2(num){
  const numPattern = /^[\d]{4,10}$/;  ///^[0-9]{4,10}$/
  return numPattern.test(num);
}