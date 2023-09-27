<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <table border="1" width="90%">
    <tr>
    <td align="center">
    <% if(session.getAttribute("UserId") == null){ %>
    <a href="../06Session/LoginForm.jsp">로그인</a>
    <% } else { %>
    <a href="../06Session/Logout.jsp">로그아웃</a>
    <% } %>
    <!--  8장과 9장의 회원제 게시판  프로젝트에서 사용할 링크 -->
    &nbshp;&nbsp;&nbsp; <!-- 메뉴 사이의 공백(,spaace) 확보용 특수 문자 -->
    <a href="../08Board/List.jsp">게시판(페이징X)</a>
    &nbsp;&nbsp;&nbsp;
    <a href="../09PagingBoard/List.jsp">게시판 (페이지o)</a>
    </td>
    </tr>
    </table>
