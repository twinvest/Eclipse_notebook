<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html >
<html>
<head>
<meta charset="EUC-KR">
<title>장바구니</title>

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
				if(confirm("장바구니에 추가되었습니다.\n장바구니를 확인 하시겠습니까?")){
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