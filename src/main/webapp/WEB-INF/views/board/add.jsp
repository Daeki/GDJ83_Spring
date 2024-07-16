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
			<h1>${board} 작성</h1>
			<form method="post">
				<input type="hidden" value="${boardDTO.boardNum}" name="boardNum">
				<div class="mb-3">
					<label for="boardWriter" class="form-label">작성자</label>
					<input type="text" name="boardWriter" readonly value="${member.userName}"  class="form-control" id="boardWriter">
				</div>
				
				<div class="mb-3">
					<label for="boardTitle" class="form-label">제목</label>
					<input type="text" name="boardTitle" value="${boardDTO.boardTitle}"  class="form-control" id="boardTitle">
				</div>
				
				<div class="mb-3">
					<label for="boardContents" class="form-label">내용</label>
				  	<textarea name="boardContents" class="form-control" id="boardContents" rows="3">${boardDTO.boardContents}</textarea>
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