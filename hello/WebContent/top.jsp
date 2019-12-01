<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">

</head>



<body>

</br>




<top id="main_top">


<a href="index.jsp">
<img src="img/광교서점.png" ALT="달이 떴다고 전화를 주시다니요." >
</a>

<div align="right">

<form method="post" action="searchbook.jsp">

<select name="type" >
<option SELECTED value="title">책 제목</option>
<option value="name">저자</option>
<option value="public">출판사</option>
</select>

<input type="text" name="bname" size=25 >
<input type="submit" value="  검색   " size=20>
<br/><br/><br/>

</form>
</div>


<br/><br/>



</body>
</html>