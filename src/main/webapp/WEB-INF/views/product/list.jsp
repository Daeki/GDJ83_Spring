<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
	</head>
	<body class="d-flex flex-column h-100 bg-light">
		<!-- main태그 footer 전까지 -->
		<main class="flex-shrink-0">
			<!-- 상단 메뉴바 start -->
			<c:import url="/WEB-INF/views/template/navbar.jsp"></c:import>
			<!-- 상단 메뉴바 end -->
			
			<header class="py-5">
                <div class="container px-5">
                	<div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
                    </div>
					<!-- 리스트 start -->
					<div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                    	<div class="card-body p-0">
                    		<div class="align-items-center justify-content-center">
                    			<div class="p-5">
				                    <div class="row gx-5 justify-content-center">
				                        <div class="col-lg-11 col-xl-11 col-xxl-11">
											<table class="table table-hover">
											  <thead>
											    <tr>
											      <th scope="col">번호</th>
											      <th scope="col">상품명</th>
											      <th scope="col">이자율</th>
											    </tr>
											  </thead>
											  <tbody>
											  	<c:forEach items="${list}" var="list">
												    <tr>
												      <th scope="row">${list.bookNumber}</th>
												      <td>${list.bookName}</td>
												      <td>${list.bookRate}</td>
												    </tr>
											    </c:forEach>
											  </tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 리스트 end -->
				</div>
				
				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item ${pager.pre?'':'disabled'}">
				      <a class="page-link" href="list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
				    </li>
				    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				    <li class="page-item"><a class="page-link" href="list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				    </c:forEach>
				    <li class="page-item ${pager.next?'':'disabled'}" >
				      <a class="page-link" href="list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
				    </li>
				  </ul>
				</nav>
				<div class="container">
					<form action="list" method="GET" class="row gy-2 gx-3 align-items-center justify-content-center">
						 <div class="col-auto">
						   <input type="text" class="form-control" id="search" name="search" placeholder="검색어 입력하세요.">
						 </div>
						 <div class="col-auto">
						   <select class="form-select" id="kind" name="kind">
						     <option value="k1">상품명</option>
						     <option value="k2">내용</option>
						   </select>
						 </div>
						 <div class="col-auto">
						   <button type="submit" class="btn btn-primary">검색</button>
						 </div>
					</form>
				</div>
	
		
		</main>
		<!-- 하단 footer, js start -->
		<c:import url="/WEB-INF/views/template/footer_js.jsp"></c:import>
		<!-- 하단 footer, js end -->
	</body>
</html>