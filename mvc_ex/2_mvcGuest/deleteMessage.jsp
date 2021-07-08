<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message_Id = request.getParameter("message_Id");	
	System.out.print("asdf");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 삭제 </title>
</head>
<body>
	메세지를 삭제하려면 암호를 입력하세요. <br/><br/>
	<form action="GuestControl?cmd=delete-do" method="post">
		<input type="hidden" name="message_Id" value="<%=message_Id%>"/>
		암호 : <input type="password" name="password" />
		<input type="submit" value="메세지 삭제"/>
	</form>
</body>
</html>