<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 표현언어의 기본객체</title>
</head>
<body>

<%

	session.setAttribute("login", "당신의아이디"); //세션 저장
//session 어차피 jsp가 자바로 변환되기 때문에 기본 변수를 쓸 수 있다
	

Cookie c = new Cookie("isFlag","true");//쿠키 저장.
	response.addCookie(c);				//쿠키는 그냥 자바 스크립트나 jsp쓰자
	
%>

	데이타 보냈습니다. <br/>
	
	<a href ="Second.jsp?data=important"> 다음 페이지 </a>
	
</body>
</html>