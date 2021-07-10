<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title> 데이타 받는 페이지 </title>
</head>
<body>

파라메터 값(전 페이지에서 넘어오는 값) : ${param.data} <br/> 

<!-- String data = request.getParameter("data");-->



<!--  object login = session.getAttribute("login");  
		String myId = (String)obj; 	getter로 얻어오는 자료형은 object -->

세션의 값 : ${sessionScope.login}<br/> <!-- 세션의 값을 가져오는 형식 -->


쿠키의 값 :	${cookie.isFlag.value } <br/> <!--쿠키는 value달라고 지정을 해줘야함  -->


<hr>


</body>
</html>