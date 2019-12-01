<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>회원 목록</title>
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
<style>
table {
	font: normal 76%/150% "Lucida Grande", "Lucida Sans Unicode", Verdana,
		Arial, Helvetica, sans-serif;
	border-collapse: separate;
	border-spacing: 0;
	margin: 0 0 1em;
	color: #000;
}

table a {
	color: #523A0B;
	text-decoration: none;
	border-bottom: 1px dotted;
}

table a:visited {
	color: #444;
	font-weight: normal;
}

table a:visited:after {
	content: "\00A0\221A";
}

table a:hover {
	border-bottom-style: solid;
}

thead th, thead td, tfoot th, tfoot td {
	border: 1px solid #523A0B;
	border-width: 1px 0;
	background: #EBE5D9;
}

th {
	font-weight: bold;
	line-height: normal;
	padding: 0.25em 0.5em;
	text-align: left;
}

tbody th, td {
	padding: 0.25em 0.5em;
	text-align: left;
	vertical-align: top;
}

tbody th {
	font-weight: normal;
	white-space: nowrap;
}

tbody th a:link, tbody th a:visited {
	font-weight: bold;
}

tbody td, tbody th {
	border: 1px solid #fff;
	border-width: 1px 0;
}

tbody tr.odd th, tbody tr.odd td {
	border-color: #EBE5D9;
	background: #F7F4EE;
}

tbody tr:hover td, tbody tr:hover th {
	background: #ffffee;
	border-color: #523A0B;
}

caption {
	font-family: Georgia, Times, serif;
	font-weight: normal;
	font-size: 1.4em;
	text-align: left;
	margin: 0;
	padding: 0.5em 0.25em;
}
</style>
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



		<%@ page import="java.sql.*"%>

		<%
			request.setCharacterEncoding("euc-kr");
		%>

		<%
			String sql;
			Connection con = null;
			PreparedStatement pstmt = null;
			String driverName = "org.gjt.mm.mysql.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/shopdb";

			sql = "select * from Member";

			try {
				Class.forName(driverName);
				con = DriverManager.getConnection(dbURL, "root", "de52ch1683");
				pstmt = con.prepareStatement(sql);
				ResultSet result = pstmt.executeQuery();
		%>

		<h2>현재 가입한 회원 목록</h2>

		<br />
		<br />
		<center>
			<table width=70% border=1 cellpadding=1>
				<tr>
					<td align=center><b> 회원 ID</b></td>
					<td align=center><b> 회원 비밀번호</b></td>
					<td align=center><b> 회원 이름</b></td>
					<td align=center><b> 회원 주민등록번호</b></td>
					<td align=center><b> 회원 전화번호</b></td>
					<td align=center><b> 회원 주소</b></td>

				</tr>
				<tr>

				</tr>
				<tr>
				</tr>

				<%
					while (result.next()) {
				%>

				<tr>
					<td align=center><%=result.getString(1)%></td>
					<td align=center><%=result.getString(2)%></td>
					<td align=center><%=result.getString(3)%></td>
					<td align=center><%=result.getString(4)%></td>
					<td align=center><%=result.getString(5)%></td>
					<td align=center><%=result.getString(6)%></td>
				</tr>
				<%
					}
						result.close();
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
			</table>
		</center>


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