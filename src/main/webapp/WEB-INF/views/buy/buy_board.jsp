<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="width:1200px;">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>123</td>
				<td>너무 맛있었어요.</td>
				<td>회원1</td>
				<td>2021.03.20</td>
				<td>201</td>
			</tr>
			<tr>
				<td>124</td>
				<td>회원1님 말 듣고 샀는데 완전 만족이요!</td>
				<td>회원2</td>
				<td>2021.03.25</td>
				<td>260</td>
			</tr>
			<tr>
				<td>125</td>
				<td>너무 먹어서 배탈났어요ㅋㅋㅋ</td>
				<td>회원3</td>
				<td>2021.03.29</td>
				<td>120</td>
			</tr>
		</tbody>
	</table>
	<hr/>
	<div class="right"  style="display: flex; justify-content:flex-end;">
	<div class="btn-group" role="group" aria-label="Basic outlined example">
  <button type="submit" class="btn btn-secondary">글쓰기</button>
	</div>
	</div>

	<div class="btn" style="display: flex; justify-content: center; align-content: center;">
	<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
  <div class="btn-group me-2" role="group" aria-label="First group">
    <button type="button" class="btn btn-outline-secondary" style="background-color: #6c747c; color: white;">1</button>
    <button type="button" class="btn btn-outline-secondary">2</button>
    <button type="button" class="btn btn-outline-secondary">3</button>
    <button type="button" class="btn btn-outline-secondary">4</button>
  </div>
   
    <div class="input-group">
    <input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Input group example" aria-describedby="btnGroupAddon">
    <div class="input-group-text" id="btnGroupAddon">검색</div>
  </div>
 </div>
 </div>
	</div>

	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>	
	
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
</body>
</html>