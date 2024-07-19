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
                    <!-- 회원가입 form start -->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                        	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Sign in</span></h1>
                    	</div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="joinForm" action="join" method="post">
                                    <!-- ID 입력-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="userName" id="userName" type="text" placeholder="Enter your ID..." data-sb-validations="required" />
                                        <label for="userName">ID</label>
                                    </div>
                                    <!-- 비밀번호 입력 --> 
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" id="password" type="text" placeholder="Enter your password..." data-sb-validations="required" />
                                        <label for="password">Password</label>
                                        <div id="password-error"></div>
                                    </div>
                                    <!-- 비밀번호 확인 --> 
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="password" id="passwordCheck" type="text" placeholder="Enter your password..." data-sb-validations="required" />
                                        <label for="password">Password 확인</label>
                                        <div id="password-eqerror"></div>
                                    </div>
                                    <!-- 이름 입력 -->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="name" id="name" type="text" placeholder="Enter your name..." data-sb-validations="required" />
                                        <label for="name">Full Name</label>
                                    </div>
                                    <!-- Email 입력-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="email" id="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                        <label for="email">Email address</label>
                                    </div>
                                    <!-- 전화번호 입력-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="phone" id="phone" type="tel" placeholder="010-456-7890" data-sb-validations="required" />
                                        <label for="phone">Phone number</label>
                                        <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                                    </div>
                                    <!-- 주소 입력 -->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control ch" name="address" id="message" type="text" placeholder="Enter your address here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="address">Address</label>
                                        <div class="invalid-feedback" data-sb-feedback="address:required">A address is required.</div>
                                    </div>
                                    <div class="d-grid mb-2">
                                        <button class="btn btn-primary btn-lg" id="add" type="button">사진파일추가</button>
                                        <div id="result"></div>
                                    </div>
                                    <!-- 회원가입 Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="btn" type="button">회원가입</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                     <!-- 회원가입 form end -->
                </div>
            </section>
	
		
		</main>
		<!-- 하단 footer, js start -->
		<c:import url="/WEB-INF/views/template/footer_js.jsp"></c:import>
		<!-- 하단 footer, js end -->
		

		<script src="/resources/js/member/memberJoinCheck.js"></script>
        <script src="/resources/js/commons/files.js"></script>
	</body>
</html>