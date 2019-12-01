<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="shopdb.*,java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>게시글 읽기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">



<style>
table {
	border-collapse: collapse;
	border: 2px solid #996;
	font: normal 100%/140% verdana, arial, helvetica, sans-serif;
	color: #333;
	background: #fffff0;
}

caption {
	padding: 0 .4em .4em;
	text-align: left;
	font-size: 1em;
	font-weight: bold;
	text-transform: uppercase;
	color: #333;
	background: transparent;
}

td, th {
	border: 1px solid #cc9;
	padding: .3em;
}

thead th, tfoot th {
	border: 1px solid #cc9;
	text-align: left;
	font-size: 1em;
	font-weight: bold;
	color: #444;
	background: #dbd9c0;
}

tbody td a {
	background: transparent;
	color: #72724c;
	text-decoration: none;
	border-bottom: 1px dotted #cc9;
}

tbody td a:hover {
	background: transparent;
	color: #666;
	border-bottom: 1px dotted #72724c;
}

tbody th a {
	background: transparent;
	color: #72724c;
	text-decoration: none;
	font-weight: bold;
	border-bottom: 1px dotted #cc9;
}

tbody th a:hover {
	background: transparent;
	color: #666;
	border-bottom: 1px dotted #72724c;
}

tbody th, tbody td {
	vertical-align: top;
	text-align: left;
}

tfoot td {
	border: 1px solid #996;
}

.odd {
	color: #333;
	background: #f7f5dc;
}

tbody tr:hover {
	color: #333;
	background: #fff;
}

tbody tr:hover th, tbody tr.odd:hover th {
	color: #333;
	background: #ddd59b;
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

<script type="text/javascript">
<!--
function deleteConfirm(num,pageNo) {
	
	ok = confirm("삭제하시겠습니까?");
	if (ok) {
		location.href = "passwordBoard.jsp?num=" + num  + "&page=" + pageNo ;
	} else {
		return;
	}			
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
		<%
			String name = "";
			String regdate = "";
			String hit = "";
			String title = "";
			String content = "";

			String num = request.getParameter("num");
			String pageNo = request.getParameter("page");

			if (num != null) {

				int idnum = Integer.parseInt(num);
				BoardDAO brddb = new BoardDAO();
				BoardEntity brd = brddb.getBoard(idnum);
				name = brd.getName();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				regdate = df.format(brd.getRegdate());
				hit = Integer.toString(brd.getHit());
				title = brd.getTitle();
				content = brd.getContent();

				brddb.updateHit(idnum, brd.getHit() + 1);
			}
			;
		%>

		<div align="center">
			<h2>Q & A</h2>

			<table style="width: 500; cellspacing: 0; cellpadding: 2;">
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<table border=1
										style="width: 550px; cellspacing: 0; cellpadding: 2; border-collapse: collapse;">
										<tr>
											<td width=100 bgcolor=papayawhip align=left>이 름</td>
											<td colspan=3 width=180 align=left><%=name%></td>
										</tr>
										<tr>
											<td width=100 bgcolor=papayawhip align=left>작성일</td>
											<td width=180 align=left><%=regdate%></td>
											<td width=100 bgcolor=papayawhip align=left>조회수</td>
											<td width=180 align=left><%=hit%></td>
										</tr>
										<tr>
											<td width=100 bgcolor=papayawhip align=left>제 목</td>
											<td colspan=3 align=left><%=title%></td>
										</tr>
										<tr height=300>
											<td colspan=4 align=left valign=top><%=content%></td>
										</tr>
									</table>
								</td>
							<tr>
								<td height=20 colspan=4></td>
							</tr>
							<tr>
								<td colspan=4 align=center><input type=button value="답변"
									onClick="location.href='editBoard.jsp?num=<%=num%>&page=<%=pageNo%>&menu=reply'">
									<input type=button value="수정"
									onClick="location.href='editBoard.jsp?num=<%=num%>&page=<%=pageNo%>&menu=update'">
									<input type=button value="삭제"
									onClick="deleteConfirm(<%=num%>, <%=pageNo%>)"> <!-- 목록보기 버튼은 listboard.jsp로 이동 -->
									<input type=button value="목록보기"
									onClick="location.href='listBoard.jsp?page=<%=pageNo%>'">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
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






