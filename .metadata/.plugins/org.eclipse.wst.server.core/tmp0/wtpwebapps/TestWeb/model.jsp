<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
body 
label .upload-file {
	vertical-align: middle;
	font-size: 17px;
	color: #000000;
}

label.upload-file p {
	width: 260px;
	height: 40px;
	float: left;
	border: 1px solid #555;
	border-radius: 5px;
	background: #f7f7f7;
	text-indent: 10px;
	font-size: 17px;
	padding: 10px 0;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

label.upload-file .btn {
	width: 100px;
	height: 40px;
	float: left;
	background-color: #555555;
	border-radius: 5px;
	content: " ";
	position: relative;
	color: #fff;
	position: relative;
	font-size: 17px;
	margin-left: 10px;
}

label.upload-file input[type="file"] {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
	cursor: pointer;
}

body {
	width: 100%;
	height: 100%;
	margin: auto;
	text-align: center;
}

#uploadFile {
	text-align: center;
	margin: auto;
}
</style>
<title>태우형님의 웹사이트</title>
</head>
<body>
	<%
		if (session.getAttribute("userID").equals("tw")) {
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expaned="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">AI의 왕 김태우</a>
		</div>
		<div class="collapse navbar-collapse"
			id="#bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="model.jsp">모델돌리기</a></li>
				<li><a href="predict.jsp">예측하기</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right2">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속끊기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logout.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<form action="modelfit.jsp" method="post">
		<div class="bs-example" data-example-id="split-button-dropdown"
			align="center">
			<!-- Split button1 -->
			<div class="btn-group">
				<!-- Button1 -->
				<button type="button" style="color: gold; background: black"
					class="btn btn-danger">Model Selection</button>
				<select name="model" style="width: 100px; height: 34px;">
					<option value="Logit">
						<li><a href="#" value="Logit">Logit</a></li>
					</option>
					<option value="Decision Tree">
						<li><a href="#" value="Decision Tree">Decision Tree</a></li>
					</option>
					<option value="Random Forest">
						<li><a href="#" value="Random Forest">Random Forest</a></li>
					</option>
					<option value="XGBoost">
						<li><a href="#" value="XGBoost">XGBoost</a></li>
					</option>
					<li class="divider"></li>
					<option value="CNN">
						<li><a href="#" value="CNN">CNN</a></li>
					</option>
					<option value="RNN">
						<li><a href="#" value="RNN">RNN</a></li>
					</option>
				</select>
			</div>

			<!-- Split button2 -->
			<div class="btn-group">
				<!-- Button2 -->
				<button type="button" style="color: gold; background: black"
					class="btn btn-danger2">Parameter</button>

				<select name="parameter" style="width: 100px; height: 34px;">
					<li><a href="#" value="Parameter1"><option
								value="Parameter1">Parameter1</a></li>
					<li><a href="#" value="Parameter2"><option
								value="Parameter2">Parameter2</a></li>
					<li><a href="#" value="Parameter3"><option
								value="Parameter3">Parameter3</a></li>
					<li class="divider"></li>
					<li><a href="#" value="Super Parameter"><option
								value="Super Parameter">Super Parameter</a></li>
				</select>
			</div>

			<!-- Split button3 -->
			<div class="btn-group">
				<!-- Button2 -->
				<button type="button" style="color: gold; background: black"
					class="btn btn-danger3">TestSet/TrainSet</button>

				<select name="set" style="width: 100px; height: 34px;">
					<li><a href="#" value="Test : 0.1 / Train : 0.9"><option
								value="Test:0.1 / Train:0.9">Test : 0.1 / Train : 0.9</option></a></li>
					<li><a href="#" value="Test : 0.2 / Train : 0.8"><option
								value="Test:0.2 / Train:0.8">Test : 0.2 / Train : 0.8</option></a></li>
					<li><a href="#" value="Test : 0.3 / Train : 0.7"><option
								value="Test:0.3 / Train:0.7">Test : 0.3 / Train : 0.7</option></a></li>
					<li class="divider"></li>
					<li><a href="#" value="Test : 0.4 / Train : 0.6"><option
								value="Test:0.4 / Train:0.6">Test : 0.4 / Train : 0.6</option></a></li>
				</select>
				</ul>
			</div>

			<!-- Split button4 -->
			<div class="btn-group">
				<!-- Button2 -->
				<button type="button" style="color: gold; background: black"
					class="btn btn-danger4">Visualization</button>
				<select name="visualization" style="width: 100px; height: 34px;">
					<li><a href="#" value="Heatmap"><option value="Heatmap">Heatmap</option></a></li>
					<li><a href="#" value="Graph"><option value="Graph">Graph</option></a></li>
					<li><a href="#" value="Feature Importance"><option
								value="Feature Importance">Feature Importance</option></a></li>
					<li class="divider"></li>
					<li><a href="#" value="EDA"><option value="EDA">EDA</option></a></li>
				</select>
			</div>
		</div>
		<br>
		<!-- Split button5 -->
		<div class="out">
			<ul>
				<label for="uploadFile" class="upload-file">
					<button type="button" class="btn" style="color: gold; background: black">
						파일찾기<input id="uploadFile" name="uploadFile" type="file"
							accept="image/*">
					</button>
					<p>Click Me!</p> <!-- 업로드파일명 -->
				</label>
			</ul>
		</div>

		<br> <span style="float: right"><input type="submit"
			style="height: 50px; width: 100px;" value="learn model!"> </span>
	</form>

	<%
		}
	%>
</body>
</html>