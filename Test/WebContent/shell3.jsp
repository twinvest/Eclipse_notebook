<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	background-color: #8eadbf;
}

#uploadFile {
	text-align: center;
	margin: auto;
}

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

.container img {
	width: 100%;
	height: auto;
}

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

@import url(https://fonts.googleapis.com/css?family=Varela+Round);

html, body {
	background: #333 url("https://codepen.io/images/classy_fabric.png");
}

.slides {
	padding: 0;
	width: 609px;
	height: 420px;
	display: block;
	margin: 0 auto;
	position: relative;
}

.slides * {
	user-select: none;
	-ms-user-select: none;
	-moz-user-select: none;
	-khtml-user-select: none;
	-webkit-user-select: none;
	-webkit-touch-callout: none;
}

.slides input {
	display: none;
}

.slide-container {
	display: block;
}

.slide {
	top: 0;
	opacity: 0;
	width: 609px;
	height: 420px;
	display: block;
	position: absolute;
	transform: scale(0);
	transition: all .7s ease-in-out;
}

.slide img {
	width: 100%;
	height: 100%;
}

.nav label {
	width: 200px;
	height: 100%;
	display: none;
	position: absolute;
	opacity: 0;
	z-index: 9;
	cursor: pointer;
	transition: opacity .2s;
	color: #FFF;
	font-size: 156pt;
	text-align: center;
	line-height: 380px;
	font-family: "Varela Round", sans-serif;
	background-color: rgba(255, 255, 255, .3);
	text-shadow: 0px 0px 15px rgb(119, 119, 119);
}

.slide:hover+.nav label {
	opacity: 0.5;
}

.nav label:hover {
	opacity: 1;
}

.nav .next {
	right: 0;
}

input:checked+.slide-container  .slide {
	opacity: 1;
	transform: scale(1);
	transition: opacity 1s ease-in-out;
}

input:checked+.slide-container .nav label {
	display: block;
}

.nav-dots {
	width: 100%;
	bottom: 9px;
	height: 11px;
	display: block;
	position: absolute;
	text-align: center;
}

.nav-dots .nav-dot {
	top: -5px;
	width: 11px;
	height: 11px;
	margin: 0 4px;
	position: relative;
	border-radius: 100%;
	display: inline-block;
	background-color: rgba(0, 0, 0, 0.6);
}

.nav-dots .nav-dot:hover {
	cursor: pointer;
	background-color: rgba(0, 0, 0, 0.8);
}

input#img-1:checked ~ .nav-dots label#img-dot-1, input#img-2:checked ~
	.nav-dots label#img-dot-2, input#img-3:checked ~ .nav-dots label#img-dot-3,
	input#img-4:checked ~ .nav-dots label#img-dot-4, input#img-5:checked ~
	.nav-dots label#img-dot-5, input#img-6:checked ~ .nav-dots label#img-dot-6
	{
	background: rgba(0, 0, 0, 0.8);
}

/*GLOBALS*/
*{margin:0; padding:0; list-style:none;}
a{text-decoration:none; color:#666;}
a:hover{color:#1bc1a3;}
body, hmtl{background: #ecf0f1; font-family: 'Anton', sans-serif;}


#wrapper{
    width:600px;
    margin:50px auto;
    height:400px;
    position:relative;
    color:#fff;
    text-shadow:rgba(0,0,0,0.1) 2px 2px 0px;    
}

#slider-wrap{
    width:600px;
    height:400px;
    position:relative;
    overflow:hidden;
}

#slider-wrap ul#slider{
    width:100%;
    height:100%;
    
    position:absolute;
    top:0;
    left:0;     
}

#slider-wrap ul#slider li{
    float:left;
    position:relative;
    width:600px;
    height:400px;   
}

#slider-wrap ul#slider li > div{
    position:absolute;
    top:20px;
    left:35px;  
}

#slider-wrap ul#slider li > div h3{
    font-size:36px;
    text-transform:uppercase;   
}

#slider-wrap ul#slider li > div span{
    font-family: Neucha, Arial, sans serif;
    font-size:21px;
}

#slider-wrap ul#slider li img{
    display:block;
    width:100%;
  height: 100%;
}


/*btns*/
.btns{
    position:absolute;
    width:50px;
    height:60px;
    top:50%;
    margin-top:-25px;
    line-height:57px;
    text-align:center;
    cursor:pointer; 
    background:rgba(0,0,0,0.1);
    z-index:100;
    
    
    -webkit-user-select: none;  
    -moz-user-select: none; 
    -khtml-user-select: none; 
    -ms-user-select: none;
    
    -webkit-transition: all 0.1s ease;
    -moz-transition: all 0.1s ease;
    -o-transition: all 0.1s ease;
    -ms-transition: all 0.1s ease;
    transition: all 0.1s ease;
}

.btns:hover{
    background:rgba(0,0,0,0.3); 
}

#next{right:-50px; border-radius:7px 0px 0px 7px;}
#previous{left:-50px; border-radius:0px 7px 7px 7px;}
#counter{
    top: 30px; 
    right:35px; 
    width:auto;
    position:absolute;
}

#slider-wrap.active #next{right:0px;}
#slider-wrap.active #previous{left:0px;}


/*bar*/
#pagination-wrap{
    min-width:20px;
    margin-top:350px;
    margin-left: auto; 
    margin-right: auto;
    height:15px;
    position:relative;
    text-align:center;
}

#pagination-wrap ul {
    width:100%;
}

#pagination-wrap ul li{
    margin: 0 4px;
    display: inline-block;
    width:5px;
    height:5px;
    border-radius:50%;
    background:#fff;
    opacity:0.5;
    position:relative;
  top:0;
  
  
}

#pagination-wrap ul li.active{
  width:12px;
  height:12px;
  top:3px;
    opacity:1;
    box-shadow:rgba(0,0,0,0.1) 1px 1px 0px; 
}




/*Header*/
h1, h2{text-shadow:none; text-align:center;}
h1{ color: #666; text-transform:uppercase;  font-size:36px;}
h2{ color: #7f8c8d; font-family: Neucha, Arial, sans serif; font-size:18px; margin-bottom:30px;} 




/*ANIMATION*/
#slider-wrap ul, #pagination-wrap ul li{
    -webkit-transition: all 0.3s cubic-bezier(1,.01,.32,1);
    -moz-transition: all 0.3s cubic-bezier(1,.01,.32,1);
    -o-transition: all 0.3s cubic-bezier(1,.01,.32,1);
    -ms-transition: all 0.3s cubic-bezier(1,.01,.32,1);
    transition: all 0.3s cubic-bezier(1,.01,.32,1); 
}

</style>
<title>태우형님의 웹사이트</title>
</head>
<body>
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
	<div>
		<img src="image/empty.png" width="20px" height="350px" align="center" />
		<img src="image/statistics.png" alt="" width="300px" height="300px"
			align="center" />
	</div>

	<%
		request.setCharacterEncoding("utf-8");
		String model = request.getParameter("model");
		String parameter = request.getParameter("parameter");
		String set = request.getParameter("set");
		String visualization = request.getParameter("visualization");
		String uploadFile = request.getParameter("uploadFile");
		if(model.equals("Decision Tree")){		
%>
	<p>Decision Tree</p>
		<ul class="slides">
		<input type="radio" name="radio-btn" id="img-1" checked />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/tw.png" />
			</div>
			<div class="nav">
				<label for="img-6" class="prev">&#x2039;</label> <label for="img-2"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-2" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_fimp.png" />
			</div>
			<div class="nav">
				<label for="img-1" class="prev">&#x2039;</label> <label for="img-3"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-3" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_gain.png" />
			</div>
			<div class="nav">
				<label for="img-2" class="prev">&#x2039;</label> <label for="img-4"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-4" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_tree.png" />
			</div>
			<div class="nav">
				<label for="img-3" class="prev">&#x2039;</label> <label for="img-5"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-5" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/analysis.png" />
			</div>
			<div class="nav">
				<label for="img-4" class="prev">&#x2039;</label> <label for="img-6"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-6" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/king.jpg" />
			</div>
			<div class="nav">
				<label for="img-5" class="prev">&#x2039;</label> <label for="img-1"
					class="next">&#x203a;</label>
			</div>
		</li>

		<li class="nav-dots"><label for="img-1" class="nav-dot"
			id="img-dot-1"></label> <label for="img-2" class="nav-dot"
			id="img-dot-2"></label> <label for="img-3" class="nav-dot"
			id="img-dot-3"></label> <label for="img-4" class="nav-dot"
			id="img-dot-4"></label> <label for="img-5" class="nav-dot"
			id="img-dot-5"></label> <label for="img-6" class="nav-dot"
			id="img-dot-6"></label></li>
	</ul>	
	<%}else if(model.equals("XGBoost")) { %>

	<p>XGBoost</p>
	<ul class="slides">
		<input type="radio" name="radio-btn" id="img-1" checked />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/tw.png" />
			</div>
			<div class="nav">
				<label for="img-6" class="prev">&#x2039;</label> <label for="img-2"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-2" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_fimp.png" />
			</div>
			<div class="nav">
				<label for="img-1" class="prev">&#x2039;</label> <label for="img-3"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-3" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_gain.png" />
			</div>
			<div class="nav">
				<label for="img-2" class="prev">&#x2039;</label> <label for="img-4"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-4" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/xgb_class2_tree.png" />
			</div>
			<div class="nav">
				<label for="img-3" class="prev">&#x2039;</label> <label for="img-5"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-5" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/analysis.png" />
			</div>
			<div class="nav">
				<label for="img-4" class="prev">&#x2039;</label> <label for="img-6"
					class="next">&#x203a;</label>
			</div>
		</li>

		<input type="radio" name="radio-btn" id="img-6" />
		<li class="slide-container">
			<div class="slide">
				<img src="./image/king.jpg" />
			</div>
			<div class="nav">
				<label for="img-5" class="prev">&#x2039;</label> <label for="img-1"
					class="next">&#x203a;</label>
			</div>
		</li>

		<li class="nav-dots"><label for="img-1" class="nav-dot"
			id="img-dot-1"></label> <label for="img-2" class="nav-dot"
			id="img-dot-2"></label> <label for="img-3" class="nav-dot"
			id="img-dot-3"></label> <label for="img-4" class="nav-dot"
			id="img-dot-4"></label> <label for="img-5" class="nav-dot"
			id="img-dot-5"></label> <label for="img-6" class="nav-dot"
			id="img-dot-6"></label></li>
	</ul>
	<%}else{ %>
		
	<p>etc</p>
		
	<%} %>
	

</body>
</html>