<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>���� ���</title>
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

			<head>
<meta charset="EUC-KR">
<title>���� ���</title>
<style>
.book {
	width: 150;
	text-align: right;
	background: ivory;
}
</style>
			</head>
			<body>
				<div align=center>
					���� ���
					<hr>

					<%
						ControlDAO dao = new ControlDAO();
						ArrayList<CategoryEntity> categoryList = dao.getBoardList();
					%>

					<form method="post" action="bookRegistration.jsp"
						enctype="multipart/form-data">
						<table>
							<tr>
								<td class=book>ISBN</td>
								<td align=left><input type="text" name="isbn"></td>
							</tr>
							<tr>
								<td class=book>����</td>
								<td align=left><input type="text" name="title" maxlength=50
									size=70></td>
							</tr>
							<tr>
								<td class=book>����</td>
								<td align=left><input type="text" name="author"
									maxlength=30 size=30></td>
							</tr>
							<tr>
								<td class=book>���ǻ�</td>
								<td align=left><input type="text" name="publisher"
									maxlength=40 size=40></td>
							</tr>
							<tr>
								<td class=book>����</td>
								<td align=left><input type="text" name="price"></td>
							</tr>
							<tr>
								<td class=book>ī�װ�</td>
								<td align=left><select name="category">
										<option value="" selected="selected">--����--</option>
										<option value="guk" selected="selected">��������</option>
										<option value="ebook" selected="selected">E-Book</option>
										<option value="ha" selected="selected">�ؿܵ���</option>
										<option value="best" selected="selected">����Ʈ����</option>
										<option value="half" selected="selected">�ݰ�����</option>
								</select> <%
 	for (CategoryEntity entity : categoryList) {
 		String categ = entity.getCateg();
 		out.println("<option value=" + categ + ">" + "</option>");
 	}
 %> </select></td>
							</tr>
							<tr>
								<td class=book>���</td>
								<td align=left><input type="text" name="remaining"></td>
							</tr>

							<tr>
								<td class=book>�̹��� ����</td>
								<td align=left><input type="file" name="img" size=50></td>
							</tr>
							<tr>
								<td class=book>����</td>
								<td align=left><textarea rows=10 cols=50 name="description"></textarea></td>
							</tr>
							<tr>
								<td colspan=2 align=center><input type="submit" value="���">
									<input type="reset" value="�ʱ�ȭ"></td>

							</tr>
						</table>
					</form>
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