
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">



<style>
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
	if(document.memberForm.id.value=="") alert("id를 입력하세요")
	else if(document.memberForm.passwd.value=="") alert("비밀번호를 입력하세요")
	else if(document.memberForm.name.value=="") alert("이름을 입력하세요")
	else if(document.memberForm.jnum.value=="") alert("주민번호를 입력하세요")
	else if(document.memberForm.cnum.value=="") alert("전화번호를 입력하세요")
	
	else document.memberForm.submit()
}

function checkID()
{
	var sid = document.memberForm.id.value
	if(sid == "") alert("입력된 아이디가 없습니다.")
	else window.open("checkID.jsp?id="+sid,"","width=400 height=200")
	}
-->
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

			<% request.setCharacterEncoding("euc-kr"); %>

			<% 
   String type = request.getParameter("type");
   String search = request.getParameter("search");
	
%>



			<%
	String sql;
	Connection con = null;
	PreparedStatement pstmt = null;
	String driverName = "org.gjt.mm.mysql.Driver";
	String dbURL = "jdbc:mysql://localhost:3306/shopdb";
	

	if(type.equals("num"))
	{
		sql = "select * from Board where num =?"; 
	}
	else
	{
		sql = "select * from Board where name=?";
	}
	
	try{
		Class.forName(driverName);
		con = DriverManager.getConnection(dbURL,"root","de52ch1683");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,search);
		ResultSet result = pstmt.executeQuery();
		
		%>
			<center>
				<table cellspacing=3>

					<tr>
						<th width=60 bgcolor=lightgray><font color=blue><b>번호</b></font></th>
						<th width=290 bgcolor=lightgray><font color=blue><b>제목</b></font></th>
						<th width=80 bgcolor=lightgray><font color=blue><b>작성자</b></font></th>
						<th width=210 bgcolor=lightgray><font color=blue><b>작성일</b></font></th>
						<th width=60 bgcolor=lightgray><font color=blue><b>조회수</b></font></th>
					</tr>


					<%
	while(result.next()) {
	
	%>

					<tr>
						<td align=center><%=result.getString("num") %></td>
						<td align=left><a
							href="readBoard.jsp?num=<%=result.getString("num") %>"><%=result.getString("title") %></a></td>
						<td align=center><%=result.getString("name") %></td>
						<td align=center><%=result.getString("regdate") %></td>
						<td align=center><%=result.getString("hit") %></td>
					</tr>
					<%
	}
	result.close();
	}
	
	
	catch(Exception e) {
	out.println("에러가 발생했습니다.");
	out.println(e.toString());
	e.printStackTrace();
	}
	
	
	finally {
	if(pstmt != null) pstmt.close();
	if(con!=null) con.close();
	}
	%>




				</table>



				<form name="memberForm" method="post" action="search.jsp">

					<select name="type">
						<option SELECTED value="num">번호</option>
						<option value="name">작성자</option>

					</select> <input type="text" name="search"> <input type="submit"
						value="검색">
				</form>

				<br>
				<Br>

				<form name=form method=post action=editBoard.jsp>
					<input type=submit value="글쓰기">
				</form>

			</center>



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