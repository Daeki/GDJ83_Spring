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
                        	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Update</span></h1>
                    	</div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="contactForm" action="update" method="post">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="userName" value="${member.userName}" id="userName" type="text" placeholder="Enter your ID..." data-sb-validations="required" />
                                        <label for="userName">ID</label>
                                        <div class="invalid-feedback" data-sb-feedback="username:required">A ID is required.</div>
                                    </div>
                                    <!-- password input --> 
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="password" value="${member.password}" id="password" type="text" placeholder="Enter your password..." data-sb-validations="required" />
                                        <label for="password">Password</label>
                                        <div class="invalid-feedback" data-sb-feedback="password:required">A password is required.</div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="name" value="${member.name}" id="name" type="text" placeholder="Enter your name..." data-sb-validations="required" />
                                        <label for="name">Full Name</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">A Name is required.</div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="email" value="${member.email}" id="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                        <label for="email">Email address</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="phone" value="${member.phone}" id="phone" type="tel" placeholder="010-456-7890" data-sb-validations="required" />
                                        <label for="phone">Phone number</label>
                                        <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                                    </div>
                                    <!-- address input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" name="address" value="${member.address}" id="message" type="text" placeholder="Enter your address here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="address">Address</label>
                                        <div class="invalid-feedback" data-sb-feedback="address:required">A address is required.</div>
                                    </div>
                                    <!-- Submit success message-->
                                    <!---->
                                    <!-- This is what your users will see when the form-->
                                    <!-- has successfully submitted-->
                                    <div class="d-none" id="submitSuccessMessage">
                                        <div class="text-center mb-3">
                                            <div class="fw-bolder">Form submission successful!</div>
                                            To activate this form, sign up at
                                            <br />
                                            <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                        </div>
                                    </div>
                                    <!-- Submit error message-->
                                    <!---->
                                    <!-- This is what your users will see when there is-->
                                    <!-- an error submitting the form-->
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Sign in</button></div>
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
	</body>
</html>