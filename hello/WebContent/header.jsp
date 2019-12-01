<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj_id = session.getAttribute("id");
		Object obj_name = session.getAttribute("name");
		Object obj_jnum = session.getAttribute("jnum");
		Object obj_cnum = session.getAttribute("cnum");
		Object obj_anum = session.getAttribute("anum");

		String name = (String) obj_name;
		String id = (String) obj_id;

		if (obj_name == null) {
	%>


	<header id="main_header">
		<hgroup id="title">
			<br />
			<br />

		</hgroup>

		<nav id="topMenu">
			<ul>
				<li><a href="loginForm.jsp">로그인</a>
				<li><a href="memberForm.jsp">회원가입</a>
				<li><a href="MyInfor.jsp">나의정보</a>
				<li><a href="myCart.jsp">장바구니</a>
			</ul>



		</nav>

	</header>


	<%
		} else if (obj_id.equals("admin")) {
	%>


	<header id="main_header">
		<hgroup id="title">
			<br />
			<br />

		</hgroup>

		<nav id="topMenu">
			<ul>
				<li><a>관리자 계정입니다.</a></li>
				<li><a href="logout.jsp">로그아웃</a>
				<li><a href="book.jsp">신규도서 등록</a>
				<li><a href="bookdel.jsp">도서 삭제</a>
				<li><a href="memberview.jsp">회원 보기</a>
				<li><a href="memberde1.jsp">회원 강퇴</a>
			</ul>



		</nav>

	</header>

	<%
		} else {
	%>


	<header id="main_header">
		<hgroup id="title">
			<br />
			<br />

		</hgroup>

		<nav id="topMenu">
			<ul>
				<li><a> <%=name%> 님 환영합니다.
				</a></li>
				<li><a href="logout.jsp">로그아웃</a>
				<li><a href="MyInfor.jsp">나의정보</a>
				<li><a href="myCart.jsp?user=<%=id%>">장바구니</a> <!-- name에서 id로 수정.  -->
				<li><a href="myInfo.jsp?user=<%=id%>">주문내역</a> <!-- name에서 id로 수정.  -->
			</ul>



		</nav>

	</header>

	<%
		}
	%>
</body>
</html>