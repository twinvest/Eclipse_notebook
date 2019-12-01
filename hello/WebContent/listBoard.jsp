<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page
	import="java.util.ArrayList, shopdb.*, java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>고객센터</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">



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

			<h2>Q & A</h2>
			<br /> <br /> <br /> <br />
			<hr>
			<%
				BoardDAO brddb = new BoardDAO();
				int totalRecordNo = brddb.getTotalRecNo();

				int group = 3;
				int pageRecordNo = 5;
				int totalPage = 0;
				int currentPage = 0;
				int startPage = 0;
				int endPage = 0;
				int prePage = 0;
				int nextPage = 0;

				if (totalRecordNo % pageRecordNo == 0)
					totalPage = totalRecordNo / pageRecordNo;
				else {
					totalPage = totalRecordNo / pageRecordNo + 1;
				}

				out.println("총 게시물 : " + totalRecordNo);
				out.println("한 페이지의 게시물 갯수: " + pageRecordNo);
				out.println("페이지 갯수:" + totalPage);

				String paramPage = request.getParameter("page");
				if (paramPage == null || paramPage.equals("") || paramPage.equals("null")) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(paramPage);
				}

				ArrayList<BoardEntity> list = brddb.getBoardList((currentPage - 1) * pageRecordNo, pageRecordNo);
				int row = 0;
			%>
			<br /></br/> <br />
			<table>
				<tr>
					<th width=60 bgcolor=lightgray><font color=blue><b>번호</b></font></th>
					<th width=290 bgcolor=lightgray><font color=blue><b>제목</b></font></th>
					<th width=80 bgcolor=lightgray><font color=blue><b>작성자</b></font></th>
					<th width=210 bgcolor=lightgray><font color=blue><b>작성일</b></font></th>
					<th width=60 bgcolor=lightgray><font color=blue><b>조회수</b></font></th>
				</tr>
				<%
					//게시 등록일을 2010-3-15 10:33:21 형태로 출력하기 위한 클래스 
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					for (BoardEntity brd : list) {
						//홀짝으로 다르게 색상 지정
						String color = "papayawhip";
						if (++row % 2 == 0)
							color = "white";
				%>
				<tr bgcolor=<%=color%>
					onmouseover="this.style.backgroundColor='SkyBlue'"
					onmouseout="this.style.backgroundColor='<%=color%>'">
					<!-- 수정과 삭제를 위한 링크로 id를 전송 -->
					<td align=center><%=brd.getNum()%></td>
					<td align=left>
						<%
							int depth = brd.getDepth();
								while (depth > 0) {
									depth--;
									out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
								}
						%> <a
						href="readBoard.jsp?num=<%=brd.getNum()%>&page=<%=currentPage%>"><%=brd.getTitle()%></a>
					</td>
					<td align=center><%=brd.getName()%></td>
					<!-- 게시 작성일을 2010-3-15 10:33:21 형태로 출력 -->
					<td align=center><%=df.format(brd.getRegdate())%></td>
					<td align=center><%=brd.getHit()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				startPage = ((currentPage - 1) / group) * group + 1;
				endPage = startPage + group - 1;

				if (totalPage < endPage)
					endPage = totalPage;

				if (currentPage > group) {
					prePage = startPage - 1;
			%>

			<a href="listBoard.jsp?page=<%=prePage%>">[이전]</a>

			<%
				}
				for (int i = startPage; i <= endPage; i++) {
					if (i != currentPage) {
			%>
			<a href="listBoard.jsp?page=<%=i%>"><%=i%></a>
			<%
				} else {
			%>
			<%=i%>
			<%
				}
				}

				if (endPage < totalPage) {
					nextPage = endPage + 1;
			%>
			<a href="listBoard.jsp?page=<%=nextPage%>">[이후]</a>
			<%
				}
			%>

			<hr width=80%>

			<p>
				조회된 게시판 목록 수가
				<%=totalRecordNo%>개 입니다. <br> <br>
			<form method="post" action="search.jsp">

				<select name="type">
					<option SELECTED value="num">번호</option>
					<option value="name">작성자</option>

				</select> <input type="text" name="search"> <input type="submit"
					value="검색">
			</form>

			<br> <Br>


			<form name=form method=post action=editBoard.jsp>
				<input type=submit value="글쓰기">
			</form>
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