'use strict'

//검색 페이지
const $searchBtn = document.getElementById('searchBtn');
const $navinput = document.getElementById('nav-input');

$searchBtn.addEventListener('click',()=>{
	if($navinput.value.trim().length != 0){
		location.href = `http://localhost:9080/portfolio/searchList?keyword=${$navinput.value}`;
	}else{
		window.alert("검색어를 입력해주세요!");
	}
	
});

//레시피 입력란
const $recipeWriteBtn = document.getElementById('recipeWriteBtn');

const loginChk = document.getElementById('logout');
$recipeWriteBtn.addEventListener('click',(evt)=>{
	console.log("레시피 작성 버튼이 클릭됨");	
	evt.preventDefault();
	//로그인이 안되어 있을 시에 작성 안됨.
	
	if(loginChk){
		location.href ="http://localhost:9080/portfolio/recipe/recipeForm";
	}else{
		window.alert("로그인이 필요합니다!");
	}
});

