<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프렌치 생성</title>
<meta name="viewport" content="width=divice-width,initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="row">
		<h1>글쓰기</h1>
			<form action="/board/create" method="post">
				<div class="form-gruop">
					<label for="title">제목</label>
					<input id="title" name="title" class="form-control">
				</div>
				<div class="form-gruop">
					<label for="writer">작성자</label>
					<input id="writer" name="writer" class="form-control">
				</div>
				<div class="form-gruop">
					<label for="content">내용</label>
					<textarea id="content" name="content" class="form-control" rows="3"></textarea>
				</div>
				<div class="form-gruop">
					<input class="btn btn-primary" type="submit" value="등록">
				</div>
			</form>
		</div>
	</div>
</body>
</html>