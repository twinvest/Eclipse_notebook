<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ���</title>

</head>
<body>
	<%
		String isbn = request.getParameter("isbn");
		String user = request.getParameter("user");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Object obj_name = session.getAttribute("name");
		String name = (String) obj_name;

		ControlDAO dao = new ControlDAO();
		boolean success = dao.insertCart(user, isbn, quantity);

		if (success) {
	%>
	<script>
				if(confirm("��ٱ��Ͽ� �߰��Ǿ����ϴ�.\n��ٱ��ϸ� Ȯ�� �Ͻðڽ��ϱ�?")){
					location.href="myCart.jsp?user=<%=user%>
		";
		} else {
			history.go(-1);
		}
	</script>
	<%
		}
	%>
</body>
</html>