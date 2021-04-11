<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8"/>
	<style type="text/css">
/* 	#message{ position: fixed; } */
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="resources/js/sockjs.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#chatForm").submit(function(event){
				event.preventDefault();
				sock.send($("#message").val());
				$("#message").val('').focus();
			});
		});
		
		var sock = new SockJS("/echo");
		sock.onmessage = function(e){
			$("#chat").append(e.data + "<br/>");
		}
		/* 
		sock.onclose = function(){
			$("#chat").append("연결 종료");
		} */
		
	</script>
</head>
<body>
	<div id="chat">
	
	</div>
	<br><br><br><br><br><br>
	<form id="chatForm" >
		<input type="text" id="message" />
		<button>send</button>
	</form>
	
</body>
</html>