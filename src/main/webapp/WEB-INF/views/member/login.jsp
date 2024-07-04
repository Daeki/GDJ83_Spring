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
			<form method="post">
				<div class="mb-3">
    	            <label for="userName" class="form-label">ID</label>
                    <input type="text" class="form-control" value="${id}" id="userName" name="userName">
                </div>
                <div class="mb-3">
                     <label for="password" class="form-label">PASSWORD</label>
                     <input type="password" class="form-control" id="password" name="password">
                 </div>
                 
                 <div class="mb-3 form-check">
				    <input type="checkbox" name="remember" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">ID기억하기</label>
				 </div>

	                           
		 		<div class="mb-3">
					<button class="btn btn-primary">로그인</button>
				</div>
				
			</form>	
		</div>
	
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>