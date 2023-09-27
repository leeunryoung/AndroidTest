<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
<h2>3. 요청 헤더 정보 출력하기
</h2>
<%
Enumeration headers = request.getHeaderNames();
//모든 요청 헤더의 이름을 반환, 반환타입 Enumeration
while(headers.hasMoreElements()){
	//출력할 요청 헤더명이 더있는지 확인
	String headerName= (String)headers.nextElement();
	//헤더명이 더 있다며 요청 헤더의 이름을 얻어옴
	String headerValue= request.getHeader(headerName);
	//헤더명을 건네 헤더값을 얻어옴
	out.print("헤더명 : "+headerName+ ", 헤더값 : "+ headerValue +"<br/>");
}

%>
<p>이 파일을 직접 실행하면 referer 정보는 출력되지 않습니다.</p>
</body>
</html>