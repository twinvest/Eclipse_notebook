<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*, java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>장바구니</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">

<style>
table {
	font: 11px verdana, verdana, arial;
	margin: 0;
	padding: 0;
	border-collapse: collapse;
	text-align: left;
	color: #333;
	line-height: 19px;
}

caption {
	font-size: 14px;
	font-weight: bold;
	margin-bottom: 20px;
	text-align: left;
	text-transform: uppercase;
}

td {
	margin: 0;
	padding: 20px 10px;
	border: 1px dotted #f5f5f5;
}

th {
	font-weight: normal;
	text-transform: uppercase;
}

thead tr th {
	background-color: #575757;
	padding: 20px 10px;
	color: #fff;
	font-weight: bold;
	border-right: 2px solid #333;
	text-transform: uppercase;
	text-align: center;
}

tfoot tr th, tfoot tr td {
	background-color: transparent;
	padding: 20px 10px;
	color: #ccc;
	border-top: 1px solid #ccc;
}

tbody tr th {
	padding: 20px 10px;
	border-bottom: 1px dotted #fafafa;
}

tr {
	background-color: #FBFDF6;
}

tr.odd {
	background-color: #EDF7DC;
}

tr:hover {
	
}

tr:hover td, tr:hover td a, tr:hover th a {
	color: #a10000;
}

td:hover {
	
}

tr:hover th a:hover {
	background-color: #F7FBEF;
	border-bottom: 2px solid #86C200;
}

table a {
	color: #608117;
	background-image: none;
	text-decoration: none;
	border-bottom: 1px dotted #8A8F95;
	padding: 2px;
	padding-right: 12px;
	background: transparent
		url(http://www.alvit.de/vf/csstablegallery/link.gif) no-repeat 100%
		50%;
}

table a:hover {
	color: #BBC4CD;
	background-image: none;
	text-decoration: none;
	border-bottom: 3px solid #333;
	padding: 2px;
	padding-right: 12px;
	color: #A2A2A2;
	background: transparent
		url(http://www.alvit.de/vf/csstablegallery/link.gif) no-repeat 100%
		50%;
}

table a:visited {
	text-decoration: none;
	border-bottom: 1px dotted #333;
	text-decoration: none;
	padding-right: 12px;
	color: #A2A2A2;
	background: transparent
		url(http://www.alvit.de/vf/csstablegallery/visitedLink.gif) no-repeat
		100% 50%;
}

table a:visited:hover {
	background-image: none;
	text-decoration: none;
	border-bottom: 3px solid #333;
	padding: 2px;
	padding-right: 12px;
	color: #A2A2A2;
	background: transparent
		url(http://www.alvit.de/vf/csstablegallery/visitedLink.gif) no-repeat
		100% 50%;
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

function go(){
	window.location.href="index.jsp";}
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
			<%
		Object obj_id = session.getAttribute("id");
		Object obj_name = session.getAttribute("name");
		
		String id = (String)obj_id;
		String name = (String)obj_name;
		
		if(id==null){
			out.println("<script>alert('로그인 후 이용하세요.');history.go(-1); </script>");
		}else{
			String user = request.getParameter("user");
			
			ControlDAO dao = new ControlDAO();	
			
			ArrayList<BookCartEntity> list = dao.getCart(user);
			%>
			<div align=center>
				<h3>나의 장바구니</h3>
				<br /> <br />
				<form method=post action="payment.jsp?id=<%=id%>">
					<input type=hidden name=user value=<%=user %>> <input
						type=hidden name=menu value=fromCart>
					<%
				for(BookCartEntity entity : list){ %>
					<input type=hidden name=isbn value=<%=entity.getIsbn()%>> <input
						type=hidden name=quantity value=<%=entity.getQuantity()%>>
					<% 
				}
%>
					<table border=1>
						<tr>
							<th width=100>책 번호</th>
							<th width=100>제목</th>
							<th width=100>가격</th>
							<th width=300>수량</th>
							<th width=100>금액</th>
						</tr>
						<%
					for(BookCartEntity entity : list){
			%>
						<tr>
							<th align=center><%=entity.getIsbn() %></th>
							<th align=center><%=entity.getTitle() %></th>
							<th align=center><%=entity.getPrice() %></th>
							<th align=center><%=entity.getQuantity() %></th>
							<th align=right><%=entity.getSum() %>원</th>
						</tr>
						<%
					}
%>
					</table>
					<br> <br>
					<div class="dynamiclabel">
						<div class="dynamiclabel" align="center">
							<input type=submit value="구매하기">
							</guk>
						</div>
					</div>
				</form>
				<form method=post action="deleteCart.jsp">
					<div class="dynamiclabel">
						<div class="dynamiclabel" align="center">
							<input type=submit value="장바구니 취소">
						</div>
					</div>
				</form>
			</div>
			<%} %>
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