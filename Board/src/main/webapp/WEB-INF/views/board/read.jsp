<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<h1>자세히 보기</h1>
		<form action="">
			<input type="hidden" name="bno" value="${vo.bno}">
		</form>
				<div class="form-gruop">
					<label for="bno">글번호</label>
					<input id="bno" class="form-control" value="${vo.bno}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="title">제목</label>
					<input id="title" class="form-control" value="${vo.title}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="writer">작성자</label>
					<input id="writer" class="form-control" value="${vo.writer}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="content">내용</label>
					<textarea id="content" class="form-control" rows="3" readonly="readonly">${vo.content}</textarea>
				</div>
				<div class="form-gruop">
					<label for="updatedate">작성일</label>
					<input id="updatedate" class="form-control" value="${vo.updatedate}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="viewcnt">조회수</label>
					<input id="viewcnt" class="form-control" value="${vo.viewcnt}" readonly="readonly">
				</div>
				<br>
				<button style="float: right" class="btn btn-warning modify">수정</button>
				<button style="float: right" class="btn btn-danger del">삭제</button>
				<button style="float: right" class="btn btn-dark list">목록</button>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			var $form = $("form");
			
			$(".modify").click(function() {
				$form.attr("action","/board/modify");
				$form.attr("method","get");
				$form.submit();
			});
			$(".del").click(function() {
				$form.attr("action","/board/del");
				$form.attr("method","post");
				$form.submit();
			});
			$(".list").click(function() {
				$form.attr("action","/board/listall");
				$form.attr("method","get");
				$form.submit();
			});
		});
	</script>
</body>
</html>