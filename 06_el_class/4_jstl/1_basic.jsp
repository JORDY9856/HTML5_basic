<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- prefix:전치사, 흐름 제어를 하고 싶어서 쓴다 if, choose, foreach, for tokens-->  
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_basic.jsp</title>
</head>
<body>

<!-- 변수 선언 -->
<c:set var='gender' value='male' />
<c:set var='age'> 15</c:set>

<!-- 제어문 -->
<c:if test="${ gender =='male'}">남성입니다</c:if>
<c:if test="${ gender eq 'female'}">여성입니다</c:if>
<c:if test="${ age >= 20}" >성인입니다</c:if><br>
<c:choose>
	<c:when test="${age lt 10 }">어린이</c:when>
	<c:when test="${age>=10 and age<20}">청소년</c:when>
	<c:otherwise>성인  </c:otherwise>
</c:choose><br>

<c:set var='sum' value='0'/>
<c:forEach var ='i' begin='1' end='100'>
	<c:set var='sum' value='${sum + i}'></c:set>
</c:forEach>
1~100까지 합: ${sum}<br>

<c:set var='oddSum' value='0' /> <!-- 반드시 선언해야 하는 것은 아님 -->
<c:set var='evenSum' value='0' />

<c:forEach var='i' begin='1' end='100'>
	<c:choose>
		<c:when test='${ i % 2 == 0 }'>
			<c:set var ="evenSum" value="${evenSum + i }"> </c:set>
		</c:when>		
		<c:otherwise>
			<c:set var ="oddSum" value="${oddSum + i }"> </c:set>
		</c:otherwise>
	</c:choose>
</c:forEach>





홀수의 합 ${oddSum}<br>
짝수의 합 ${evenSum}


</body>
</html>