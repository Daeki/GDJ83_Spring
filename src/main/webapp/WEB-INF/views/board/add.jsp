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
                        	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">
	                        	<c:if test="${boardDTO eq null}">
	                        		${board} 글작성
	                        	</c:if>
	                        	<c:if test="${boardDTO ne null}">
	                        		${board} 글수정
	                        	</c:if>
                        	</span></h1>
                    	</div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="contactForm" method="post" enctype="multipart/form-data" data-sb-form-api-token="API_TOKEN">
                                	<input type="hidden" value="${member.userName}" name="boardWriter">
	                                    <!-- 제목 입력-->
	                                    <div class="form-floating mb-3">
	                                        <input class="form-control" value="${boardDTO.boardTitle}" name="boardTitle" id="boardTitle" type="text"/>
	                                        <label for="boardTitle">제목</label>
	                                    </div>
	                                    <!-- 내용 입력 --> 
	                                   	<div class="form-floating mb-3">
	                                        <textarea class="form-control" name="boardContents" id="boardContents" type="text" style="height: 10rem">${boardDTO.boardContents}</textarea>
	                                        <label for="boardContents">내용</label>
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
                                    
                                    <div>
                                    	<button type="button" class="btn btn-outline-primary" id="add">첨부파일추가</button>
                                    	<div id="result"></div>
                                    </div>
                                    
                                    <!-- Submit Button-->
                                    <div class="row py-2 align-items-center justify-content-end">
                                     	<div class="col-auto">
                                    		<button type="submit" class="btn btn-outline-primary">
												<h6 class="display-10 fw-bolder mb-0">
													<c:if test="${boardDTO eq null}">
													등록
													</c:if>
													<c:if test="${boardDTO ne null}">
													수정
													</c:if>
													</h1>
											</button>
                                    	</div>
								  	</div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
	
		
		</main>
		<!-- 하단 footer, js start -->
		<c:import url="/WEB-INF/views/template/footer_js.jsp"></c:import>
		<!-- 하단 footer, js end -->
		<script type="text/javascript" src="/resources/js/commons/files.js"></script>
		<script type="text/javascript">
			setMax(5);
		</script>
	</body>
</html>