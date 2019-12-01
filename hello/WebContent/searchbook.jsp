<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page
	import="java.util.ArrayList, shopdb.*, java.text.SimpleDateFormat"%>
<%@ page import="shopdb.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>


<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">

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

		<%@ page import="java.sql.*"%>

		<%
			request.setCharacterEncoding("euc-kr");
		%>

		<%
			String type = request.getParameter("type");
			String bname = request.getParameter("bname");
		%>



		<%
			String IMGPATH = "img/book/";
			String sql;
			Connection con = null;
			PreparedStatement pstmt = null;
			String driverName = "org.gjt.mm.mysql.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/shopdb";

			if (type.equals("title")) {
				sql = "select * from Book where title =?";
			} else if (type.equals("name")) {
				sql = "select * from Book where author=?";
			} else
				sql = "select * from Book where publisher=?";

			try {
				Class.forName(driverName);
				con = DriverManager.getConnection(dbURL, "root", "de52ch1683");
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bname);
				ResultSet result = pstmt.executeQuery();
		%>


		<center>
			<table width=700 cellpadding=3 cellspacing=3>

				<tr>
					<th width=430 bgcolor=lightgray><font color=blue><b>ISBN</b></font></th>
					<th width=430 bgcolor=lightgray><font color=blue><b>book</b></font></th>
					<th width=430 bgcolor=lightgray><font color=blue><b>제목</b></font></th>
					<th width=430 bgcolor=lightgray><font color=blue><b>저자</b></font></th>
					<th width=430 bgcolor=lightgray><font color=blue><b>출판사</b></font></th>
					<th width=430 bgcolor=lightgray><font color=blue><b>가격</b></font></th>


				</tr>


				<%
					while (result.next()) {
				%>

				<tr>

					<td align=center><a
						href="bookInfo.jsp?isbn=<%=result.getString("isbn")%>"><%=result.getString("isbn")%>
							<td align=center><a
								href="bookInfo.jsp?isbn=<%=result.getString("isbn")%>"><img
									src=<%=IMGPATH + result.getString("img")%> height=150></td>
							<td align=center><%=result.getString("title")%></a></td>

					<td align=center><%=result.getString("author")%></a></td>
					<td align=center><%=result.getString("publisher")%></a></td>
					<td align=center><%=result.getString("price")%></a></td>
					</a>
				</tr>
				<%
					}
						result.close();
					}

					catch (Exception e) {
						out.println("에러가 발생했습니다.");
						out.println(e.toString());
						e.printStackTrace();
					}

					finally {
						if (pstmt != null)
							pstmt.close();
						if (con != null)
							con.close();
					}
				%>




			</table>
	</div>
	<div id="jb-sidebar-right">

		<jsp:include page="aside2.jsp" />

	</div>



	<div id="jb-footer">


		<jsp:include page="bottom.jsp" />

		<jsp:include page="footer.jsp" />
	</div>

	</div>

	<hr />
</body>
</html>