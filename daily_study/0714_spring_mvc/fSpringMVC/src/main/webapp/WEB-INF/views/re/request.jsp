<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

request.do 요청에 의한 페이지<hr/>

사용자 입력값 memberVO<hr/>
아이디: ${memberVO.id}
이름:${memberVO.name }
나이:${memberVO.age} 
<br>
<br>

<hr/>
사용자 입력값 param<hr/><!--param도 되지만, 명확하게 주는것이 훨신 좋다  -->
아이디: ${param.id}
이름:${param.name }
나이:${param.age}
<br>
<br>


<hr/>
사용자 입력값 vo<hr/>
아이디: ${vo.id}
이름:${vo.name }
나이:${vo.age} 



</body>
</html>