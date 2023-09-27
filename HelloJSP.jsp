<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%!
    String str1 ="JSP";
    String str2="안녕하세요...";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>"HelloJAP"</title>
</head>
<body>
<h2>처음만들어 보는<%=str1 %></h2>
<p><%
out.println(str2+str1+"입니다. 열공합시다^^*");
%>
</p>

</body>
</html>