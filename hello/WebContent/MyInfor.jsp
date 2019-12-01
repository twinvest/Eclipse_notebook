<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>나의 정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">



<style>
/*
Coffee with milk
Table design by Roger Johansson, 456 Berea Street
www.456bereastreet.com
================================================*/
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

form div.dynamiclabel {
	/* div container for each form field with pop up label */
	display: block;
	margin: 30px;
	font: 16px;
	position: relative;
}

form div.dynamiclabel1 {
	/* div container for each form field with pop up label */
	display: block;
	margin: 30px;
	font: 16px;
	position: relative;
}

form div.dynamiclabel input[type="text"], form div.dynamiclabel textarea
	{
	width: 220px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel1 input[type="text"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="password"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="button"], form div.dynamiclabel textarea
	{
	width: 100px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="submit"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="reset"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel textarea {
	height: 200px;
}

form div.dynamiclabel label { /* pop up label style */
	position: absolute;
	left: 0;
	background: lightyellow;
	border: 1px solid yellow;
	border-radius: 2px;
	padding: 3px 10px;
	box-shadow: 4px 1px 5px gray;
	font-weight: bold;
	-webkit-backface-visibility: hidden;
	top: 10px;
	/* initial top position of label relative to dynamiclabel container */
	-moz-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	-webkit-transition: all 0.4s ease-in-out;
	/* Safari doesn't seem to support cubic-bezier values beyond 0 to 1, so use keyword value instead */
	-o-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	opacity: 0;
	z-index: -1;
}

form div.dynamiclabel>*:focus {
	/* when user focuses on child element inside div.dynamiclabel */
	border: 1px solid #45bcd2;
	box-shadow: 0 0 8px 2px #98d865;
}

form div.dynamiclabel>*:focus+label {
	/* label style when user focuses on child element inside div.dynamiclabel */
	opacity: 1;
	z-index: 100;
	top: -35px;
	/* Post top position of label on focus relative to dynamiclabel container */
	-ms-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-webkit-transform: rotate(-3deg);
	transform: rotate(-3deg);
}

form div.dynamiclabel1 textarea {
	height: 200px;
}

form div.dynamiclabel1 label { /* pop up label style */
	position: absolute;
	left: 0;
	background: lightyellow;
	border: 1px solid yellow;
	border-radius: 2px;
	padding: 3px 10px;
	box-shadow: 4px 1px 5px gray;
	font-weight: bold;
	-webkit-backface-visibility: hidden;
	top: 10px;
	/* initial top position of label relative to dynamiclabel container */
	-moz-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	-webkit-transition: all 0.4s ease-in-out;
	/* Safari doesn't seem to support cubic-bezier values beyond 0 to 1, so use keyword value instead */
	-o-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	opacity: 0;
	z-index: -1;
}

form div.dynamiclabel1>*:focus {
	/* when user focuses on child element inside div.dynamiclabel */
	border: 1px solid #45bcd2;
	box-shadow: 0 0 8px 2px #98d865;
}

form div.dynamiclabel1>*:focus+label {
	/* label style when user focuses on child element inside div.dynamiclabel */
	opacity: 1;
	z-index: 100;
	top: -35px;
	/* Post top position of label on focus relative to dynamiclabel container */
	-ms-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-webkit-transform: rotate(-3deg);
	transform: rotate(-3deg);
}
}
</style>



</head>


<script language=JavaScript>
<!--
	function checking() {
		if (document.memberForm.id.value == "")
			alert("id를 입력하세요")
		else if (document.memberForm.passwd.value == "")
			alert("비밀번호를 입력하세요")
		else if (document.memberForm.name.value == "")
			alert("이름을 입력하세요")
		else if (document.memberForm.jnum.value == "")
			alert("주민번호를 입력하세요")
		else if (document.memberForm.cnum.value == "")
			alert("전화번호를 입력하세요")

		else
			document.memberForm.submit()
	}

	function checkID() {
		var sid = document.memberForm.id.value
		if (sid == "")
			alert("입력된 아이디가 없습니다.")
		else
			window.open("checkID.jsp?id=" + sid, "", "width=400 height=200")
	}
	-->

	function go() {
		window.location.href = "index.jsp";
	}
</script>


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


		<div id="jb-content">


			<%@ page import="java.sql.*"%>


			<%
				Object obj_id = session.getAttribute("id");
				Object obj_name = session.getAttribute("name");
				Object obj_jnum = session.getAttribute("jnum");
				Object obj_cnum = session.getAttribute("cnum");
				Object obj_anum = session.getAttribute("anum");

				String id = (String) obj_id;

				if (id != null) {
			%>
			<%=id%>님의 회원 정보입니다.<br />
			<br />
			<br />

			<%
				String sql;
					Connection con = null;
					PreparedStatement pstmt = null;
					String driverName = "org.gjt.mm.mysql.Driver";
					String dbURL = "jdbc:mysql://localhost:3306/shopdb";

					sql = "select id,name,jnum,anum,cnum from Member where id=?";

					try {
						Class.forName(driverName);
						con = DriverManager.getConnection(dbURL, "root", "de52ch1683");
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, id);
						ResultSet result = pstmt.executeQuery();
			%>


			<table width=100% border=2>
				<tr>
					<td align=center><b> 회원 ID</b></td>
					<td align=center><b> 회원 이름</b></td>
					<td align=center><b> 회원 주민등록번호</b></td>
					<td align=center><b> 회원 주소</b></td>
					<td align=center><b> 회원 전화번호</b></td>
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


			<%
				} else

					out.println("<script>alert('로그인 후 이용해주세요.');history.go(-1); </script>");
			%>


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