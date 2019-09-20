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
				<input type="hidden" name="bno" value="${vo.bno}"> <input
					type="hidden" name="perPage" value="${to.perPage}"> <input
					type="hidden" name="curPage" value="${to.curPage}">
			</form>
			<div class="form-gruop">
				<label for="bno">글번호</label> <input id="bno" class="form-control"
					value="${vo.bno}" readonly="readonly">
			</div>
			<div class="form-gruop">
				<label for="title">제목</label> <input id="title" class="form-control"
					value="${vo.title}" readonly="readonly">
			</div>
			<div class="form-gruop">
				<label for="writer">작성자</label> <input id="writer"
					class="form-control" value="${vo.writer}" readonly="readonly">
			</div>
			<div class="form-gruop">
				<label for="content">내용</label>
				<textarea id="content" class="form-control" rows="3"
					readonly="readonly">${vo.content}</textarea>
			</div>
			<div class="form-gruop">
				<label for="updatedate">작성일</label> <input id="updatedate"
					class="form-control" value="${vo.updatedate}" readonly="readonly">
			</div>
			<div class="form-gruop">
				<label for="viewcnt">조회수</label> <input id="viewcnt"
					class="form-control" value="${vo.viewcnt}" readonly="readonly">
			</div>
			<br>
			<div class="form-gruop">
				<button style="float: right" class="btn btn-primary" id="reply_form">댓글</button>
				<button style="float: right" class="btn btn-warning modify">수정</button>
				<button style="float: right" class="btn btn-danger del">삭제</button>
				<button style="float: right" class="btn btn-info list">목록</button>
			</div>
		</div>
		<hr>
		<div class="row">
			<div id="myCollapsible" class="collapse">
				<div class="form-gruop">
					<label for="replyyer">작성자</label> <input class="form-control"
						id="replyyer">
				</div>
				<div class="form-gruop">
					<label for="replytext">내용</label> <input class="form-control"
						id="replytext">
				</div>
				<div class="form-gruop">
					<button class="btn btn-default" id="replyInsertBtn">댓글 등록</button>
					<button class="btn btn-default" id="replyResetBtn">리셋</button>
				</div>
			</div>
		</div><!-- 댓글 입력 -->
		<div id="replies" class="row">
			
			
		</div><!-- 댓글 목록 -->
		<div class="row">
			<ul class="pagination">
			</ul>
         </div>
		<div class="row">
			<div class="modal fade" id="myModal">
				<div data-backdrop= "static" class="modal-dialog">
					<div class = "modal-header">
						<button data-dismiss="modal" class="close">&times;</button>
						<p id="modal_rno"></p>
					</div>
					<div class="modal-body">
						<input class="form-control" id="modal_replytext">
					</div>
					<div class="modal-footer">
						<button id="modal_update" class="btn" data-dismiss="modal">수정</button>
						<button id="modal_delete" class="btn" data-dismiss="modal">삭제</button>
						<button id="modal_close" class="btn" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
		 
	</div>
	<script type="text/javascript">
	var bno = ${vo.bno};
	var replyPage =1;
		$(document).ready(function() {
			
			$(".pagination").on("click","li a", function(event) {
				event.preventDefault();
				replyPage = $(this).attr("href");
				getAllList(bno,replyPage);
			});
		
			$("#replies").on("click",".callModal",function(){
				var rno = $(this).prev("p").attr("data-rno");
				var replytext = $(this).prev("p").text();
				
				$("#modal_rno").text(rno);
				$("#modal_replytext").val(replytext);
				
				$("#myModal").modal("show");
			});
			$("#modal_delete").click(function() {
				var rno = $("#modal_rno").text();	
				
				$.ajax({
					type : 'delete',
					url : '/replies/'+rno,
					headers: {
		                  'Content-Type': 'application/json',
		                  'X-HTTP-Method-Override': 'DELETE'
		              },
		            
		              dataType: 'text',
		              success: function(result){
				           alert(result);
				           getAllList(bno, replyPage);
		              }
				});
			});
			$("#modal_update").click(function() {
				var rno = $("#modal_rno").text();	
				var replytext = $("#modal_replytext").val();
				$.ajax({
					type : 'put',
					url : '/replies/'+rno,
					headers: {
		                  'Content-Type': 'application/json',
		                  'X-HTTP-Method-Override': 'PUT'
		              },
		              data: JSON.stringify({
		            	  replytext : replytext
		              }),
		              dataType: 'text',
		              success: function(result){
				           alert(result);
				           getAllList(bno,replyPage);
		              }
				});
			});
			
			
			$("#reply_form").click(function() {
				$("#myCollapsible").collapse("toggle");
			});
			
			$("#replyResetBtn").click(function() {
				$("#replyyer").val("");
				$("#replytext").val("");
				
			});
			$("#replyInsertBtn").click(function() {
			
				var replyyer = $("#replyyer").val();
				var replytext = $("#replytext").val();
				
				$.ajax({
					type : 'post',
					url : '/replies',
					headers: {
		                  'Content-Type': 'application/json',
		                  'X-HTTP-Method-Override': 'post'
		              },
		              data: JSON.stringify({
		               bno : bno,
		               replyyer : replyyer,
		               replytext : replytext
		              }),
		              dataType: 'text',
		              success: function(result){
		                 alert(result);
		              if(result == 'INSERT SUCCESS'){
		            	  $("#replyyer").val();
		  				  $("#replytext").val();
		  				  getAllList(bno,replyPage);
		              }
		           }
				});
			});
			
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
				$form.attr("action","/board/list?curPage=curPage&perPage=perPage");
				$form.attr("method","get");
				$form.submit();
			});
			getAllList(bno,replyPage);
		});
		function getAllList(bno,replyPage) {
			$.getJSON("/replies/"+bno+"/"+replyPage, function(result) {
				var str = '<hr>';
				var arr = result.list;
				
				for(var  i = 0; i<arr.length; i++){
					str+='<div class="panel panel-info">'+
				'<div class="panel-heading">'+
					'<span>rno : '+arr[i].rno+', 작성자 : <span class="glyphicon glyphicon-user"></span>'+arr[i].replyyer+'</span>'+
					'<span class="pull-right"><span class="glyphicon glyphicon-time"></span>'+arr[i].updatedate+'</span>'+
				'</div>'+
				'<div class="panel-body">'+
					'<p data-rno="'+arr[i].rno+'">'+arr[i].replytext+'</p>'+
					'<button class="btn callModal"><span class="glyphicon glyphicon-pencil"></span>수정/삭제<span class="glyphicon glyphicon-trash"></span></button>'+
				'</div>'+
			'</div>';
				}
				
				$("#replies").html(str);
				printPaging(result)
			});	
		}
		function printPaging(to) {
			var str = '';
			if(to.curPage>1){
				str+= "<li><a href='"+(to.curPage-1)+"'>&laquo;</a></li>"
			}
			for(var i = to.bpn; i<to.spn+1; i++){
				var strClass = to.curPage == i ? 'active' : '';
				str+= "<li class='"+strClass+"'><a href='"+i+"'>"+i+"</a></li>"
			}
			if(to.curPage<to.totalPage){
				str+= "<li><a href='"+(to.curPage+1)+"'>&raquo;</a></li>"
			}
			$(".pagination").html(str);
		}
		
	</script>
</body>
</html>