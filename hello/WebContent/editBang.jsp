<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>답글 수정</title>
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
<script type="text/javascript">
<!--
	function check() {
		if (document.bangForm.name.value == "") {
			alert("이름을 입력해 주세요.");
			document.bangForm.name.focus();
			return;
		}
		if (document.bangForm.passwd.value == "") {
			alert("암호를 입력해 주세요.");
			document.bangForm.passwd.focus();
			return;
		}
		if (document.bangForm.title.value == "") {
			alert("제목을 입력해 주세요.");
			document.bangForm.title.focus();
			return;
		}
		document.bangForm.submit();
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
			<%
				Object obj_id = session.getAttribute("id");
				Object obj_name = session.getAttribute("name");
				String a = "admin";

				if (!obj_id.equals(a)) //if(obj_id == null) 
				{
					out.println("<script>alert('관리자 권한이 없습니다.');history.go(-1);</script>");
				} else {

					String name = "";
					String title = "";
					String content = "";

					//답변글
					int ref = 0;
					int step = 0;
					int depth = 0;
					int childCount = 0;

					String headline = "";

					String num = request.getParameter("num");
					String menu = request.getParameter("menu");
					String pageNo = request.getParameter("page");

					if (num != null) {
						int idnum = Integer.parseInt(num);

						BangDAO brddb = new BangDAO();
						BangEntity brd = brddb.getBang(idnum);

						if (menu.equals("update")) {
							name = brd.getName();
							title = brd.getTitle();
							content = brd.getContent();
						} else if (menu.equals("reply")) {
							title = "[RE] " + brd.getTitle();
							content = "\n\n::::::::::::::원문글::::::::::::\n" + brd.getContent();
							ref = brd.getRef();
							step = brd.getStep();
							depth = brd.getDepth();
							childCount = brd.getChildCount();
						}

						headline = menu;
					} else {
						menu = "insert";
						headline = "insert";
					}
			%>

			<div align=center>

				<h2>
					게시판
					<%=headline%>
				</h2>
				<hr>

				<form name=bangForm method=post action="processBang.jsp">
					<!--  num과 menu hidden으로 전송 -->
					<input type=hidden name="num" value=<%=num%>> <input
						type=hidden name="menu" value=<%=menu%>>
					<!-- 답변글을 위한 field를 hidden으로 전송 -->
					<input type=hidden name="page" value=<%=pageNo%>> <input
						type=hidden name="ref" value=<%=ref%>> <input type=hidden
						name="step" value=<%=step%>> <input type=hidden
						name="depth" value=<%=depth%>> <input type=hidden
						name="childCount" value=<%=childCount%>>
					<table
						style="width: 700; border: 0; cellspacing: 0; cellpadding: 7">
						<tr>
							<td align=center>
								<table>
									<tr>
										<td colspan=2>
											<table style="width: 650">
												<tr>
													<td align=left>이 름:</td>
													<td align=left><input type=text name=name value="관리자"
														size=30 maxlength=20></td>
												</tr>
												<tr>
													<td align=left>제 목:</td>
													<td align=left><input type=text name=title size=90%
														value="<%=title%>" maxlength=100></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td colspan=2 align=left><textarea name=content rows=10
												cols=95><%=content%></textarea></td>
									</tr>
									<tr>
										<td colspan=2 align=left>비밀번호 : <input type=password
											name=passwd size=20 maxlength=20><font color=red>
												게시 내용을 수정 또는 삭제하려면 비밀번호가 필요합니다.</font></td>
									</tr>
									<tr>
										<td colspan=2 height=5><hr size=2></td>
									</tr>
									<tr>
										<td colspan=2 align=center>
											<%
												if (num == null) {
											%> <input type=button value="등록" onClick="check()"> <%
 	} else if (menu.equals("reply")) {
 %> <input type=button value="답변완료" onClick="check()"> <%
 	} else if (menu.equals("update")) {
 %> <input type=button value="수정완료" onClick="check()"> <%
 	}
 %> <input type=button value="목록보기"
											onClick="location.href='listBang.jsp?page=<%=pageNo%>'">
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
				<%
					}
				%>
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