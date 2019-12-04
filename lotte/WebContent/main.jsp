<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Welcome Lotte</title>
<style>
body {
	background-image: url(image/b.jpg);
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<!-- 네비게이션  -->
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expaned="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"><img src="image/logo.png"
				width="60px" height="25px" /></a>
		</div>


		<!-- 로그인 여부에 따라 보여지는게 다르다 -->
		<% 
 		String id = (String)session.getAttribute("userID");            // request에서 id 파라미터를 가져온다
		if(id==null || id.equals("")) {                            // id가 Null 이거나 없을 경우
			response.sendRedirect("login.jsp");    // 로그인 페이지로 리다이렉트 한다.
 	%>

		<div class="collapse navbar-collapse"
			id="#bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="board/bbs.jsp">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right1">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Connect<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">Login</a></li>
						<li><a href="join.jsp">sign up</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<%
 		}else if(session.getAttribute("userID").equals("tw")){
 	%>
	<div class="collapse navbar-collapse"
		id="#bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="board/bbs.jsp">게시판</a></li>
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
		<% 
 		}
 	%>
	</div>
	</nav>
	<div class = "container">
	<div class = "row">
	<table class = "table ">
	
</body>
<!-- 애니매이션 담당 JQUERY -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 부트스트랩 JS  -->
<script src="js/bootstrap.js"></script>
</html>