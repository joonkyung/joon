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
			<div class="jumbotron">
		<h1>수정</h1>
		<form>
		<input type="hidden" name="curPage" value="${to.curPage}">
		<input type="hidden" name="perPage" value="${to.perPage}">
				<div class="form-gruop">
					<label for="title">글번호</label>
					<input id="bno" name="bno" class="form-control" value="${vo.bno}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="title">제목</label>
					<input id="title" name="title" class="form-control" value="${vo.title}" required="required">
				</div>
				<div class="form-gruop">
					<label for="writer">작성자</label>
					<input id="writer" name="writer" class="form-control" value="${vo.writer}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="content">내용</label>
					<textarea id="content" name="content" class="form-control" rows="3" required="required">${vo.content}</textarea>
				</div>
				<div class="form-gruop">
					<label for="updatedate">작성일</label>
					<input id="updatedate" name="updatedate" class="form-control" value="${vo.updatedate}" readonly="readonly">
				</div>
				<div class="form-gruop">
					<label for="viewcnt">조회수</label>
					<input id="viewcnt" name="viewcnt" class="form-control" value="${vo.viewcnt}" readonly="readonly">
				</div>
		</form>
				<div class="form-gruop">
					<button class="btn btn-warn modify">수정</button>
				</div>
				
				</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			var $form = $("form");
			$(".modify").click(function() {
				$form.attr("action","/board/modify");
				$form.attr("method","post");
				$form.submit();
			});
		});
	</script>
</body>
</html>