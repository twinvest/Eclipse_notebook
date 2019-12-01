<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link href='http://fonts.googleapis.com/css?family=Raleway:600'
	rel='stylesheet' type='text/css'>

<style>
ul.sonarmenu {
	/* Inspired by http://tympanus.net/codrops/2013/08/06/creative-link-effects */
	list-style: none;
}

ul.sonarmenu li {
	display: inline;
}

ul.sonarmenu a {
	position: relative;
	display: inline-block;
	color: black; /* font color */
	text-decoration: none;
	margin: 10px 20px;
	text-transform: uppercase;
	font-family: 'Raleway', sans-serif;
	/* font style (uses Google fonts) */
	font-size: 14px; /* font size */
	letter-spacing: 2px; /* letter spacing */
	border-bottom: 2px solid transparent; /* Bottom border style */
}

ul.sonarmenu a:hover, ul.sonarmenu a:focus {
	outline: none;
	border-bottom: 2px solid #eee; /* Bottom border style on hover */
}

ul.sonarmenu a::before, ul.sonarmenu a:after {
	/* shared style for two circles */
	position: absolute;
	top: 50%;
	left: 50%;
	width: 70px; /* width of outer circle */
	height: 70px; /* height of outer circle */
	border: 12px double rgba(0, 0, 0, 0.1);
	/* style and color of circles */
	border-radius: 50%;
	content: '';
	opacity: 0;
	-webkit-transform: translateX(-50%) translateY(-50%) scale(0.2);
	-moz-transform: translateX(-50%) translateY(-50%) scale(0.2);
	transform: translateX(-50%) translateY(-50%) scale(0.2);
}

ul.sonarmenu a:after { /* inner circle specific CSS */
	width: 60px; /* width of inner circle */
	height: 60px; /* width of inner circle */
	border-width: 6px;
	-webkit-transform: translateX(-50%) translateY(-50%) scale(0.8);
	-moz-transform: translateX(-50%) translateY(-50%) scale(0.8);
	transform: translateX(-50%) translateY(-50%) scale(0.8);
}

ul.sonarmenu a:hover:before, ul.sonarmenu a:hover:after {
	-webkit-animation: pulsate 1.2s infinite;
	/* animation name duration loop etc */
	-moz-animation: pulsate 1.2s infinite;
	-ms-animation: pulsate 1.2s infinite;
	animation: pulsate 1.2s infinite;
}

/* ### Keyframe animations ### */
@
-webkit-keyframes pulsate { 30%{
	opacity: 1;
	-webkit-transform: translateX(-50%) translateY(-50%) scale(1);
}

100%{
opacity


:

 

0
.3


;
-webkit-transform


:

 

translateX


(-50%)
translateY


(-50%)
scale


(0
.5


);
}
}
@
-moz-keyframes pulsate { 30%{
	opacity: 1;
	-moz-transform: translateX(-50%) translateY(-50%) scale(1);
}

100%{
opacity


:

 

0
.3


;
-moz-transform


:

 

translateX


(-50%)
translateY


(-50%)
scale


(0
.5


);
}
}
@
-ms-keyframes pulsate { 30%{
	opacity: 1;
	-ms-transform: translateX(-50%) translateY(-50%) scale(1);
}

100%{
opacity


:

 

0
.3


;
-ms-transform


:

 

translateX


(-50%)
translateY


(-50%)
scale


(0
.5


);
}
}
@
-keyframes pulsate { 30%{
	opacity: 1;
	transform: translateX(-50%) translateY(-50%) scale(1);
}
100%{
opacity


:

 

0
.3


;
transform


:

 

translateX


(-50%)
translateY


(-50%)
scale


(0
.5


);
}
}
</style>
</head>
<body>
	<section id="main_aside">

		<br /> <br />
		<ul class="sonarmenu">
			<hr />
			<center>
				<li><b> <font size=6> 도  서</font>
				</b></li>
			</center>
			<hr />
			<br />
			<br />
			<center>

				<li><a class="menu01" href="guk.jsp">국내 도서</a></li>
				<li><a href="ha.jsp">외국 도서</a></li>
				<li><a href="ebook.jsp">E-Book</a></li>
				<li><a href="best.jsp">베스트셀러</a></li>
				<li><a href="half.jsp">할인 도서</a></li>
			</center>


			<br />
			<br />

			<br />

			<hr />
			<center>
				<li><b><font size=6>
							<p /> 게시판
					</font> </b></li>
			</center>
			<hr />
			<br />
			<br />
			<center>
				<li><a href="listBang.jsp">NOTICE</a></li>
				<li><a href="listBoard.jsp">Q & A</a></li>
				<li><a href="event.jsp">Event</a></li>
			</center>
		</ul>

		<br /> <br />
		<hr />

		</ul>

	</section>

</body>
</html>