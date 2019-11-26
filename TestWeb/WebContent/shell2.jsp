<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 

File f = new File("./image/tree.png");
// 파일 존재 여부 판단
if (f.isFile()) {
  System.out.println("OK 파일 있습니다.");
%> <p>파일 exist</p>
<% } else { System.out.println("그런 파일 없습니다.");  %>
<p>파일 no exist</p>
<%} %>
</body>
</html>