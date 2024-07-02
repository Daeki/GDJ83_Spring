<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

<div class="container-fluid mt-5">
	<div class="row justify-content-center">
		<div class="col-md-6">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>상품명</th>
						<th>이자율</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.bookNumber}</td>
							<td><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
							<td>${dto.bookRate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>