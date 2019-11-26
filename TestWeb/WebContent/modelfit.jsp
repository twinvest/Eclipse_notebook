<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<title>모델돌리는 곳</title>
<style>
#wrap {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
	border: 3px solid skyblue
}

td {
	border: 1px solid skyblue
}

#title {
	background-color: skyblue
}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String model = request.getParameter("model");
		String parameter = request.getParameter("parameter");
		String set = request.getParameter("set");
		String visualization = request.getParameter("visualization");
		String uploadFile = request.getParameter("uploadFile");
		
		//String radio1 = request.getParameter("radio1");
		//out.println(model + "<p>");
		//out.println(parameter + "<p>");
		//out.println(set + "<p>");
		//out.println(visualization + "<p>");
		//out.println(file + "<p>");
	%>
	<div id="wrap">
		<br>
		<br> <b><font size="6" color="gray">태우쓰 모델 돌리기</font></b> <br>
		<br> <b><font size="3" color="gray">약간의 시간이 소요될 수 있습니다...</font></b> <br>
		<br>
		<br>
		<form method="post" action="shell.jsp">

			<table>
				<tr>
					<td id="title">모델</td>
					<td><%=model%></td>
				</tr>

				<tr>
					<td id="title">파라미터</td>
					<td><%=parameter%></td>
				</tr>

				<tr>
					<td id="title">비율</td>
					<td><%=set%></td>
				</tr>

				<tr>
					<td id="title">시각화</td>
					<td><%=visualization%></td>
				</tr>

				<tr>
					<td id="title">파일종류</td>
					<td><%=uploadFile%></td>
				</tr>
				<br>
			</table>
			<input type="submit" value="돌리기" /> <input type="button" value="취소">
		</form>
	</div>
</body>
</html>
