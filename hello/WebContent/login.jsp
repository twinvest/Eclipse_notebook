<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>

<script language=JavaScript>

function go(){
	window.location.href="index.jsp";}
</script>


<body>
	<% 	
	request.setCharacterEncoding("euc-kr"); 
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	MemberDAO mdao = new MemberDAO();
	boolean success = mdao.isPasswd(id, passwd);
	if(!success){
		out.println("<script>alert('회원이 아니거나 정보가 다릅니다.');history.go(-1);</script>");
	}else{
		MemberEntity member = mdao.getMember(id);
		session.setAttribute("id", member.getId());
		session.setAttribute("name", member.getName());
		session.setAttribute("jnum", member.getJnum());
		session.setAttribute("cnum", member.getCnum());
		session.setAttribute("anum", member.getAnum());
		
		out.println("<script>alert('책 속의 또다른 세상. BookCover에 오신 것을 환영합니다.');go();</script>");
	
%>

	<script>parent.frames.menu.location.reload();</script>
	<%
	}
%>
</body>
</html>
