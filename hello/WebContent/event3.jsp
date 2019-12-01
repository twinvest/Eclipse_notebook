<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">
<!--  
Jquery 적용 전입니다.
<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>

<script>
$(document).ready(function(){
$("#main_aside li a.menu01").click(function(){
	$("#bar").stop().animate({"width":200});
});
});

</script>
 -->
</head>
<body>
	<div id="jb-container">
		<div id="jb-header">
			<jsp:include page="header.jsp" />
			<!--  
<div id="bar">
<ul>
<li><a class ="bar1" href="#">인터넷 서적</a></li>
<li><a class ="bar1" href="#">만화</a></li>
<li><a class ="bar1" href="#">자격증</a></li>
</ul>

-->
		</div>
		<div id="jb-top">
			<jsp:include page="top.jsp" />
		</div>
		<div id="jb-sidebar-left">
			<jsp:include page="aside.jsp" />
		</div>
		<div id="jb-content">
			&nbsp Event <br />
			<br />
			<br />
			<br /> <img src="img/event2.jpg" width=500>
			</guk>
		</div>
		<div id="jb-sidebar-right">
			<jsp:include page="aside2.jsp" />
		</div>
		<div id="jb-footer">
			<jsp:include page="bottom.jsp" />
			<jsp:include page="footer.jsp" />
		</div>
	</div>
	<hr />
</body>
</html>