<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="info" class="info.beans.InfoBean">
	<jsp:setProperty name="info" property="name" />
  <jsp:setProperty name="info" property="id" />
</jsp:useBean>

<!DOCTYPE html>
<HTML>
<HEAD><TITLE> 자료 출력 </TITLE></HEAD>
<BODY>
	<H2>  당신의 신상명세서 확인 </H2>
	
	<!-- <%= info.getName()%>
	<jsp:getProperty property = "name" name="info" />-->
	
	이   름  : ${info.name}<br/> <!--jsp 표현 방식  -->
	
	주민번호 : ${info.id}<br/>
	
	성  별   : ${info.gender}<br/>  <!-- info 안에 들어있는 getGender함수를 부르는것, 
									info.Getgender와 같다 -->
	
	맞습니까????
</BODY>
</HTML>