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
body {
	width: 100%;
	height: 100%;
	margin: auto;
	text-align: center;
	background-color: #8eadbf;
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
			<a class="navbar-brand" href="main.jsp">GS_entec</a>
		</div>
		<div class="collapse navbar-collapse"
			id="#bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">Main</a></li>
				<li><a href="model.jsp">Learn model</a></li>
				<li><a href="predict.jsp">Predict</a></li>
				<li><a href="EDA.jsp">EDA</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right2">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Disconnect<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logout.jsp">Log out</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>

	<script type='text/javascript'
		src='https://10ay.online.tableau.com/javascripts/api/viz_v1.js'></script>
	<div class='tableauPlaceholder' style='width: 1280px; height: 524px;'>
		<object class='tableauViz' width='100%' height='660px'
			style='display: none;'>
			<param name='host_url'
				value='https%3A%2F%2F10ay.online.tableau.com%2F' />
			<param name='embed_code_version' value='3' />
			<param name='site_root' value='&#47;t&#47;hdk' />
			<param name='name' value='adress_plot&#47;1' />
			<param name='tabs' value='no' />
			<param name='toolbar' value='yes' />
			<param name='filter'
				value='order=contentTypeOrder%3Aasc%2Cname%3Aasc' />
			<param name='showAppBanner' value='false' />
			<param name='filter' value='iframeSizedToWindow=true' />
		</object>
	</div>


	<%
      }
   %>
	<!-- 애니매이션 담당 JQUERY -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- 부트스트랩 JS  -->
	<script src="js/bootstrap.js"></script>
</body>
</html>