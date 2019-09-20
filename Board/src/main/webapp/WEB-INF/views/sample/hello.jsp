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
<h1>hello</h1>
   hello.jsp<br>
   
   <button>click</button>
   <p></p>
   
   <script type="text/javascript">
      $(document).ready(function(){
         $("button").on("click", function(){
            var test1 = 'hello';
            
            $.ajax({
               type: 'post',
               url: '/resttest1',
               headers: {
                  'Content-Type': 'application/json',
                  'X-HTTP-Method-Override': 'post'
               },
               data: JSON.stringify({
                  // ''없이 자바스크립트 표현으로 가능하다.
                  test1 : test1
               }),
               dataType: 'text',
               success: function(result){
                  alert(result);
                  var obj = JSON.parse(result);
                  {test1 : 'hello1'}
                  $("p").text(obj.test1);
               }
            });
         });
      });
   </script>
</body>
</html>