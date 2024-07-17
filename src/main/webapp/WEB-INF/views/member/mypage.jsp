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
	<body class="d-flex flex-column">
		<!-- main태그 footer 전까지 -->
		<main class="flex-shrink-0">
			<!-- 상단 메뉴바 start -->
			<c:import url="/WEB-INF/views/template/navbar.jsp"></c:import>
			<!-- 상단 메뉴바 end -->
			

			<section class="py-5">
                <div class="container px-5">
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                        	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">My page</span></h1>
                    	</div>
                    	<div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                    	<div class="card-body p-0">
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                    <!-- Name input-->
                                    <div class="form-floating my-3">
                                        <input class="form-control" value="${member.userName}" id="userName" type="text" disabled/>
                                        <label for="userName">ID</label>
                                    </div>
                                    <!-- password input --> 
                                    <div class="form-floating mb-3">
                                        <input class="form-control" value="${member.password}" id="password" type="text" disabled/>
                                        <label for="password">Password</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="name" value="${member.name}" type="text" disabled/>
                                        <label for="name">Name</label>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="email" value="${member.email}" type="email" disabled/>
                                        <label for="email">Email address</label>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="phone" value="${member.phone}" type="tel" disabled/>
                                        <label for="phone">Phone number</label>
                                    </div>
                                    <!-- address input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" id="message" value="${member.address}" type="text" style="height: 10rem" disabled></textarea>
                                        <label for="address">Address</label>
                                    </div>
                            </div>
                        </div>
                        </div>
                        </div>
                        <div class="row gx-3 align-items-center justify-content-end">
	                        <div class="col-auto">
								<a type="submit" class="btn btn-primary" href="update?userName=${member.userName}">수정</a>
							</div>
						</div>
                    </div>
                </div>
            </section>
	
		
		</main>
		<!-- 하단 footer, js start -->
		<c:import url="/WEB-INF/views/template/footer_js.jsp"></c:import>
		<!-- 하단 footer, js end -->
	</body>
</html>