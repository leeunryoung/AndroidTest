<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그로 폼값 한번에 받기</title>
</head>
<body><h2>액션 태그로 폼값 한 번에 받기</h2>
<from method="post" action="UseBeanAction.jsp">
이름 : <input type="text" name="name" /><br/>
나이 : <input type="text" name="age" /><br/>
<input type="submit" value="폼값 전송"/>
</from>
</body>
</html>