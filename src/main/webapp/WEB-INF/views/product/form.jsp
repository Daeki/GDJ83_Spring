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
	                        	<c:if test="${dto eq null}">
	                        		${board} 추가
	                        	</c:if>
	                        	<c:if test="${dto ne null}">
	                        		${board} 수정
	                        	</c:if>
                        	</span></h1>
                    	</div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form method="post">
	                                    <!-- 제목 입력-->
	                                    <div class="form-floating mb-3">
	                                        <input class="form-control" value="${dto.bookName}" name="bookName" id="bookName" type="text"/>
	                                        <label for="bookName">상품명</label>
	                                    </div>
	                                    <!-- 이자율 입력-->
	                                    <div class="form-floating mb-3">
	                                        <input class="form-control" value="${dto.bookRate}" name="bookRate" id="bookRate" type="text"/>
	                                        <label for="bookRate">이자율</label>
	                                    </div>
	                                    <!-- 설명 입력 --> 
	                                   	<div class="form-floating mb-3">
	                                        <textarea class="form-control" name="bookDetail" id="bookDetail" type="text" style="height: 10rem">${dto.bookDetail}</textarea>
	                                        <label for="bookDetails">설명</label>
	                                    </div>
                                    
                                    <div class="row py-2 align-items-center justify-content-end">
                                     	<div class="col-auto">
                                    		<button type="button" id="add" class="btn btn-outline-primary">
												<h6 class="display-10 fw-bolder mb-0">
												파일 추가
												</h6>
											</button>
										</div>
									</div>
									
									<div id="result"></div>
                                    <!-- Submit Button-->
                                    <div class="row py-2 align-items-center justify-content-end">
                                     	<div class="col-auto">
                                    		<button type="submit" class="btn btn-outline-primary">
												<h6 class="display-10 fw-bolder mb-0">
													<c:if test="${dto eq null}">
													등록
													</c:if>
													<c:if test="${dto ne null}">
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

		<script src="/resources/js/commons/files.js"></script>
		<script type="text/javascript">
			setMax(5)
		</script>
	</body>
</html>