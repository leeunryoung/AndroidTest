<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ page import="java.text.SimpleDateFormat" %>
  <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>page 지시어 - import 속성</title>
</head>
<body>
<%
Date today =new Date();
SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
String todayStr = dateFormat.format(today);
out.println("오늘 날짜 : " + todayStr);
%>
</body>
</html>