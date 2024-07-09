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
		<h1>Detail Page</h1>
		
		<div>
			<h3>상품명 : ${dto.productDTO.bookName}</h3>
			<h3>계좌번호 : ${dto.accountNumber}</h3>
			<h3>잔액 : ${dto.accountBalance}</h3>
			<h3>개설일 : ${dto.accountDate}</h3>
			<h3>이자율 : ${dto.productDTO.bookRate}</h3>
			
		</div>
		
				
		<a href="./transfer">이체</a>
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>