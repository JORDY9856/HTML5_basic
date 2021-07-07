<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	//삭제할글번호를넘겨받기
	
	String message_Id= request.getParameter("message_Id");//listMessage.jsp에서 링크의 글번호

 %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 방명록 삭제 </title>
</head>
<body>
	메세지를 삭제하려면 암호를 입력하세요. <br/><br/>
	<form action="deleteConfirm.jsp" method="post">
	 	<input type='hidden' name='message_Id' value='<%=message_Id%>' />
		암호 : <input type="password" name="password" />
		<input type="submit" value="메세지 삭제"/>
	</form>
</body>
</html>