<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="shopdb.*"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page
	import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.FileItem"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>BookRegistration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/front.css" rel="stylesheet" type="text/css">
<link href="css/default.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">

<style>
form div.dynamiclabel {
	/* div container for each form field with pop up label */
	display: block;
	margin: 30px;
	font: 16px;
	position: relative;
}

form div.dynamiclabel1 {
	/* div container for each form field with pop up label */
	display: block;
	margin: 30px;
	font: 16px;
	position: relative;
}

form div.dynamiclabel input[type="text"], form div.dynamiclabel textarea
	{
	width: 220px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel1 input[type="text"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="password"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="button"], form div.dynamiclabel textarea
	{
	width: 100px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="submit"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel input[type="reset"], form div.dynamiclabel textarea
	{
	width: 320px;
	padding: 10px;
	border: 1px solid #c3c3c3;
	border-radius: 7px;
}

form div.dynamiclabel textarea {
	height: 200px;
}

form div.dynamiclabel label { /* pop up label style */
	position: absolute;
	left: 0;
	background: lightyellow;
	border: 1px solid yellow;
	border-radius: 2px;
	padding: 3px 10px;
	box-shadow: 4px 1px 5px gray;
	font-weight: bold;
	-webkit-backface-visibility: hidden;
	top: 10px;
	/* initial top position of label relative to dynamiclabel container */
	-moz-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	-webkit-transition: all 0.4s ease-in-out;
	/* Safari doesn't seem to support cubic-bezier values beyond 0 to 1, so use keyword value instead */
	-o-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	opacity: 0;
	z-index: -1;
}

form div.dynamiclabel>*:focus {
	/* when user focuses on child element inside div.dynamiclabel */
	border: 1px solid #45bcd2;
	box-shadow: 0 0 8px 2px #98d865;
}

form div.dynamiclabel>*:focus+label {
	/* label style when user focuses on child element inside div.dynamiclabel */
	opacity: 1;
	z-index: 100;
	top: -35px;
	/* Post top position of label on focus relative to dynamiclabel container */
	-ms-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-webkit-transform: rotate(-3deg);
	transform: rotate(-3deg);
}

form div.dynamiclabel1 textarea {
	height: 200px;
}

form div.dynamiclabel1 label { /* pop up label style */
	position: absolute;
	left: 0;
	background: lightyellow;
	border: 1px solid yellow;
	border-radius: 2px;
	padding: 3px 10px;
	box-shadow: 4px 1px 5px gray;
	font-weight: bold;
	-webkit-backface-visibility: hidden;
	top: 10px;
	/* initial top position of label relative to dynamiclabel container */
	-moz-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	-webkit-transition: all 0.4s ease-in-out;
	/* Safari doesn't seem to support cubic-bezier values beyond 0 to 1, so use keyword value instead */
	-o-transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	transition: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
	opacity: 0;
	z-index: -1;
}

form div.dynamiclabel1>*:focus {
	/* when user focuses on child element inside div.dynamiclabel */
	border: 1px solid #45bcd2;
	box-shadow: 0 0 8px 2px #98d865;
}

form div.dynamiclabel1>*:focus+label {
	/* label style when user focuses on child element inside div.dynamiclabel */
	opacity: 1;
	z-index: 100;
	top: -35px;
	/* Post top position of label on focus relative to dynamiclabel container */
	-ms-transform: rotate(-3deg);
	-moz-transform: rotate(-3deg);
	-webkit-transform: rotate(-3deg);
	transform: rotate(-3deg);
}
}
</style>
</head>

<script language=JavaScript>
	function go() {
		window.location.href = "index.jsp";
	}
</script>

<body>
	<div id="jb-container">
		<div id="jb-header">
			<jsp:include page="header.jsp" />
			<!--  
<div id="bar">
<ul>
<li><a class ="bar1" href="#">���ͳ� ����</a></li>
<li><a class ="bar1" href="#">��ȭ</a></li>
<li><a class ="bar1" href="#">�ڰ���</a></li>
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
			<%
				BookEntity entity = new BookEntity();

				//���ε�� ������ ����Ǵ� ����
				String strSaveDir = getServletContext().getRealPath("img/book");
				File saveDir = new File(strSaveDir);
				//���ε����� ���� ���� ���� 
				if (!saveDir.exists())
					saveDir.mkdir();
				//out.println("���ε�Ǵ� ������ ����� ���� : <br>" + saveDir.getPath() + "<p>");

				//���ε忡 �ʿ��� �ӽ� ����
				String strTempDir = getServletContext().getRealPath("temp");
				File tempDir = new File(strTempDir);
				if (!tempDir.exists())
					tempDir.mkdir();
				//out.println("���ε带 ���� �ӽ� ���� : <br>" + tempDir.getPath() + "<br><hr>");

				if (ServletFileUpload.isMultipartContent(request)) {

					// ���ε�� ������ �ӽ������ϱ� ���� ���丮 ����
					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setSizeThreshold(1024 * 100);
					factory.setRepository(tempDir);

					// ������ ���ε��ϱ� ���� �ڵ鷯 ����
					ServletFileUpload upload = new ServletFileUpload(factory);
					// ������ �� �ִ� �ִ� ������ 
					upload.setSizeMax(1024 * 1024 * 10);

					// request�� �м��� �� �׸����� ó�� 
					List<FileItem> items = upload.parseRequest(request);

					for (FileItem item : items) {
						//�Ϲ� ���ڿ� ���Ͼ��ε� ���ڸ� �����Ͽ� ó�� 
						if (item.isFormField()) {
							// ���� �̿��� �Ķ���� ���� ���
							String name = item.getFieldName();
							String value = item.getString("euc-kr");
							out.println(item.getFieldName() + " : " + item.getString("euc-kr") + "<p><hr>");

							if (name.equals("isbn")) {
								entity.setIsbn(value);
							} else if (name.equals("title")) {
								entity.setTitle(value);
							} else if (name.equals("author")) {
								entity.setAuthor(value);
							} else if (name.equals("publisher")) {
								entity.setPublisher(value);
							} else if (name.equals("price")) {
								entity.setPrice(Integer.parseInt(value));
							} else if (name.equals("category")) {
								entity.setCategory(value);
							} else if (name.equals("remaining")) {
								entity.setRemaining(Integer.parseInt(value));
							} else if (name.equals("description")) {
								entity.setDescription(value);
							}

						} else {
							// ���ε��� ������ �����ϴ� ���
							if (item.getSize() > 0) {
								//���� �̸��� �����Ͽ� fileName�� ����
								String fileName = new File(item.getName()).getName();

								try {
									File uploadedFile = new File(saveDir, fileName);
									//���� �̸��� �̹� ������ ���� �ð������� �ڿ� ���� ���� �̸����� ����   
									if (uploadedFile.exists()) {
										java.util.Date now = new java.util.Date();

										int sp = fileName.lastIndexOf('.');
										String fileName1 = "";
										String extension = "";
										if (sp > 0) {
											fileName1 = fileName.substring(0, sp);
											extension = fileName.substring(sp + 1);
										}

										String newFileName = fileName1 + "-" + now.getTime() + "." + extension;
										uploadedFile = new File(saveDir, newFileName);
										out.println("�̸��� ���� ������ �̹� �־� ���� ���� �̸����� �����Ͽ����ϴ�. <br>");
										out.println("���� ���� �̸� : " + fileName + ", ");
										out.println("���� ���� �̸� : " + newFileName + "<p>");
									}

									//���ε� ���� ����
									item.write(uploadedFile);
									out.println("���ε� ���� ��ġ : " + saveDir.getPath() + "<br>");
									out.println("���ε� ���� �̸� : " + uploadedFile.getName() + "<p><hr>");

									entity.setImg(uploadedFile.getName());

								} catch (IOException e) {
									// ���� ó��
									out.println(e.toString());
								}
							}
						}
					}
				}

				ControlDAO bookDAO = new ControlDAO();
				bookDAO.insertBook(entity);
			%>
			<script>
				alert('���������� ��ϵǾ����ϴ�.');
				go();
			</script>
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