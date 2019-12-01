<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

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

/*
--------------------------------------------------------------------------------
What:	"Oranges in the sky" Styles(Table data design)
Who:	Krasimir Makaveev(krasi [at] makaveev [dot] com)
When:	15.09.2005(created)
--------------------------------------------------------------------------------
*/
table {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	color: #333;
}

table caption {
	font-size: 1.1em;
	font-weight: bold;
	letter-spacing: -1px;
	margin-bottom: 10px;
	padding: 5px;
	background: #efefef;
	border: 1px solid #ccc;
	color: #666;
}

table a {
	text-decoration: none;
	border-bottom: 1px dotted #f60;
	color: #f60;
	font-weight: bold;
}

table a:hover {
	text-decoration: none;
	color: #fff;
	background: #f60;
}

table tr th a {
	color: #369;
	border-bottom: 1px dotted #369;
}

table tr th a:hover {
	color: #fff;
	background: #369;
}

table thead tr th {
	text-transform: uppercase;
	background: #e2e2e2;
}

table tfoot tr th, table tfoot tr td {
	text-transform: uppercase;
	color: #000;
	font-weight: bold;
}

table tfoot tr th {
	width: 20%;
}

table tfoot tr td {
	width: 80%;
}

table td, table th {
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px;
	line-height: 1.8em;
	font-size: 0.8em;
	vertical-align: top;
	width: 20%;
}

table tr.odd th, table tr.odd td {
	background: #efefef;
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

			<%
	Object obj_id = session.getAttribute("id");
Object obj_name = session.getAttribute("name");
Object obj_jnum = session.getAttribute("jnum");
Object obj_cnum = session.getAttribute("cnum");
Object obj_anum = session.getAttribute("anum");

String id = (String)obj_id;
String name1 = (String)obj_name;
String anum = (String)obj_anum;


if(id!=null){

   String user = request.getParameter("id");
	String menu = request.getParameter("menu");
	String isbn[] = request.getParameterValues("isbn");
   String quantity[] = request.getParameterValues("quantity");


   ControlDAO dao = new ControlDAO();         
   MemberEntity member = dao.getMember(user);

%>
			<div align=center>
				<h3>구매 책 정보</h3>
				<table border=1>
					<tr>
						<th>제목</th>
						<th>수량</th>
						<th>가격</th>
					</tr>
					<%
   for(int i=0; i<isbn.length; i++ ){
      BookEntity book = dao.getBook(isbn[i]);
      int sum = book.getPrice()*Integer.parseInt(quantity[i]);
%>
					<tr>
						<td width=300><%=book.getTitle() %></td>
						<td width=100 align=center><%=quantity[i] %></td>
						<td width=100 align=center><%=sum %></td>
					</tr>
					<%
   }
%>
				</table>
				<br>
				<br>
				<h3>구매자 정보</h3>
				<table border=1>
					<tr>
						<th>고객명</th>
						<th>주소</th>
					</tr>
					<tr>
						<td width=100 align=center><%=name1 %></td>
						<td width=400 align=center><%=anum %></td>
					</tr>

				</table>
				<br>
				<br>

				<form method="post" action="buy.jsp?id=<%=id%>">
					<input type=hidden name=user value=<%=member.getId() %>> <input
						type=hidden name=menu value=<%=menu %>>
					<%
   for(int i=0; i<isbn.length; i++ ){
%>
					<input type=hidden name=isbn value=<%=isbn[i] %>> <input
						type=hidden name=quantity value=<%=quantity[i] %>>
					<%
   }
%>
					<input type="submit" value="결제하기">
				</form>
			</div>

		</div>


		<%} else out.println("<script>alert('로그인 후 이용해주세요.');history.go(-1); </script>");
 %>


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