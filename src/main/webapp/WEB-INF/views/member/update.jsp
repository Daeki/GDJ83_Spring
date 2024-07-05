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
    	             <label for="name" class="form-label">NAME</label>
                     <input type="text" class="form-control" value="${member.name}" id="name" name="name">
                 </div>

                 <div class="mb-3">
	                 <label for="phone" class="form-label">PHONE</label>
                     <input type="text" class="form-control" id="phone" value="${member.phone}" name="phone">
                 </div>

                 <div class="mb-3">
                     <label for="email" class="form-label">EMAIL</label>
                     <input type="email" class="form-control" id="email" value="${member.email}" name="email">
                 </div>

                 <div class="mb-3">
                     <label for="address" class="form-label">Address</label>
                     <input type="text" class="form-control" id="address" value="${member.address}" name="address">
                 </div>
                 
		 		<div class="mb-3">
					<button class="btn btn-primary">회원수정</button>
				</div>
				
			</form>	
		</div>
	
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>