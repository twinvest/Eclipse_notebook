/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.61
 * Generated at: 2019-08-27 13:01:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class predict_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<!-- 뷰포트 -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\" initial-scale=\"1\">\r\n");
      out.write("<!-- 스타일시트 참조  -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"> \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {background-color: #8eadbf;}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("  border-collapse: collapse;\r\n");
      out.write("  width: 58%;\r\n");
      out.write("  margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("  padding: 3spx;\r\n");
      out.write("  text-align: middle;\r\n");
      out.write("  border-bottom: 1px solid #ddd;\r\n");
      out.write("  border-top: 1px solid #ddd;\r\n");
      out.write("  width: 45px;\r\n");
      out.write("  height: 50px; \r\n");
      out.write("  background: #133a63;\r\n");
      out.write("  color: white; \r\n");
      out.write("}\r\n");
      out.write("td {\r\n");
      out.write("  padding: 3spx;\r\n");
      out.write("  text-align: middle;\r\n");
      out.write("  border-bottom: 1px solid #ddd;\r\n");
      out.write("  border-top: 1px solid #ddd;\r\n");
      out.write("  width: 60px;\r\n");
      out.write("  height: 50px;\r\n");
      out.write("  font-weight: 900;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("  background-color: #345166;\r\n");
      out.write("  border: none;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 15px 32px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  font-size: 17px;\r\n");
      out.write("  margin: 5px 3px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  -webkit-transition-duration: 0.4s; /* Safari */\r\n");
      out.write("  transition-duration: 0.4s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".button span {\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  transition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button span:after {\r\n");
      out.write("  content: '\\00bb';\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  opacity: 0;\r\n");
      out.write("  top: 0;\r\n");
      out.write("  right: -20px;\r\n");
      out.write("  transition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover span {\r\n");
      out.write("  padding-right: 25px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover span:after {\r\n");
      out.write("  opacity: 1;\r\n");
      out.write("  right: 0;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");

		if (session.getAttribute("userID").equals("tw")) {
	
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-default\">\r\n");
      out.write("\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("\t\t\t\taria-expaned=\"false\">\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"main.jsp\"><img src=\"image/logo.png\" width=\"60px\" height=\"25px\"/></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\tid=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li><a href=\"model.jsp\">Learn model</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"predict.jsp\">Predict</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"EDA.jsp\">EDA</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right2\">\r\n");
      out.write("\t    <li class=\"dropdown\">\r\n");
      out.write("\t     <a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("\t      data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("\t      aria-expanded=\"false\">Disconnect<span class=\"caret\"></span></a>\r\n");
      out.write("\t     <ul class=\"dropdown-menu\">\r\n");
      out.write("\t      <li><a href=\"logout.jsp\">Log out</a></li>\r\n");
      out.write("\t     </ul>\r\n");
      out.write("\t    </li>\r\n");
      out.write("\t   </ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("<form action=\"modelfit.jsp\" method=\"post\">\r\n");
      out.write("<div>\r\n");
      out.write("\t\t\t<img src=\"image/empty.png\" width=\"620px\" height=\"20px\" align=\"center\"/>\r\n");
      out.write("\t\t\t<img src=\"image/analysis.png\" alt=\"\" width=\"270px\" height=\"270px\" align=\"center\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<div class=\"bs-example\" data-example-id=\"split-button-dropdown\"\r\n");
      out.write("\t\t\talign=\"center\">\r\n");
      out.write("<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><!-- Split button1 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button1 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger1\">경력 수</button>\r\n");
      out.write("\t\t\t\t<INPUT TYPE=TEXT name=tw1; placeholder=\"숫자로만 입력\"; style=\"height: 45px;  width: 150px; background: #e6eef2;\">\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Split button2 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button2 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger2\">외국어 성적 개수</button>\r\n");
      out.write("\t\t\t\t<INPUT TYPE=TEXT name=tw2; placeholder=\"숫자로만 입력\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button3 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button3 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger3\">나이</button>\r\n");
      out.write("\t\t\t\t<INPUT TYPE=TEXT name=tw3; placeholder=\"숫자로만 입력\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\t\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr><td>\r\n");
      out.write("\t\t\t\t<!-- Split button4 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button4 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger4\">지역</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"지역\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Metropolitan\"><option value=\"Metropolitan\">Metropolitan</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Chungbuk\"><option value=\"Chungbuk\">Chungbuk</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Chungnam\"><option value=\"Chungnam\">Chungnam</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Gangwon\"><option value=\"Gangwon\">Gangwon</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Kyongnam\"><option value=\"Kyongnam\">Kyongnam</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Kyongbuk\"><option value=\"Kyongbuk\">Kyongbuk</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Jeonam\"><option value=\"Jeonam\">Jeonam</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"Jeonbuk\"><option value=\"Jeonbuk\">Jeonbuk</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button5 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button5 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger5\">자녀수</button>\r\n");
      out.write("\t\t\t\t<INPUT TYPE=TEXT name=tw5; placeholder=\"숫자로만 입력\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Split button6 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button6 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger6\">동호회 가입여부</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<select name=\"동회회 가입여부\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"YES\"><option value=\"YES\">YES</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"NO\"><option value=\"NO\">NO</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr><td>\r\n");
      out.write("\t\t\t<!-- Split button7 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button7 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger7\">성별</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"성별\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"남자\"><option value=\"남자\">남자</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"여자\"><option value=\"여자\">여자</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button8 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button8 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger8\">배우자 여부</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"배우자 여부\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"YES\"><option value=\"YES\">YES</option></a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" value=\"NO\"><option value=\"NO\">NO</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button9 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button9 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger9\">입사일</button>\r\n");
      out.write("\t\t\t\t\t<INPUT TYPE=TEXT name=tw9; placeholder=\"1990-01-01형식\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr><td>\r\n");
      out.write("\t\t\t<!-- Split button10 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button10 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger10\">퇴직일</button>\r\n");
      out.write("\t\t\t\t\t<INPUT TYPE=TEXT name=tw10; placeholder=\"1990-01-01형식\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button11 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button11 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger11\">근속연수</button>\r\n");
      out.write("\t\t\t\t\t<INPUT TYPE=TEXT name=tw11; placeholder=\"숫자로만 입력\"; style=\"height: 45px; width: 150px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button12 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button12 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger12\">직위</button>\r\n");
      out.write("\t\t\t\t<select name=\"직위\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"부장,소장 =1\"><option value=\"부장,소장=1\">부장,소장=1</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"직장,차장 =2\"><option value=\"직장,차장=2\">직장,차장=2</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"반장,과장 =3\"><option value=\"반장,과장=3\">반장,과장=3</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"대리,조장 =4\"><option value=\"대리,조장=4\">대리,조장=4</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"주임=5\"><option value=\"주임=5\">주임=5</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"사원 =6\"><option value=\"사원=6\">사원=6</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr><td>\r\n");
      out.write("\t\t\t<!-- Split button13 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button13 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger13\">부서명</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"부서명\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Executives\"><option value=\"Executives\">Executives</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Production support\"><option value=\"Production support\">Production support</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Purchasing\"><option value=\"Purchasing\">Purchasing</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Production Management\"><option value=\"Production Management\">Production Management</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Business Support\"><option value=\"Business Support\">Business Support</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Designs\"><option value=\"Design\">Design</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Business management\"><option value=\"Business management\">Business management</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Quality Management\"><option value=\"Quality Management\">Quality Management</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Financial management\"><option value=\"Financial management\">Financial management</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Sales\"><option value=\"Sales\">Sales</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Research\"><option value=\"Research\">Research</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Warranty\"><option value=\"Warranty\">Warranty</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Shipping\"><option value=\"Shipping\">Shipping</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Technology\"><option value=\"Technology\">Technology</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"Service\"><option value=\"Service\">Service</option></a></li>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button14 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button14 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger14\">주요부서 체크</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"주요부서 체크\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"YES\"><option value=\"YES\">YES</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"NO\"><option value=\"NO\">NO</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button15 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button15 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger15\">자격증여부</button>\r\n");
      out.write("\t\t\t\t\t<select name=\"자격증 여부\" style=\"width: 150px; height: 45px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"YES\"><option value=\"YES\">YES</option></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" value=\"NO\"><option value=\"NO\">NO</option></a></li>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr><td>\r\n");
      out.write("\t\t\t<!-- Split button16 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button16 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger16\">주소</button>\r\n");
      out.write("\t\t\t\t\t<INPUT TYPE=TEXT name=tw16; style=\"height: 45px; width: 445px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- Split button17 -->\r\n");
      out.write("\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t<!-- Button17 -->\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"color: white; background: #133a63; height: 45px; width: 140px;\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger17\">대학교</button>\r\n");
      out.write("\t\t\t\t\t<INPUT TYPE=TEXT name=tw17; style=\"height: 45px; width: 150px; background: #e6eef2;\">\r\n");
      out.write("\t\t\t</div></td></tr>\r\n");
      out.write("\t\t\t</table>\t\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class= \"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><button class=\"button\" ><span>Go! Predict!</span></button>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t.center {\r\n");
      out.write("  \t\t\twidth: 200px;\r\n");
      out.write("  \t\t\tmargin: 0 auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");

		}

      out.write("\r\n");
      out.write("\t<!-- 애니매이션 담당 JQUERY -->\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<!-- 부트스트랩 JS  -->\r\n");
      out.write("\t<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
