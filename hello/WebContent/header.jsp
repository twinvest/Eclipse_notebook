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
				<li><a href="loginForm.jsp">�α���</a>
				<li><a href="memberForm.jsp">ȸ������</a>
				<li><a href="MyInfor.jsp">��������</a>
				<li><a href="myCart.jsp">��ٱ���</a>
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
				<li><a>������ �����Դϴ�.</a></li>
				<li><a href="logout.jsp">�α׾ƿ�</a>
				<li><a href="book.jsp">�űԵ��� ���</a>
				<li><a href="bookdel.jsp">���� ����</a>
				<li><a href="memberview.jsp">ȸ�� ����</a>
				<li><a href="memberde1.jsp">ȸ�� ����</a>
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
				<li><a> <%=name%> �� ȯ���մϴ�.
				</a></li>
				<li><a href="logout.jsp">�α׾ƿ�</a>
				<li><a href="MyInfor.jsp">��������</a>
				<li><a href="myCart.jsp?user=<%=id%>">��ٱ���</a> <!-- name���� id�� ����.  -->
				<li><a href="myInfo.jsp?user=<%=id%>">�ֹ�����</a> <!-- name���� id�� ����.  -->
			</ul>



		</nav>

	</header>

	<%
		}
	%>
</body>
</html>