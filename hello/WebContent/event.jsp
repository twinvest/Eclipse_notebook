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
Jquery ���� ���Դϴ�.
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
<li><a class ="bar1" href="#">���ͳ� ����</a></li>
<li><a class ="bar1" href="#">��ȭ</a></li>
<li><a class ="bar1" href="#">�ڰ���</a></li>
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
			<guk id="event">
			<h3>&nbsp Event</h3>
			<br />
			&nbsp&nbsp&nbsp&nbsp&nbsp- ���� �������� �̺�Ʈ <br />
			<br />
			<br />
			<br />
			<a href="event1.jsp"><img src="img/event.jpg" width=140
				height=150></a> <a href="event2.jsp"><img src="img/event1.jpg"
				width=140 height=150></a> <a href="event3.jsp"><img
				src="img/event2.jpg" width=140 height=150></a> </guk>
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