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
			<form action="transfer" method="post">
				<input type="hidden" value="${param.accountNumber}" name="accountNumber">
				<div class="mb-3">
    	            <label for="recevieNumber" class="form-label">받는 계좌번호</label>
                    <input type="text" class="form-control" value="" id="receiveNumber" name="receiveNumber">
                </div>
                <div class="mb-3">
                     <label for="accountAmount" class="form-label">이체금액</label>
                     <input type="text" class="form-control" id="accountAmount" name="tradeAmount">
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