<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
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

	<p id="result"></p>
	<button>클릭</button>

	<script type="text/javascript">
		$(document).ready(function() {
			$("button").click(function() {
				$.ajax({ //ajax는 순서를 무시한다
					type : 'post',
					url : '/test1',
					data : {
						'str' : 'hello' // json으로 데이터 넘김.
					},
					dataType : 'text',
					success : function(result) { //성공했을때
						$("#result").text(result);
					}
				});
			});
		});
	</script>

</body>
</html>