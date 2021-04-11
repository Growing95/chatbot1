<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	/* a요소를 클릭 했을 시 */
	    $('#startchat').click(function(){
	/* iframe 요소의 src 속성값을 a 요소의 data-url 속성값으로 변경 */ 
	        $('#iframe').attr('src');
	        })
	});


	출처: http://b.redinfo.co.kr/36 [꿈꾸는 개발자]

</script>
</head>
<body>

<a href="start.do">클릭</a>
<a id="startchat" href="chat.do">챗봇</a>
	
	
<iframe id="iframe" width="200" height="400" src="http://localhost:8081/chat.do"></iframe>
	
</body>
</html>