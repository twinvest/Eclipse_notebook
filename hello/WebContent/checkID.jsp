<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID �ߺ�üũ</title>
</head>
<script language=JavaScript>
<!--
	function cl() {
		window.close()
	}
	-->
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
		Connection con = null;
		PreparedStatement pstmt = null;
		String driverName = "org.gjt.mm.mysql.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/shopdb";

		String sql = "select * from Member where id=?";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, "root", "de52ch1683");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet result = pstmt.executeQuery();

			if (result.next() || (id == null)) {
	%>
	<br />
	<br />
	<br />
	<br />
	<center>
		���̵� [
		<%=id%>
		]�� ����Ͻ� �� �����ϴ�. <br> �ٸ� ���̵� �Է����ּ���. <br></br>
	</center>
	<%
		} else {
	%>
	<br />
	<br />
	<br />
	<br />
	<center>
		���̵� [
		<%=id%>
		]�� ����Ͻ� �� �ֽ��ϴ�.<br></br>
	</center>
	<%
		}
		}

		catch (Exception e) {
			out.println("������ �߻��߽��ϴ�.");
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
	<form>
		<center>
			<input type=button value="Ȯ��" onClick="cl()">
		</center>
	</form>
</body>
</html>
</body>
</html>