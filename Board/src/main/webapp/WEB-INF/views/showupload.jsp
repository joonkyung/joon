<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<c:forEach items="${savedNameList}" var="savedName">
      <c:if test="${not empty savedName}">
      	<c:choose>
      		<c:when test="${fn:endsWith(savedName,'.jpg')|| fn:endsWith(savedName,'.jpeg')|| fn:endsWith(savedName,'.png') }">
      		  <img alt="업로드된 파일 중 하나" src="displayfile?filename=${savedName}">
      		</c:when>
      		<c:otherwise>
      		 <img alt="dda" src="/resources/test2.PNG">
      		</c:otherwise>
      	</c:choose>
        </c:if>
   </c:forEach>
   
</body>
</html>