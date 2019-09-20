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
<style>
	.fileDrop{
		width:  100%;
		height: 200px;
		border: 1px dotted red;
	}
</style>
</head>
<body>
	<div class="fileDrop"></div>
	<div class="uploadList"></div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$(".fileDrop").on("dragenter dragover", function(event) {
				event.preventDefault();
			});
			$(".fileDrop").on("drop",function(event){
				event.preventDefault();
					
				var arr = event.originalEvent.dataTransfer.files;
				//for문을 이용해서 다중 업로드 단일업로드가 가능하다
				for(var i = 0; i<arr.length; i++){
					var file = arr[i];
				
					var formData = new FormData();
					formData.append("file",file);
				
					$.ajax({
						type : 'post',
						url : '/uploadajax',
						data : formData,
						dataType : 'text',
						contentType : false,
						processData : false,
						success : function(data) {
							var str ='';
							if(checkImageType(data)){
								str += "<img src='displayfile?filename="+data+"' alt='이미지 파일 썸네일'/>"
							}else {
								str += "<img src='/resources/test2.PNG' alt='일반파일 썸네일' />"
							}
							$(".uploadList").append(str);
						}
					});	
				}
			});
		});
		
		function checkImageType(data) {
			var pattern = /jpg|png|jpeg|gif/i;
			return data.match(pattern);
		}
	</script>
</body>
</html>