<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� ����</title>

<!-- ���� boardForm.js : ���� �� �Է� ���� �ִ����� �����ϴ� �Լ� ���� -->
<script type="text/javascript">
<!--
	function check() {
		if (document.boardForm.name.value == "") {
			alert("�̸��� �Է��� �ּ���.");
			document.boardForm.name.focus();
			return;
		}
		if (document.boardForm.passwd.value == "") {
			alert("��ȣ�� �Է��� �ּ���.");
			document.boardForm.passwd.focus();
			return;
		}
		if (document.boardForm.title.value == "") {
			alert("������ �Է��� �ּ���.");
			document.boardForm.title.focus();
			return;
		}
		document.boardForm.submit();
	}

	-->
</script>
</head>
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


		<%
			String name = "";
			String title = "";
			String content = "";

			//�亯��
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

				BoardDAO brddb = new BoardDAO();
				BoardEntity brd = brddb.getBoard(idnum);

				if (menu.equals("update")) {
					name = brd.getName();
					title = brd.getTitle();
					content = brd.getContent();
				} else if (menu.equals("reply")) {
					title = "[RE] " + brd.getTitle();
					content = "\n\n::::::::::::::������::::::::::::\n" + brd.getContent();
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
				�Խ���
				<%=headline%>
			</h2>
			<hr>

			<form name=boardForm method=post action="processBoard.jsp">
				<!--  num�� menu hidden���� ���� -->
				<input type=hidden name="num" value=<%=num%>> <input
					type=hidden name="menu" value=<%=menu%>>
				<!-- �亯���� ���� field�� hidden���� ���� -->
				<input type=hidden name="page" value=<%=pageNo%>> <input
					type=hidden name="ref" value=<%=ref%>> <input type=hidden
					name="step" value=<%=step%>> <input type=hidden
					name="depth" value=<%=depth%>> <input type=hidden
					name="childCount" value=<%=childCount%>>

				<table style="width: 700; border: 0; cellspacing: 0; cellpadding: 7">
					<tr>
						<td align=center>
							<table>
								<tr>
									<td colspan=2>
										<table style="width: 650">
											<tr>
												<td align=left>�� ��:</td>
												<td align=left><input type=text name=name
													value="<%=name%>" size=30 maxlength=20></td>
											</tr>
											<tr>
												<td align=left>�� ��:</td>
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
									<td colspan=2 align=left>��й�ȣ : <input type=password
										name=passwd size=20 maxlength=20><font color=red>
											�Խ� ������ ���� �Ǵ� �����Ϸ��� ��й�ȣ�� �ʿ��մϴ�.</font></td>
								</tr>
								<tr>
									<td colspan=2 height=5><hr size=2></td>
								</tr>
								<tr>
									<td colspan=2 align=center>
										<%
											if (num == null) {
										%> <input type=button value="���"
										onClick="check()"> <%
 	} else if (menu.equals("reply")) {
 %>
										<input type=button value="�亯�Ϸ�" onClick="check()"> <%
 	} else if (menu.equals("update")) {
 %>
										<input type=button value="�����Ϸ�" onClick="check()"> <%
 	}
 %>

										<input type=button value="��Ϻ���"
										onClick="location.href='listBoard.jsp?page=<%=pageNo%>'">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
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