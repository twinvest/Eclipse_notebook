<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 탈퇴</title>
</head>

<script language=JavaScript>
	function go() {
		window.location.href = "memberde1.jsp";
	}
</script>



<body>



	<%@ page import="java.sql.*"%>

	<%
		request.setCharacterEncoding("euc-kr");
	%>


	<%
		String id = request.getParameter("id");
	%>


	<%
		String sql;
		Connection con = null;
		PreparedStatement pstmt = null;
		String driverName = "org.gjt.mm.mysql.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/shopdb";

		sql = "delete from Member where id=?";

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, "root", "de52ch1683");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int row = pstmt.executeUpdate();
	%>

	<%
		out.println("<script>alert('회원 탈퇴가 정상적으로 처리되었습니다.');go(); </script>");
	%>

	<input type=button value="처음으로" target="main"
		onClick="location.href='index.jsp'">



	<%
		}

		catch (Exception e) {
			out.println("에러가 발생했습니다.");
			out.println(e.toString());
			e.printStackTrace();
		}

		finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	%>


</body>
</html>