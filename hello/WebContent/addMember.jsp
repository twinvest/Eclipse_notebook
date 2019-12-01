<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">

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

<script language=JavaScript>
	function go() {
		window.location.href = "loginForm.jsp";
	}
</script>

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
		<%
			request.setCharacterEncoding("euc-kr");
		%>

		<jsp:useBean id="member" class="shopdb.MemberEntity" scope="page" />
		<jsp:useBean id="memberDAO" class="shopdb.MemberDAO" scope="page" />
		<jsp:setProperty name="member" property="*" />

		<%
			MemberDAO mdao = new MemberDAO();
			boolean success = mdao.insertDB(member);
			if (!success)
				out.println("<script>alert('회원가입에 실패하였습니다. 다시 시도해주세요.'); history.go(-1);</script>");
			else {
				out.println("<script>alert('회원가입이 정상적으로 처리되었습니다.');go();</script>");

			}
		%>

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