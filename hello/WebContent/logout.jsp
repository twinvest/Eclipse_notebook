<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그아웃</title>

</head>

<script language=JavaScript>

function go(){
	window.location.href="index.jsp";}
</script>
<body>
	<%
	session.invalidate();
out.println("<script>alert('로그아웃했습니다.');go(); </script>");
%>
	<script>
		parent.frames.menu.location.reload();
		//location.href="main.html";
	</script>
</body>
</html>