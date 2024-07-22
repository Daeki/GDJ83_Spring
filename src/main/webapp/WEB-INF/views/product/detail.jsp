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
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board} DETAIL</span></h1>
                    </div>
					<!-- 리스트 start -->
					<div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                    	<div class="card-body p-0">
                    	<c:if test="${member ne null}">
                    		<div class="row px-2 py-2 align-items-center justify-content-end">
		                        <div class="col-auto">
									<a class="btn btn-outline-primary" href="update?bookNumber=${dto.bookNumber}">
										<h6 class="display-10 fw-bolder mb-0">글수정</h1>
									</a>
								</div>
							</div>
						</c:if>
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
												   <tr>
												     <th scope="row">${dto.bookNumber}</th>
												     <td>${dto.bookName}</td>
												     <td>${dto.bookRate}</td>
												   </tr>
												   
											  </tbody>
											  <table>
											  	<colgroup>
											  		<col width="100%" />
											  	</colgroup>
											  	<tr>
											    <th>내용</th>
											    </tr>
											    <tr>
											    <br>
											  	<td>${dto.bookDetail}</td>
												</tr>
											  </table>
											</table>
											<div>
												<c:forEach items="${dto.fileDTOs}" var="f">
													<a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
												
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 리스트 end -->
				</div>
	
		
		</main>
		<!-- 하단 footer, js start -->
		<c:import url="/WEB-INF/views/template/footer_js.jsp"></c:import>
		<!-- 하단 footer, js end -->
	</body>
</html>