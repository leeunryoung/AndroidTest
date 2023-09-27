<%@ page import="el.MyELClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MyELClass myClass=new MyELClass(); //객체 생성
    pageContext.setAttribute("myClass", myClass); //page 영역에 저장
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL)- 메서드 호출</title>
</head>
<body>
<h3>영역에 저장 후 메서드 호출하기</h3>
001225-3000000==>${myClass.getGender("001225-3000000"}<br/>
001225-2000000==>${myClass.getGender("001225-2000000"}
</body>
</html>