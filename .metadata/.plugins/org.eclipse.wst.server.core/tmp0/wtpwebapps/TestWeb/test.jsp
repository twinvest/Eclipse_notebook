<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>테스트 페이지</title>
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
</style>

<style>
body {
	margin: 10px
}

.where {
	display: block;
	margin: 25px 15px;
	font-size: 11px;
	color: #000;
	text-decoration: none;
	font-family: verdana;
	font-style: italic;
}

.filebox input[type="file"] {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.filebox label {
	display: inline-block;
	padding: .5em .75em;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}

/* named upload */
.filebox .upload-name {
	display: inline-block;
	padding: .5em .75em;
	font-size: inherit;
	font-family: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #f5f5f5;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

.filebox.bs3-primary label {
	color: #fff;
	background-color: #337ab7;
	border-color: #2e6da4;
}
body{
  width: 100%;
  height: 100%;
  margin: auto;
  text-align: center;
}
#inp {
  text-align: center;
  margin: auto;
}
</style>
</head>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 최신버전 제이쿼리 -->

<body>
	<form action="modelfit.jsp" method="post">
	<div class="filebox bs3-primary">
		<input class="upload-name" value="파일선택" disabled="disabled"> <label
			for="ex_filename">업로드</label> <input type="file" id="ex_filename"
			class="upload-hidden">
	</div>
	<input id="inp" type="file" accept="image/*">
	<input type="submit"
			style="height: 50px; width: 100px;" value="learn model!">
</form>
</body>

</html>