<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page
	import="java.util.ArrayList, shopdb.*, java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>�ؿ� ����</title>
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
		if (document.memberForm.id.value == "")
			alert("id�� �Է��ϼ���")
		else if (document.memberForm.passwd.value == "")
			alert("��й�ȣ�� �Է��ϼ���")
		else if (document.memberForm.name.value == "")
			alert("�̸��� �Է��ϼ���")
		else if (document.memberForm.jnum.value == "")
			alert("�ֹι�ȣ�� �Է��ϼ���")
		else if (document.memberForm.cnum.value == "")
			alert("��ȭ��ȣ�� �Է��ϼ���")

		else
			document.memberForm.submit()
	}

	function checkID() {
		var sid = document.memberForm.id.value
		if (sid == "")
			alert("�Էµ� ���̵� �����ϴ�.")
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
<li><a class ="bar1" href="#">���ͳ� ����</a></li>
<li><a class ="bar1" href="#">��ȭ</a></li>
<li><a class ="bar1" href="#">�ڰ���</a></li>
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
				ControlDAO dao = new ControlDAO();
				String CATEGORY = "ha";
				int totalRecordNo = dao.getTotalRecNo(CATEGORY);

				int group = 2; // ���������� ǥ���� ������ ��
				int pageRecordNo = 6; // ���������� ������ ���ڵ� ����

				int totalPage = 0; // ��ü ������ ��   
				int currentPage = 0; // ���� ������ ��ȣ         
				int startPage = 0; // ���������� ǥ���� ���� ������ ��ȣ
				int endPage = 0; // ���������� ǥ���� �ְ� ������ ��ȣ
				int prePage = 0; // ���� �׷��� ù���� ������
				int nextPage = 0; // ���� �׷��� ù��° ������ 

				if (totalRecordNo % pageRecordNo == 0)
					totalPage = totalRecordNo / pageRecordNo;
				else {
					totalPage = totalRecordNo / pageRecordNo + 1;
				}

				String paramPage = request.getParameter("page");
				if (paramPage != null) {
					currentPage = Integer.parseInt(paramPage);
				} else {
					currentPage = 1;
				}

				ArrayList<BookEntity> list = dao.getBookList(CATEGORY, (currentPage - 1) * pageRecordNo, pageRecordNo);
			%>
			<br>
			<h3>
				�ؿ� ���� :
				<%=totalRecordNo%>��
			</h3>
			<br> <br> <br /> <br /> <br />
			<table>
				<%
					int columnNo = 3;
					String IMGPATH = "img/book/";

					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<%
						int j = 0;
							for (j = 0; j < columnNo; j++) {

								if (i + j >= list.size())
									break;
								BookEntity book = list.get(i + j);
					%>
					<td class=big align=center width=160 height=350 valign=top><a
						href="bookInfo.jsp?isbn=<%=book.getIsbn()%>"> <img
							src=<%=IMGPATH + book.getImg()%> height=220></a>
						<ul>
							<li><a href="bookInfo.jsp?isbn=<%=book.getIsbn()%>"> <%=book.getTitle()%></a></li>
							<li><%=book.getAuthor()%>
							<li><%=book.getPublisher()%>
							<li><%=book.getPrice() + "��"%>
						</ul></td>
					<%
						}
							i = i + j - 1;
					%>
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
			%><center>
				<a href="guk.jsp?page=<%=prePage%>">[����]</a>
				<%
					}

					for (int i = startPage; i <= endPage; i++) {
						if (i != currentPage) {
				%>
				<a href="guk.jsp?page=<%=i%>"><%=i%></a>
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
				<a href="guk.jsp?page=<%=nextPage%>">[����]</a>
				<%
					}
				%>
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