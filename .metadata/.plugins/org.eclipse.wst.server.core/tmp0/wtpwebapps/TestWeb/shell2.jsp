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
// ���� ���� ���� �Ǵ�
if (f.isFile()) {
  System.out.println("OK ���� �ֽ��ϴ�.");
%> <p>���� exist</p>
<% } else { System.out.println("�׷� ���� �����ϴ�.");  %>
<p>���� no exist</p>
<%} %>
</body>
</html>