<%@ page language="java" contentType="text/html; charset=EUC-KR"
        import="java.io.*,  
   java.util.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
        <%
    String command = "/bin/test3.sh";  // <---- ������ ����ɾ� 
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
        <!-- ��� ȭ�鿡 �Ѹ���... -->
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
File f = new File("/var/lib/tomcat8/webapps/TestWeb/image/tree.png");
// ���� ���� ���� �Ǵ�
if (f.isFile()) {
  System.out.println("OK ���� �ֽ��ϴ�.");
%> <p>���� exist</p>
<div>
                <img src="image/tree.png" alt="AI�� �� ���¿�!!" />
        </div>
<% } else { System.out.println("�׷� ���� �����ϴ�.");  %>
<p>���� no exist</p>
<%} %>
</body>
</html>