<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.io.*,  
   java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
    String command = "/bin/test3.sh";  // <---- 실행할 쉘명령어 
    int lineCount = 0;
    String line="";
    Runtime rt = Runtime.getRuntime();
    Process ps = null;
    try{
      ps = rt.exec(command);
      BufferedReader br =
            new BufferedReader(
                    new InputStreamReader(
                          new SequenceInputStream(ps.getInputStream(), ps.getErrorStream())));
      while((line = br.readLine()) != null){
%>
	<%=line%><br>
	<!-- 결과 화면에 뿌리기... -->
<%
      }
      br.close();
   }catch(IOException ie){
      ie.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }
%>
<%
File f = new File("/var/lib/tomcat8/webapps/TestWeb/tree/tree.png");
// 파일 존재 여부 판단
if (f.isFile()) {
  System.out.println("OK 파일 있습니다.");
%>
	<p>파일 exist</p>
	<div>
		<img src="tree/tree.png" alt="AI의 왕 김태우!!" />
	</div>
	<div>
		<img src="tree/feature.png" alt="AI의 " />
	</div>
	<% } else { System.out.println("그런 파일 없습니다.");  %>
	<p>파일 no exist</p>
	<%} %>
</body>
</html>