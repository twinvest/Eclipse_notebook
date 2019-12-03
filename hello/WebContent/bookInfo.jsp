<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>도서 소개</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">
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
			Object obj_id = session.getAttribute("id");
			Object obj_name = session.getAttribute("name");
			Object obj_jnum = session.getAttribute("jnum");
			Object obj_cnum = session.getAttribute("cnum");
			Object obj_anum = session.getAttribute("anum");

			String name = (String) obj_name;
			String id = (String) obj_id;

			String IMGPATH = "img/book/";
			String isbn = request.getParameter("isbn");

			ControlDAO dao = new ControlDAO();
			BookEntity book = dao.getBook(isbn);
		%>
		<div id=bookInfo1>
			<div id=bookImg>
				<img src=<%=IMGPATH + book.getImg()%> width=200 height=300>
			</div>
			<div id=bookInformation>
				<table id=bookHeader>
					<tr>
						<td class=header>ISBN</td>
						<td width=300><%=book.getIsbn()%></td>
					</tr>
					<tr>
						<td class=header>제목</td>
						<td width=300><%=book.getTitle()%></td>
					</tr>
					<tr>
						<td class=header>저자</td>
						<td><%=book.getAuthor()%></td>
					</tr>
					<tr>
						<td class=header>출판사</td>
						<td><%=book.getPublisher()%></td>
					</tr>
					<tr>
						<td class=header>가격</td>
						<td><%=book.getPrice()%></td>
					</tr>
					<tr>
						<td class=header>설명</td>
						<td><%=book.getDescription()%></td>
					</tr>
				</table>
				<br>
				<ul>
					<li><a
						href="payment.jsp?isbn=<%=book.getIsbn()%>&quantity=1&id=<%=id%>">바로
							구매</a>
					<li><a
						href="addCart.jsp?isbn=<%=book.getIsbn()%>&quantity=1&user=<%=id%>">장바구니</a>
				</ul>
			</div>
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