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
		var arr = [ 'a', 'b', 'c' ];

		$(document).ready(function() {

			$("button").on('click', function() {
				$.ajax({
					type : "post",
					url : "/test2",
					traditional : true,
					data : {
						'arr' : arr
					},
					dataType : 'text',
					success : function(result) {
						//var arr2 = eval(result) //eval은 큰따옴표를 없엔다는 뜻
						var arr2 - JSON.parse(result);	//위 같은데 일관성있는거는 이거다
						$("p").text(arr2[1])
					}
				});
			});
		});
	</script>
</body>
</html>