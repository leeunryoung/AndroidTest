<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%!
    String str1 ="JSP";
    String str2="�ȳ��ϼ���...";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>"HelloJAP"</title>
</head>
<body>
<h2>ó������� ����<%=str1 %></h2>
<p><%
out.println(str2+str1+"�Դϴ�. �����սô�^^*");
%>
</p>

</body>
</html>