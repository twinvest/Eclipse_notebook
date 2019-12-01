<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>광교 서점 방문을 환영합니다!</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">

<style>
.imagepluscontainer { /* main image container */
	position: relative;
	z-index: 1;
}

.imagepluscontainer img { /* CSS for image within container */
	position: relative;
	z-index: 1;
	-moz-transition: all 0.5s ease;
	/* Enable CSS3 transition on all props */
	-webkit-transition: all 0.5s ease-in-out;
	-o-transition: all 0.5s ease-in-out;
	-ms-transition: all 0.5s ease-in-out;
	transition: all 0.5s ease-in-out;
}

.imagepluscontainer:hover img {
	/* CSS for image when mouse hovers over main container */
	-moz-box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	-moz-transform: scale(1.05, 1.05);
	-webkit-transform: scale(1.05, 1.05);
	-ms-transform: scale(1.05, 1.05);
	-o-transform: scale(1.05, 1.05);
	transform: scale(1.05, 1.05);
}

.imagepluscontainer div.desc { /* CSS for desc div of each image. */
	position: absolute;
	width: 90%;
	z-index: 1;
	/* Set z-index to that less than image's, so it's hidden beneath it */
	bottom: 0;
	/* Default position of desc div is bottom of container, setting it up to slide down */
	left: 5px;
	padding: 8px;
	background: rgba(0, 0, 0, 0.8); /* black bg with 80% opacity */
	color: white;
	-moz-border-radius: 0 0 8px 8px; /* CSS3 rounded borders */
	-webkit-border-radius: 0 0 8px 8px;
	border-radius: 0 0 8px 8px;
	opacity: 0; /* Set initial opacity to 0 */
	-moz-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8); /* CSS3 shadows */
	-webkit-box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
	box-shadow: 0 0 6px rgba(0, 0, 0, 0.8);
	-moz-transition: all 0.5s ease 0.5s;
	/* Enable CSS3 transition on desc div. Final 0.5s value is the delay before animation starts */
	-webkit-transition: all 0.5s ease 0.5s;
	-o-transition: all 0.5s ease 0.5s;
	-ms-transition: all 0.5s ease 0.5s;
	transition: all 0.5s ease 0.5s;
}

.imagepluscontainer div.desc a {
	color: white;
}

.imagepluscontainer:hover div.desc {
	/* CSS for desc div when mouse hovers over main container */
	-moz-transform: translate(0, 100%);
	-webkit-transform: translate(0, 100%);
	-ms-transform: translate(0, 100%);
	-o-transform: translate(0, 100%);
	transform: translate(0, 100%);
	opacity: 1; /* Reveal desc DIV fully */
}

/*### Below CSS when applied to desc DIV slides the desc div from the right edge of the image ###*/
.imagepluscontainer div.rightslide {
	width: 150px; /* reset from default */
	top: 5px;
	right: 0;
	left: auto; /* reset from default */
	bottom: auto; /* reset from default */
	padding-left: 5px;
	-moz-border-radius: 0 8px 8px 0;
	-webkit-border-radius: 0 8px 8px 0;
	border-radius: 0 8px 8px 0;
}

.imagepluscontainer:hover div.rightslide {
	-moz-transform: translate(100%, 0);
	-webkit-transform: translate(100%, 0);
	-ms-transform: translate(100%, 0);
	-o-transform: translate(100%, 0);
	transform: translate(100%, 0);
}

/*### Below CSS when applied to desc DIV slides the desc div from the left edge of the image ###*/
.imagepluscontainer div.leftslide {
	width: 150px; /* reset from default */
	top: 15px;
	left: 0;
	bottom: auto; /* reset from default */
	padding-left: 5px;
	-moz-border-radius: 8px 0 0 8px;
	-webkit-border-radius: 8px 0 0 8px;
	border-radius: 8px 0 0 8px;
}

.imagepluscontainer:hover div.leftslide {
	-moz-transform: translate(-100%, 0);
	-webkit-transform: translate(-100%, 0);
	-ms-transform: translate(-100%, 0);
	-o-transform: translate(-100%, 0);
	transform: translate(-100%, 0);
}

/*### Below CSS when applied to desc DIV slides the desc div from the top edge of the image ###*/
.imagepluscontainer div.upslide {
	top: 0;
	bottom: auto; /* reset from default */
	padding-bottom: 10px;
	-moz-border-radius: 8px 8px 0 0;
	-webkit-border-radius: 8px 8px 0 0;
	border-radius: 8px 8px 0 0;
}

.imagepluscontainer:hover div.upslide {
	-moz-transform: translate(0, -100%);
	-webkit-transform: translate(0, -100%);
	-ms-transform: translate(0, -100%);
	-o-transform: translate(0, -100%);
	transform: translate(0, -100%);
}
</style>
<!--  
Jquery 적용 전입니다.
<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>

<script>
$(document).ready(function(){
$("#main_aside li a.menu01").click(function(){
	$("#bar").stop().animate({"width":200});
});
});

</script>
 -->
</head>

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
			<img src="img/news.png">
			<table>
				<tr>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">
							<a href="bookInfo.jsp?isbn=9788954637756"> <img
								src="img/pronouncement.jpg" />
							</a>
							<div class="desc upslide">
								판사 문유석의 일상유감<a href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>

						</div>
					</td>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">

							<a href="bookInfo.jsp?isbn=9788954641630"> <img
								src="img/smile.jpg" />
							</a>
							<div class="desc upslide">
								서로에 대한 마음의 ‘기댐’과 ‘기댐 받음’의 연쇄가 갖고 있는 힘을 믿는 이야기<a
									href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
				</tr>
				<tr>

					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">
							<a href="bookInfo.jsp?isbn=9788936434120"> <img
								src="img/come.jpg" />
							</a>
							<div class="desc upslide">
								고통스럽게 되살려낸 5월 광주<a href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">
							<a href="bookInfo.jsp?isbn=9788983711892"> <img
								src="img/cosmos.jpg" />
							</a>
							<div class="desc upslide">
								방대하고 심오한 우주의 세계<a href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
				</tr>
			</table>

			<img src="img/main2.jpg">

			<table>
				<tr>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px;">
							<a href="bookInfo.jsp?isbn=9791161340371"> <img
								src="img/python.jpg" />
							</a>
							<div class="desc upslide">
								파이썬 커뮤니티 코어 개발자들이 말하는 파이썬의 과거, 현재 그리고 미래 <a
									href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>

						</div>
					</td>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">

							<a href="bookInfo.jsp?isbn=9788997291090"> <img
								src="img/alice.jpg" />
							</a>
							<div class="desc upslide">
								여전히 보이지 않지만 아직도 찾아 헤매는 삶의 소중한 것들! <a
									href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
				</tr>
				<tr>

					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">
							<a href="bookInfo.jsp?isbn=9791157061419"> <img
								src="img/brain.jpg" />
							</a>
							<div class="desc upslide">
								너무 많은 생각이 당신을 망가뜨린다 <a
									href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
					<td>
						<div class="imagepluscontainer"
							style="width: 263px; height: 199px; left: 35px">
							<a href="bookInfo.jsp?isbn=9791189584078"> <img
								src="img/rain.jpg" />
							</a>
							<div class="desc upslide">
								말기암 치매 아빠와의 76일 <a href="http://en.wikipedia.org/wiki/Colosseum"></a>
							</div>
						</div>
					</td>
				</tr>
			</table>

		</div>
		<div id="jb-sidebar-right">
			<jsp:include page="aside2.jsp" />
		</div>

		<div id="jb-footer align=center">
			<jsp:include page="bottom.jsp" />
			<jsp:include page="footer.jsp" />
		</div>
	</div>
	<hr />
</body>
</html>

<SCRIPT type=text/javascript>
<!--
	isIE = document.all;
	isNN = !document.all && document.getElementById;
	isN4 = document.layers;
	isHot = false;

	function ddInit(e) {
		topDog = isIE ? "BODY" : "HTML";
		whichDog = isIE ? document.all.mainAd : document
				.getElementById("mainAd");
		hotDog = isIE ? event.srcElement : e.target;
		while (hotDog.id != "mainAd" && hotDog.tagName != topDog) {
			hotDog = isIE ? hotDog.parentElement : hotDog.parentNode;
		}
		if (hotDog.id == "mainAd") {
			offsetx = isIE ? event.clientX : e.clientX;
			offsety = isIE ? event.clientY : e.clientY;
			nowX = parseInt(whichDog.style.left);
			nowY = parseInt(whichDog.style.top);
			ddEnabled = true;
			document.onmousemove = dd;
		}
	}

	function dd(e) {
		if (!ddEnabled)
			return;
		whichDog.style.left = isIE ? nowX + event.clientX - offsetx : nowX
				+ e.clientX - offsetx;
		whichDog.style.top = isIE ? nowY + event.clientY - offsety : nowY
				+ e.clientY - offsety;
		return false;
	}

	document.onmousedown = ddInit;
	document.onmouseup = Function("ddEnabled=false");

	//메인팝업관련 쿠키설정
	function setCookie(name, value, expiredays) {
		var now = new Date();
		now.setDate(now.getDate() + expiredays);
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ now.toGMTString() + ";"
	}

	//메인팝업감추기
	function closeDiv() {
		var mainAd = document.getElementById("mainAd");
		var checkbox = document.getElementById("checkbox");

		if (checkbox.checked == true) {
			setCookie("viewPop", "ok", 1);
		}
		mainAd.style.visibility = "hidden";
	}
// -->
</SCRIPT>

<DIV id="mainAd"
	style="Z-INDEX: 150; RIGHT: 200px; POSITION: absolute; TOP: 150px; border: solid; border-color: black; border-width: 1px">
	<FORM name=mainAdfrm>
		<TABLE cellSpacing=0 cellPadding=0 border=0
			style="border: solid; border-color: #cccccc; border-width: 1px">
			<TR>
				<TD style="PADDING: 0px 0px 0px 0px">


					<TABLE cellSpacing=0 cellPadding=0 width="361" border=0>
						<TR>
							<TD align=left></TD>
							<TD width=16></TD>
						</TR>
					</TABLE>

				</TD>
			</TR>
			<TR>
				<TD style="padding: 3 5px 0 5px"
					background="popup/images/drag_bg_mid.gif">
					<!-- 팝업 내용 --> <iframe id="mainAdFrame" src="img/rule.jpg"
						width="350" height="150" frameborder="0" marginwidth="0"
						marginheight="0" vspace="0" hspace="0" scrolling="no"
						allowtransparency="true"></iframe> <!-- // 팝업내용 끝 -->

				</TD>
			</TR>
			<TR>

				<TABLE cellSpacing=0 cellPadding=0 width="361" border=0
					bgcolor="#ffffff">
					<TR>
						<TD style="PADDING-RIGHT: 0px" align=center><INPUT
							onfocus='this.blur();' id=checkbox type=checkbox value=checkbox
							name=checkbox> <LABEL for=checkbox><font size="2"
								color="#3b352a" face="돋음">오늘 더 이상 보지않기</font></LABEL></TD>
						<TD width=21 style="PADDING: 0 8 0 0;"><IMG
							style="CURSOR: pointer" onclick=closeDiv(); src="img/x.jpg"
							border=0></TD>
					</TR>
				</TABLE>

				</TD>
			</TR>
		</TABLE>
</DIV>
</FORM>

<SCRIPT type=text/javascript>
<!--
	var mainAd = document.getElementById("mainAd");
	cookiedata = document.cookie;
	if (cookiedata.indexOf("viewPop=ok") < 0) {
		mainAd.style.visibility = "visible";//사용을 원하면 hidden ->visible 로 바꿔주세요.
	} else {
		mainAd.style.visibility = "hidden";
	}
	//-->
	window.setTimeout("mainAd.style.visibility = 'hidden'", 7000);
</SCRIPT>
<!---------------------------------스크립트팝업끝--------------------------------->