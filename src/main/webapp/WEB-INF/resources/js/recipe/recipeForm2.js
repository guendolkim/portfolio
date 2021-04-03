'use strict';

const $materialBtn = document.getElementById('materialBtn');
const $stepBtn = document.getElementById('stepBtn');
const $common_id = document.getElementById('common_id'); //recipe_id값 
const $submitBtn = document.getElementById('submitBtn'); //
const $deleteBtn = document.getElementById('deleteBtn[0]');

//카운트용 변수
let materialNum = 1;
let stepNum = 1;
let stepPreviewNum = 1;
//재료 추가 버튼
$materialBtn.addEventListener('click', ()=>{
	console.log('재료 버튼 호출됨');
	const $materialPlus = document.getElementById('materialPlus');
	const $div = makeMaterial();
	$materialPlus.appendChild($div);	
});

//순서 추가 버튼
$stepBtn.addEventListener('click', ()=>{
	console.log('순서 버튼 호출됨');
	console.log("stepPreviewNum"+stepPreviewNum);
	const $stepPlus = document.getElementById('stepPlus');
	const $div = makeStep();
	$stepPlus.appendChild($div);
	

});

//레시피 등록 버튼
$submitBtn.addEventListener('click', ()=>{
	materialNum = 1;
	$sumbmitBtn.submit;
});

//=============================사진 미리보기=============================






function readImage(input){
	//input에 파일이 있는 경우
	if(input.files && input.files[0]){
		
		//fileReader 인스턴스 생성하고
		const reader = new FileReader();
		//이미지가 로드된 경우
		reader.onload = (evt)=>{
			/*const $previewImage =document.getElementById("preview-image["+stepNum+"]");*/
			const $previewImage =document.getElementById("preview-image["+stepNum+"]");
			$previewImage.src = evt.target.result;
		}
		//reader가 이미지 읽도록 하기.
		reader.readAsDataURL(input.files[0]);
	}
}



//=============================함수 모음==============================
//삭제 버튼
function NodeDelete(evt){
	
	console.log(evt.target);
	let aaa = evt.target.parentElement;
	aaa.parentElement.removeChild(aaa);
}
//=========================기존에 있는 항목 삭제 리스너==============================
$deleteBtn.addEventListener('click',()=>{
		console.log("0번째 삭제 클릭됨");
		var tar = document.getElementById('materialLab_0');
		tar.parentElement.removeChild(tar);
});
$deleteBtn.addEventListener('click',()=>{
		console.log("0번째 삭제 클릭됨");
		var tar = document.getElementById('materialLab_0');
		tar.parentElement.removeChild(tar);
});


function makeMaterial() {
//둘러싸는 div
	const divNode = document.createElement("div");
	divNode.setAttribute("id", "materialLab_"+materialNum);
	divNode.setAttribute("class", "main materialLab")
	const aNode = document.createElement("a");
	aNode.setAttribute("href", "#");
	aNode.innerHTML="😀";
	divNode.appendChild(aNode);
//재료 입력창	
	const titelNode = document.createElement("input");
	titelNode.setAttribute("name", "listMaterialVO["+materialNum+"].material_title");
	titelNode.setAttribute("id", "material_title["+materialNum+"]");
	titelNode.setAttribute("type","text");
	divNode.appendChild(titelNode);
//수량 입력창	
	const contentsNode = document.createElement("input");
	contentsNode.setAttribute("name", "listMaterialVO["+materialNum+"].material_contents");
	contentsNode.setAttribute("id", "material_contents["+materialNum+"]");
	contentsNode.setAttribute("type","text");
	divNode.appendChild(contentsNode);
//recipe_id 입력창	
	const hidden = document.createElement("input");
	hidden.setAttribute("name", `listMaterialVO[${materialNum}].recipe_recipe_id`);
	hidden.setAttribute("id", "material_contents");
	hidden.setAttribute("type", "hidden");
	hidden.setAttribute("value", $common_id.value);
	divNode.appendChild(hidden);
//삭제버튼
	const $delete = document.createElement("a");
	$delete.innerHTML= "🗑 ";
	$delete.setAttribute("id", $deleteBtn.class+"["+materialNum+"]");
	$delete.setAttribute("href", "#");
	$delete.setAttribute("class", $deleteBtn.className);
	$delete.addEventListener('click', NodeDelete);
	divNode.appendChild($delete);

	++materialNum;
	return divNode;
}

function makeStep() {
//둘러싸는 div
	const divNode = document.createElement("div");
	divNode.setAttribute("id", "stepLab_"+stepNum);
	divNode.setAttribute("class", "main stepLab")
	const aNode = document.createElement("a");

	aNode.innerHTML="🌜";
	divNode.appendChild(aNode);
//조리 방법 입력창	
	const titelNode = document.createElement("input");
	titelNode.setAttribute("name", "listStepVO["+stepNum+"].step_contents");
	
	titelNode.setAttribute("type","text");
	divNode.appendChild(titelNode);
//사진 앞에 공간
	const center = document.createElement("div");
	center.innerHTML="📷  ";
	center.setAttribute("class", "pircture_space");
	divNode.appendChild(center);
	
//사진 입력창	
	const contentsNode = document.createElement("input");
	contentsNode.setAttribute("name", "listStepVO["+stepNum+"].step_picture");
	contentsNode.setAttribute("id", "step_picture["+stepNum+"]");
	contentsNode.setAttribute("type","file");
	
	//임시로 저장함.
	contentsNode.setAttribute("class","step");
	divNode.appendChild(contentsNode);
//사진 프리뷰 공간 마련
	const $preView = document.createElement("img");
	$preView.setAttribute("class", "preview img["+stepPreviewNum +"]");
	$preView.setAttribute("id", "preview-image["+stepPreviewNum +"]");
	$preView.setAttribute("src", "data:;base64");
	divNode.appendChild($preView);
//recipe_id 입력창	
	const hidden = document.createElement("input");
	hidden.setAttribute("name", `listStepVO[${stepNum}].recipe_recipe_id`);
	
	hidden.setAttribute("type", "hidden");
	hidden.setAttribute("value", $common_id.value);
	divNode.appendChild(hidden);
//삭제버튼
	const $delete = document.createElement("a");
	$delete.innerHTML= "🗑 ";
	$delete.setAttribute("id", $deleteBtn.class+"["+stepNum+"]");
	$delete.setAttribute("href", "#");
	$delete.setAttribute("class", $deleteBtn.className);
	$delete.addEventListener('click', NodeDelete);
	divNode.appendChild($delete);

	++stepNum;
	++stepPreviewNum;
	return divNode;
}
//input file에 change 이벤트를 부여







