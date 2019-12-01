<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 삭제</title>
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
	<!-- 암호가 틀리면 이전 화면으로 이동 -->
	<script>
		alert("비밀번호가 다릅니다.");
		history.go(-1);
	</script>
	<%
		} else {
			int retval = brddb.deleteDB(inum);
			if (retval == 1) {
	%>
	<!-- reval=1 이면 답변글이 있어서 삭제가 불가능한 경우 -->
	<script>
		alert("답변이 있는 글은 삭제할 수 없습니다.");
		history.go(-2);
	</script>
	<%
		} else {
	%>
	<script>
		alert("삭제되었습니다.");
	</script>
	<%
		response.sendRedirect("listBoard.jsp?page=" + pageNo);
			}
		}
	%>
</body>
</html>