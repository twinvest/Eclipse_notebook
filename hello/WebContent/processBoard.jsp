<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%  request.setCharacterEncoding("euc-kr"); %>

	<!-- �Խ��� ���, ����, �亯�� ����  �ڹٺ��� �̿� ����-->
	<jsp:useBean id="brd" class="shopdb.BoardEntity" scope="page" />
	<jsp:setProperty name="brd" property="name" />
	<jsp:setProperty name="brd" property="title" />
	<jsp:setProperty name="brd" property="content" />
	<jsp:setProperty name="brd" property="passwd" />

	<% 
		BoardDAO brddb = new BoardDAO();
	 	String menu = request.getParameter("menu"); 
	 	String pageNo = request.getParameter("page");
	 	
	 	
	 	
	 	
	 	if ( menu.equals("reply")) {
	 		int ref = Integer.parseInt(request.getParameter("ref"));
	 		int step = Integer.parseInt(request.getParameter("step"));
	 		int depth = Integer.parseInt(request.getParameter("depth"));
	 		int childCount = Integer.parseInt(request.getParameter("childCount"));
	 		brd.setRef(ref);
	 		brd.setStep(step);
	 		brd.setDepth(depth);
	 		brd.setChildCount(childCount);
	 		brddb.insertReply(brd); 
	 		response.sendRedirect("listBoard.jsp?page=" + pageNo);	
	 		
	 	}else if (menu.equals("update") ) { 
			int num = Integer.parseInt(request.getParameter("num"));			
			brd.setNum(num);
			String passwd = request.getParameter("passwd");
			
			if ( !brddb.isPasswd(num, passwd) ) {
	%>
	<!-- ��ȣ�� Ʋ���� ���� ȭ������ �̵� -->
	<script>alert("��й�ȣ�� �ٸ��ϴ�."); history.go(-1);</script>
	<%
			} else {					
					brddb.updateDB(brd);				
					response.sendRedirect("listBoard.jsp?page=" + pageNo);					 		
			}
	 	} else if ( menu.equals("insert") ) {
			
			brddb.insertDB(brd);
			response.sendRedirect("listBoard.jsp?page=" + pageNo);			 		
	 	}
	 		
	%>
</body>
</html>