<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - redirect</title>
</head>
<body>
<c:set var="requestVal" value="MustHave" scope="request" />
<c:redirect url="/11JSTL/inc/OtherPage.jsp">
<c:param name="user_param1" value="출판사"/>
<c:param name="user_param2" value="골드레빗"/>
</c:redirect>
</body>
</html>