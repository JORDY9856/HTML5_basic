<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th bgcolor="orange" width="600" colspan='3'>사진첩</th>


		</tr>
		<c:set var="i">0</c:set>
		<c:forEach items="${boardList }" var="board">
			
			<!-- 프라퍼티이름 변경 -->
			<c:if test="${i%3 eq 0 }">
				<tr>
			</c:if>


			<!-- 추가 -->
			<td><c:choose>
					<c:when test="${board.b_fsize==0}">첨부파일 없음</c:when>
					<c:otherwise>
						<a href="getBoard.do?b_id=${board.b_id }"> 
							<img src="resources/upload/${board.b_fname}" height="200" width="300">
						</a>
					</c:otherwise>
			     </c:choose>
				
			</td>
				
			<c:if test="${i%3 eq 2 }">
				</tr>
			</c:if>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>
</body>
</html>