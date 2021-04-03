'use strict'

/*const $shareBtn = document.getElementById('shareBtn');
document.addEventListener('click', copy);*/

/*function copy(event){
	console.log("copy 호출됨");
  if(event.target.tagName=="I"){
    const $urlbox = document.createElement("input");
    document.body.appendChild($urlbox);
    $urlbox.value = http://localhost:9080${event.target.parentElement.dataset.cafe_href};
    $urlbox.select();
    document.execCommand("copy");
    document.body.removeChild($urlbox);
    alert("선택하신 카페의 상세페이지가 복사되었습니다.")
  }

}*/
const other = document.getElementById('other_main');
document.onload= function(){
	if(other == null){
		other.setAttribute("src","https://picsum.photos");
	}
}


const $likeBtn = document.getElementById('recipeLike');
$likeBtn.addEventListener('click',()=>{
console.log("저장 버튼이 클릭되었습니다.");
console.log("recipe_id: "+recipeInfo.recipe_id);
console.log("user_id: "+recipeInfo.user_id);

const url="/portfolio/recipe/recipeLike";
const jsonObj={
	"user_id"	 : recipeInfo.user_id,
	"recipe_id"  : recipeInfo.recipe_id
}
console.log("user_id: "+jsonObj.user_id); 
console.log("recipe_id: "+jsonObj.recipe_id); 
console.log("url: "+url); 
	
	if(jsonObj.user_id.trim() == ""){
		window.alert("로그인을 해주세요");
		location.href="/portfolio/loginForm";
		return;
	}else{
		post(url, jsonObj, handler);		
	}
});


function post(url, jsonObj, handler){
	fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',  //전송데이터 타입
        'Accept': 'application/json'         //수신데이터 타입
      },
      body: JSON.stringify(jsonObj)           //js => json포맷 문자열로변환
    })
      .then(response => response.json())
      .then(json => {console.log(json);
                         handler(json);})
      .catch(error => console.error(error));
}

function handler(json){
	console.log("responss는1 :"+json);
	console.log("responss는2 :"+json.toString());
	if(json.rtcd == '00'){
		window.alert("저장되엇습니다.");
	}else{
		window.alert("저장이 취소되었습니다.");
	}
}