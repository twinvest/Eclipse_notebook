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
<style type="text/css">
body {background-color: #8eadbf;}

table {
  border-collapse: collapse;
  width: 58%;
  margin: auto;
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
</style>
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
			<a class="navbar-brand" href="main.jsp"><img src="image/logo.png" width="60px" height="25px"/></a>
		</div>
		<div class="collapse navbar-collapse"
			id="#bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="model.jsp">Learn model</a></li>
				<li><a href="predict.jsp">Predict</a></li>
				<li><a href="EDA.jsp">EDA</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right2">
	    <li class="dropdown">
	     <a href="#" class="dropdown-toggle"
	      data-toggle="dropdown" role="button" aria-haspopup="true"
	      aria-expanded="false">Disconnect<span class="caret"></span></a>
	     <ul class="dropdown-menu">
	      <li><a href="logout.jsp">Log out</a></li>
	     </ul>
	    </li>
	   </ul>
		</div>
	</nav>
<form action="modelfit.jsp" method="post">
<div>
			<img src="image/empty.png" width="620px" height="20px" align="center"/>
			<img src="image/analysis.png" alt="" width="270px" height="270px" align="center"/>
		</div>
<div class="bs-example" data-example-id="split-button-dropdown"
			align="center">
<table>
				<tr>
					<td><!-- Split button1 -->
			<div class="btn-group">
				<!-- Button1 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger1">경력 수</button>
				<INPUT TYPE=TEXT name=tw1; placeholder="숫자로만 입력"; style="height: 45px;  width: 150px; background: #e6eef2;">			
			</div>
				
				<!-- Split button2 -->
			<div class="btn-group">
				<!-- Button2 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger2">외국어 성적 개수</button>
				<INPUT TYPE=TEXT name=tw2; placeholder="숫자로만 입력"; style="height: 45px; width: 150px; background: #e6eef2;">	
			</div>
			
			<!-- Split button3 -->
			<div class="btn-group">
				<!-- Button3 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger3">나이</button>
				<INPUT TYPE=TEXT name=tw3; placeholder="숫자로만 입력"; style="height: 45px; width: 150px; background: #e6eef2;">	
			</div></td></tr>

				<tr><td>
				<!-- Split button4 -->
			<div class="btn-group">
				<!-- Button4 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger4">지역</button>
					<select name="지역" style="width: 150px; height: 45px; background: #e6eef2;">
						<li><a href="#" value="Metropolitan"><option value="Metropolitan">Metropolitan</option></a></li>
						<li><a href="#" value="Chungbuk"><option value="Chungbuk">Chungbuk</option></a></li>
						<li><a href="#" value="Chungnam"><option value="Chungnam">Chungnam</option></a></li>
						<li><a href="#" value="Gangwon"><option value="Gangwon">Gangwon</option></a></li>
						<li><a href="#" value="Kyongnam"><option value="Kyongnam">Kyongnam</option></a></li>
						<li><a href="#" value="Kyongbuk"><option value="Kyongbuk">Kyongbuk</option></a></li>
						<li><a href="#" value="Jeonam"><option value="Jeonam">Jeonam</option></a></li>
						<li><a href="#" value="Jeonbuk"><option value="Jeonbuk">Jeonbuk</option></a></li>
					</select>
			</div>
			
			<!-- Split button5 -->
			<div class="btn-group">
				<!-- Button5 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger5">자녀수</button>
				<INPUT TYPE=TEXT name=tw5; placeholder="숫자로만 입력"; style="height: 45px; width: 150px; background: #e6eef2;">
				</div>	
				
				<!-- Split button6 -->
			<div class="btn-group">
				<!-- Button6 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger6">동호회 가입여부</button>
					
					<select name="동회회 가입여부" style="width: 150px; height: 45px; background: #e6eef2;">
						<li><a href="#" value="YES"><option value="YES">YES</option></a></li>
						<li><a href="#" value="NO"><option value="NO">NO</option></a></li>
					</select>
			</div></td></tr>
			
			<tr><td>
			<!-- Split button7 -->
			<div class="btn-group">
				<!-- Button7 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger7">성별</button>
					<select name="성별" style="width: 150px; height: 45px; background: #e6eef2;">
						<li><a href="#" value="남자"><option value="남자">남자</option></a></li>
						<li><a href="#" value="여자"><option value="여자">여자</option></a></li>
					</select>
			</div>
			
			<!-- Split button8 -->
			<div class="btn-group">
				<!-- Button8 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger8">배우자 여부</button>
					<select name="배우자 여부" style="width: 150px; height: 45px; background: #e6eef2;">
						<li><a href="#" value="YES"><option value="YES">YES</option></a></li>
						<li><a href="#" value="NO"><option value="NO">NO</option></a></li>
					</select>
			</div>
			
			<!-- Split button9 -->
			<div class="btn-group">
				<!-- Button9 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger9">입사일</button>
					<INPUT TYPE=TEXT name=tw9; placeholder="1990-01-01형식"; style="height: 45px; width: 150px; background: #e6eef2;">
			</div></td></tr>
			
			<tr><td>
			<!-- Split button10 -->
			<div class="btn-group">
				<!-- Button10 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger10">퇴직일</button>
					<INPUT TYPE=TEXT name=tw10; placeholder="1990-01-01형식"; style="height: 45px; width: 150px; background: #e6eef2;">
			</div>
			
			<!-- Split button11 -->
			<div class="btn-group">
				<!-- Button11 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger11">근속연수</button>
					<INPUT TYPE=TEXT name=tw11; placeholder="숫자로만 입력"; style="height: 45px; width: 150px; background: #e6eef2;">
			</div>
			
			<!-- Split button12 -->
			<div class="btn-group">
				<!-- Button12 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger12">직위</button>
				<select name="직위" style="width: 150px; height: 45px; background: #e6eef2;">
					<li><a href="#" value="부장,소장 =1"><option value="부장,소장=1">부장,소장=1</option></a></li>
					<li><a href="#" value="직장,차장 =2"><option value="직장,차장=2">직장,차장=2</option></a></li>
					<li><a href="#" value="반장,과장 =3"><option value="반장,과장=3">반장,과장=3</option></a></li>
					<li><a href="#" value="대리,조장 =4"><option value="대리,조장=4">대리,조장=4</option></a></li>
					<li><a href="#" value="주임=5"><option value="주임=5">주임=5</option></a></li>
					<li><a href="#" value="사원 =6"><option value="사원=6">사원=6</option></a></li>
					</select>
			</div></td></tr>
			
			<tr><td>
			<!-- Split button13 -->
			<div class="btn-group">
				<!-- Button13 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger13">부서명</button>
					<select name="부서명" style="width: 150px; height: 45px; background: #e6eef2;">
					<li><a href="#" value="Executives"><option value="Executives">Executives</option></a></li>
					<li><a href="#" value="Production support"><option value="Production support">Production support</option></a></li>
					<li><a href="#" value="Purchasing"><option value="Purchasing">Purchasing</option></a></li>
					<li><a href="#" value="Production Management"><option value="Production Management">Production Management</option></a></li>
					<li><a href="#" value="Business Support"><option value="Business Support">Business Support</option></a></li>
					<li><a href="#" value="Designs"><option value="Design">Design</option></a></li>
					<li><a href="#" value="Business management"><option value="Business management">Business management</option></a></li>
					<li><a href="#" value="Quality Management"><option value="Quality Management">Quality Management</option></a></li>
					<li><a href="#" value="Financial management"><option value="Financial management">Financial management</option></a></li>
					<li><a href="#" value="Sales"><option value="Sales">Sales</option></a></li>
					<li><a href="#" value="Research"><option value="Research">Research</option></a></li>
					<li><a href="#" value="Warranty"><option value="Warranty">Warranty</option></a></li>
					<li><a href="#" value="Shipping"><option value="Shipping">Shipping</option></a></li>
					<li><a href="#" value="Technology"><option value="Technology">Technology</option></a></li>
					<li><a href="#" value="Service"><option value="Service">Service</option></a></li>
				</select>
			</div>
			
			<!-- Split button14 -->
			<div class="btn-group">
				<!-- Button14 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger14">주요부서 체크</button>
					<select name="주요부서 체크" style="width: 150px; height: 45px; background: #e6eef2;">
					<li><a href="#" value="YES"><option value="YES">YES</option></a></li>
					<li><a href="#" value="NO"><option value="NO">NO</option></a></li>
					</select>
			</div>
			
			<!-- Split button15 -->
			<div class="btn-group">
				<!-- Button15 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger15">자격증여부</button>
					<select name="자격증 여부" style="width: 150px; height: 45px; background: #e6eef2;">
					<li><a href="#" value="YES"><option value="YES">YES</option></a></li>
					<li><a href="#" value="NO"><option value="NO">NO</option></a></li>
					</select>
			</div></td></tr>
			
			<tr><td>
			<!-- Split button16 -->
			<div class="btn-group">
				<!-- Button16 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger16">주소</button>
					<INPUT TYPE=TEXT name=tw16; style="height: 45px; width: 445px; background: #e6eef2;">
			</div>
			
			<!-- Split button17 -->
			<div class="btn-group">
				<!-- Button17 -->
				<button type="button" style="color: white; background: #133a63; height: 45px; width: 140px;"
					class="btn btn-danger17">대학교</button>
					<INPUT TYPE=TEXT name=tw17; style="height: 45px; width: 150px; background: #e6eef2;">
			</div></td></tr>
			</table>					
		</div>
		<div class= "center">
		
		<br><button class="button" ><span>Go! Predict!</span></button>
		<style>
		.center {
  			width: 200px;
  			margin: 0 auto;
		}
		</style>
		</div>
	</form>
<%
		}
%>
	<!-- 애니매이션 담당 JQUERY -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- 부트스트랩 JS  -->
	<script src="js/bootstrap.js"></script>
</body>
</html>