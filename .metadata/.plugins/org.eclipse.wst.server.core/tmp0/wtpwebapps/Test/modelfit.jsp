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
body{ background-color: #8eadbf;}


.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

table {
  border-collapse: collapse;
  width: 30%;
  margin: 10px 520px;
}

th {
  padding: 3spx;
  text-align: middle;
  border-bottom: 1px solid #ddd;
  border-top: 1px solid #ddd;
  width: 45px;
  height: 50px; 
  background: #133a63;
  color: white; 
}
td {
  padding: 3spx;
  text-align: middle;
  border-bottom: 1px solid #ddd;
  border-top: 1px solid #ddd;
  width: 60px;
  height: 50px;
  font-weight: 900;
}

tr:hover {background-color:#dfedf2;}

.button {
  background-color: #345166;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 17px;
  margin: 5px 3px;
  cursor: pointer;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
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
		<br> <b><font size="8" color="#e6eef2">인적자원 평가 모델 돌리기</font></b> <br>
		<br> <b><font size="5" color="#e6eef2">약간의 시간이 소요될 수 있습니다...</font></b> <br>
		<br>
		<br>
		<form method="post" action="shell.jsp">

			<table>
				<tr>
					<th id="title">Model</th>
					<td><%=model%></td>
				</tr>

				<tr>
					<th id="title">Parameter</th>
					<td><%=parameter%></td>
				</tr>

				<tr>
					<th id="title">Ratio</th>
					<td><%=set%></td>
				</tr>

				<tr>
					<th id="title">Visualize</th>
					<td><%=visualization%></td>
				</tr>

				<tr>
					<th id="title">File type</ths>
					<td><%=uploadFile%></td>
				</tr>
				<br>
			</table>
			<br> <button class="button" style="vertical-align:bottom"><span>Model Operate</span></button>
			<br> <button class="button" style="vertical-align:bottom"><span>Cancle</span></button>
			<%--<input type="submit" value="돌리기" /> <input type="button" value="취소"> --%>
		</form>
	</div>
</body>
</html>
