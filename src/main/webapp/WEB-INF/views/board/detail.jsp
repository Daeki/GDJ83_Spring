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
			<h1>${board} Detail</h1>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>수정일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${boardDTO.boardNum}</td>
						<td>${boardDTO.boardTitle}</td>
						<td>${boardDTO.boardWriter}</td>
						<td>${boardDTO.createDate}</td>
						<td>${boardDTO.updateDate}</td>
						<td>${boardDTO.boardHit}</td>
					</tr>
					
					<tr>
						<td colspan="6">${boardDTO.boardContents}</td>
					</tr>
				</tbody>
			</table>
			<div class="row">
				<div >
					<c:if test="${board ne 'Notice'}">
					<a href="./reply?boardNum=${boardDTO.boardNum}" class="btn btn-info">답글</a>
					</c:if>
					<c:if test="${boardDTO.boardWriter eq member.userName}">
					<a href="./update?boardNum=${boardDTO.boardNum}" class="btn btn-danger">수정</a>
					<a href="./delete?boardNum=${boardDTO.boardNum}" class="btn btn-primary">삭제</a>
					</c:if>
				</div>
			</div>
		</div>
	
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>