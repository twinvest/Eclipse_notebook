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
		String courier = request.getParameter("courier");  //��¼�
		String languagexam = request.getParameter("languagexam"); //�ܱ��� ���� ����
		String age = request.getParameter("age"); //����
		String local = request.getParameter("local"); //����
		String child = request.getParameter("child"); //�ڳ��
		String club = request.getParameter("club"); //��ȣȸ ���Կ���
		String gender = request.getParameter("gender"); //����
		String married = request.getParameter("married"); //����ڿ���
		String startday = request.getParameter("startday"); //�Ի���
		String endday = request.getParameter("endday"); //�����
		String workingyear = request.getParameter("workingyear"); //�ټӿ���
		String workposition = request.getParameter("workposition"); //����
		String workdepartment = request.getParameter("workdepartment"); //�μ���
		String checkdepartment = request.getParameter("checkdepartment"); //�ֿ�μ�üũ
		String cerficate = request.getParameter("cerficate"); //�ڰ��� ����
		String address = request.getParameter("address"); //�ּ�
		String school = request.getParameter("school"); //�ּ�
		
		
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