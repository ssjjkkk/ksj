<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JsonTest</title>
<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
<script>
	$(function() {
		$('button').on('click', function() {
			// 문자열 응답 데이터
// 			$.ajax({
// 				type : 'post',
<%-- 				url : '<%= request.getContextPath()%>/JsonTestServlet.do', --%>
// 				dataType : 'json',
// 				success : function(data) {
// 					$('#result').html("ajax 처리 데이터 : " + data);
// 				},
// 				error : function(res) {
// 					alert("상태 : " + res.status);
// 				}
// 			})
			
			// 배열 응답 데이터
// 			$.ajax({
// 				type : 'post',
<%-- 				url : '<%= request.getContextPath()%>/JsonTestServlet.do', --%>
// 				dataType : 'json',
// 				success : function(data) {
// 					let str = "";
// 					$.each(data, function(i, v) {
// 						str += i + " 번째 자료 : " + v + "<br>"	;
// 					});
// 					$('#result').html(str);
					
// 				},
// 				error : function(res) {
// 					alert("상태 : " + res.status);
// 				}
// 			})
			
			// 객체 응답 데이터 처리
// 			$.ajax({
// 				type : 'post',
<%-- 				url : '<%= request.getContextPath()%>/JsonTestServlet.do', --%>
// 				dataType : 'json',
// 				success : function(data) {
// 					let str = "";
// 					str += "ID : " + data.id + "<br>";
// 					str += "NAME : " + data.name + "<br>";
					
// 					$('#result').html(str);
// 				},
// 				error : function(res) {
// 					alert("상태 : " + res.status);
// 				}
// 			})
			
			// List 컬렉션 응답 데이터 처리
			$.ajax({
				type : 'post',
				url : '<%= request.getContextPath()%>/JsonTestServlet.do',
				dataType : 'json',
				success : function(data) {
					let str = "";
					$.each(data, function (i, v) {
						str += i + " 번째 자료<br>";
						str += "ID : " + v.id + "<br>";
						str += "NAME : " + v.name + "<br>";
					});
					$('#result').html(str);
				},
				error : function(res) {
					alert("상태 : " + res.status);
				}
			})
			
		})
	})
</script>
</head>
<body>
	<button>JSON 데이터 가져오기</button>
	<hr>
	<h3>가져온 데이터</h3>
	<div id="result">
		
	</div>
</body>
</html>