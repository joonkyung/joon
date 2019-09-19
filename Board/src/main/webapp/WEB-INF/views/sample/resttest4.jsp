<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.domain.MemberVO"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
		<%
			
			List<MemberVO> list = new ArrayList<MemberVO>();
			list.add(new MemberVO("m001","mina" , 7));
			list.add(new MemberVO("m002","hani" , 8));
			list.add(new MemberVO("m003","sana" , 9));
			
			ObjectMapper mapper = new ObjectMapper();
			String list2 = mapper.writeValueAsString(list);
			pageContext.setAttribute("list2", list2);
		%>
	<button>클릭</button>
	<p></p>
	<script type="text/javascript">
		$(document).ready(function() {
			$("button").on("click", function() {
				var test1 = 'hello';
				var test2 = 'hi';
				var test3 = 'good';
				var test4 = [
					{name : 'john' , age : 10 , id : 'm001'},
					{name : 'mina' , age : 11 , id : 'm002'},
					{name : 'hana' , age : 12 , id : 'm003'}
				];
				var test5 = ${list2};
				$.ajax({
					type : 'post',
					url : '/resttest4',
					headers : {
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					data : JSON.stringify({
						test1 : test1,
						test2 : test2,
						test3 : test3,
						test4 : test4,
						test5 : test5
					}),
					dataType : 'text',
					success : function(result) {
						  alert(result);
						  var arr = JSON.parse(result);
		              	  var obj = arr[arr.length-1];
		              	  var msg = obj.name;
		                  $("p").text(msg);
						
					}
				});
			});
		});
	</script>
</body>
</html>