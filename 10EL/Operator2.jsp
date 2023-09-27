<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("num1", 9);
pageContext.setAttribute("num2", "10");

pageContext.setAttribute("nullStr",null);
pageContext.setAttribute("emptyStr","");
pageContext.setAttribute("lengthZero",new Integer[0]);
pageContext.setAttribute("sizeZero",new ArrayList());		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL) - 연산자</title>
</head>
<body>
<h3>empty 연산자</h3>
empty nullStr : ${ empty nullStr }<br/>
empty emptyStr : ${ empty emptyStr }<br/>
empty lengthZero : ${ empty lengthZero }<br/>
empty sizeZero : $ {empty sizeZero}

<h3>삼항 연산자</h3>
nul1 +10  : ${null +10 }<br/>
nullStr +10 : ${null +10 }<br/>
param.noVar>10 : ${param.noVar>10}
</body>
</html>