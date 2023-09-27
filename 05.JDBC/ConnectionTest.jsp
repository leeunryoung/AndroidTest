<%@ page import="common.JDBConnect" %>
<%@ page import="common.DBConnPool"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
<h2>JDBC 테스트 1 </h2>
<h2>JDBC 테스트 2 </h2>
<h2>JDBC 테스트 3</h2>
<h2>커넥션 풀 테스트 </h2>
<%
String driver=application.getInitParameter("OraacleDriver");
String url= application.getInitParameter("OracleURL");
String id= application.getInitParameter("OracleId");
String pwd=application.getInitParameter("OraaclePwd");

JDBConnect jdbc1= new JDBConnect();
jdbc1.close();

JDBConnect jdbc2= new JDBConnect(driver, url, id, pwd);
jdbc2.close();

JDBConnect jdbc3= new JDBConnect(application);
jdbc3.close();

DBConnPool pool =new DBConnPool();
pool.close();

%>
</body>
</html>




