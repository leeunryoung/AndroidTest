<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
<script type="text/javascript">
function validateForm(form){
	alert("작성자를 입력하세요.");
	form.name.focus();
	return false;
}
if (form.title.value==""){
	alert("제목을 입력하세요");
	form.title.focus();
	return false;
}
if(form.content.value==""){
	alert("내용을 입력하세요.");
	form.content.focus();
	return false;
}
}
</script>
</head>
<style>
body {
font-size:12px;
font-family: 맑은고딕;
color:#00000c;
}
table{
width:400px;
border:1px solid #555555;
border-collapse:collapse;
/*테이블과 셀사이에 공간 없애기*/
}
th,td{
padding:5px;
border:1px solid #555555;
}
.button_area{
width:400px;
margin-top:10px;
text-align:center;
 }
 
</style>
<script>
function fn_save(){
	//현화면, 폼이름, 입력상자이름.value
	if(document.frm.deptno.value==""){
	alert("부서번호를 입력하세요.);
		document.frm.deptno.focus();//커서이동
	return false;//function 종료
}
function fn_save(){
		//현화면, 폼이름, 입력상자이름.value
	if(document.frm.dname.value==""){
	alert("부서이름을 입력하세요.);
		  document.frm.dname.focus();//커서이동
	return false;//function 종료
	}
	
if (form.title.value==""){
	alert("제목을 입력하세요");
	form.title.focus();
	return false;
}
if(form.content.value==""){
	alert("내용을 입력하세요.");
	form.content.focus();
	return false;
}
}
</script>
<body>
<form name="frm" method="post" action="/150925_add/deptWriteSave.do">
<table>
<h2>파일 첨부형 게시판-수정하기(Edit)</h2>
<form name="writeFrm" method="post" enctype="multipart/form-data"
	action="../mvcboard/deit.do" onsubmit="return validateForm(this);">
	<input type="hidden" name="idx" value="${dto.idx}" /> <input
		type="hidden" name="prevOfile" value="${dto.ofile }" /> <input
		type="hidden" name="prevSfile" value="${dto.sfile }" />

	<table border="1" width="90%">
<tr>
	<td>부서번호</td>
	<td>
	<input type="text" name="name"
			style="width:150px;"value="${dto.name }"/>
	</td>
</tr>
<tr>
	   <td>부서이름</td>
	    <td>
	    <input type="text" name="title"
	         style="width:90%; "value="${dto.title }"/>
    	</td>
	</tr>
	<tr>
	 <td>부서위치</td>
	 <td>
		<textarea name="content" style="width:90%;height:100PX;">${dto.
		content } </textarea></td>
	</tr>
	<tr><td> 첨부 파일</td>
	<td><input type="file" name="ofile" />
	</td></tr>
	<tr><td colspan="2" align="center">
	
	<div class="butten_area">
	<button type="submit">저장<tton>
	<button type="reset">취소button>
	<button type="button" onclick="location.href=../mvcboard/list.do';">
	목록 바로가기
	</button></div>
	</td>
	</tr>
</table>
</form>
</body>
</html>


//컨트롤파일에 입력 //
@RequestMapping(value="/deptWriteSave.do")
public String deptWriteSave(String deptno, String dname, String loc){
System.out.println("deptno:"+ deptno);
System.out.println("dname:"+ dname);
System.out.println("loc:"+ loc);
reture "";
}

//service 파일 입력//

public interface EgovSampleService{
*부서정보 저장처리*
String insertDept(DeptVo vo) throws Exception;

* 글을 등록한다 *

// ServiceImpl.java//]

@Override
public String insertDept(DeptVo vo) throws Exception{
return  Sample.insertDept(vo);

/**Dao.java **/
public String insertDept(DeptVo vo) throws Exception {
return(string)insert("sampleDao.insertDept">

**Sql.xml(리소스아래에)

<insert id="samloeDAD.insertDept">
insert into dept(deptno,dname, loc)
values(#deptno#, #dname#,#loc#)
//#-->변수의미
</insert>//xml file

-->controller 수정

sampleService.insertDept"(vo);
return "";
























