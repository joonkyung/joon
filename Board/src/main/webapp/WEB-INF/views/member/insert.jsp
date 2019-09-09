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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/member/insert" method="post">
		id: <input name="id"><button>중복 체크</button><p id ="result"></p>
		name: <input name="name"><br>
		age: <input name="age" type="number"><br>	
		<input type="submit">
	</form>
	<a href = "/member/list">목록</a>
	<script type="text/javascript">
		$(document).ready(function() {
			$("button").click(function(event) {
				event.preventDefault(); //버튼 클릭했을때 다른 페이지로 넘어가지 않도록
				var id = $("input[name='id']").val();
				$.ajax({
					type : 'post',
					url : '/member/idcheck',
					data:{
						id:id
					},
					dataType : 'text',
					success : function(result) {
						$("p").text(result)
					}
				});
			});
		});
		
	</script>
</body>
</html>