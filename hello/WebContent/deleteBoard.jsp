<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� ����</title>
</head>
<body>
	<%
		request.setCharacterEncoding("euc-kr");
		String num = request.getParameter("num");
		String pageNo = request.getParameter("page");
		String passwd = request.getParameter("passwd");
		int inum = Integer.parseInt(num);

		BoardDAO brddb = new BoardDAO();

		if (!brddb.isPasswd(inum, passwd)) {
	%>
	<!-- ��ȣ�� Ʋ���� ���� ȭ������ �̵� -->
	<script>
		alert("��й�ȣ�� �ٸ��ϴ�.");
		history.go(-1);
	</script>
	<%
		} else {
			int retval = brddb.deleteDB(inum);
			if (retval == 1) {
	%>
	<!-- reval=1 �̸� �亯���� �־ ������ �Ұ����� ��� -->
	<script>
		alert("�亯�� �ִ� ���� ������ �� �����ϴ�.");
		history.go(-2);
	</script>
	<%
		} else {
	%>
	<script>
		alert("�����Ǿ����ϴ�.");
	</script>
	<%
		response.sendRedirect("listBoard.jsp?page=" + pageNo);
			}
		}
	%>
</body>
</html>