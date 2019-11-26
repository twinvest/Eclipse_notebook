<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); 
		String courier = request.getParameter("courier");  //경력수
		String languagexam = request.getParameter("languagexam"); //외국어 성적 개수
		String age = request.getParameter("age"); //나이
		String local = request.getParameter("local"); //지역
		String child = request.getParameter("child"); //자녀수
		String club = request.getParameter("club"); //동호회 가입여부
		String gender = request.getParameter("gender"); //성별
		String married = request.getParameter("married"); //배우자여부
		String startday = request.getParameter("startday"); //입사일
		String endday = request.getParameter("endday"); //퇴사일
		String workingyear = request.getParameter("workingyear"); //근속연수
		String workposition = request.getParameter("workposition"); //직위
		String workdepartment = request.getParameter("workdepartment"); //부서명
		String checkdepartment = request.getParameter("checkdepartment"); //주요부서체크
		String cerficate = request.getParameter("cerficate"); //자격증 여부
		String address = request.getParameter("address"); //주소
		String school = request.getParameter("school"); //주소
		
		
		String cmd = "/bin/testest.sh";
	%>
<br>
<%=courier %>
<br>
<%=languagexam %>
<br>
<%=age %>
<br>
<%=local %>
<br>
<%=child %>
<br>
<%=club %>
<br>
<%=gender %>
<br>
<%=married %>
<br>
<%=startday %>
<br>
<%=endday %>
<br>
<%=workingyear %>
<br>
<%=workposition %>
<br>
<%=checkdepartment %>
<br>
<%=workdepartment %>
<br>
<%=cerficate %>
<br>
<%=address %>
<br>
<%=school %>
<br>
</body>
</html>