<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberAuth.jsp</title>
</head>
<body>
<h2>MVC 패턴으로 회원인증하기</h2>
<p><Strong> ${authMessage}</Strong>
<br/><a href="./MembeerAuth.mvc?id=nakja&pass=1234">회원인증(관리자)</a>
&nbsp;&nbsp;
<a href="./MembeerAuth.mvc?id=musthave&pass=1234">회원인증(회원)</a>
&nbsp;&nbsp;
<a href="./MembeerAuth.mvc?id=stranger&pass=1234">회원인증(비회원)</a>
</p>

</body>
</html>