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
			<form method="post">
				<input type="hidden" name="bookNumber" value="${dto.bookNumber}">
				<div class="mb-3">
					<label for="bookName" class="form-label">상품명</label>
					<input type="text" name="bookName" value="${dto.bookName}" class="form-control" id="bookName">
				</div>
				<div class="mb-3">
					<label for="bookRate" class="form-label">이자율</label>
					<input type="text" name="bookRate" value="${dto.bookRate}" class="form-control" id="bookRate">
				</div>				
				<div class="mb-3">
					<label for="bookDetail" class="form-label">상품설명</label>
				  	<textarea name="bookDetail" class="form-control" id="bookDetail" rows="3">${dto.bookDetail}</textarea>
				</div>
				
				<div class="mb-3">
					<button class="btn btn-primary">등록</button>
				</div>
				
			</form>	
		</div>
	
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>