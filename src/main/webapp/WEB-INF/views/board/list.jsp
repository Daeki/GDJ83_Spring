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
			<h1>${board}</h1>
			<!-- 검색어 입력 폼 -->
			<form action="./list" method="get" class="row row-cols-lg-auto g-3 align-items-center">
			  
			  <div class="col-12">
			    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			    <select name="kind" class="form-select" id="inlineFormSelectPref">
			      <option value="title" >제목</option>
			      <option value="contents">내용</option>
			      <option value="writer">작성자</option>
			    </select>
			  </div>
			  
			  <div class="col-12">
			    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
			    <div class="input-group">      
			      <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
			    </div>
			  </div>
			
			
			  
			
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">Submit</button>
			  </div>
			</form>			
		
		
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.boardNum}</td>
							<td>
							<a href="./detail?boardNum=${dto.boardNum}">
							<c:catch>
							<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
							</c:catch>
							${dto.boardTitle}
							</a>
							</td>
							<td>${dto.boardWriter}</td>
							<td>${dto.createDate}</td>
							<td>${dto.boardHit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			  
			    <li class="page-item ${pager.pre?'':'disabled'}">
			      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			  
			    <!-- for(int i=0;i<=10;i=i+2) -->
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
			    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			    </c:forEach>
			    
			    <li class="page-item ${pager.next?'':'disabled'}">
			      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<div class="row">
				<div >
					<a href="./add" class="btn btn-danger">글등록</a>
				</div>
			</div>
		</div>
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>