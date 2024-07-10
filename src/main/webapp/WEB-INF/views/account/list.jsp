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
			<div>
				<a href="list?accountNumber=${param.accountNumber}&order=1">과거순으로</a>			
				<a href="list?accountNumber=${param.accountNumber}&order=0">최신순으로</a>
				<a href="list?accountNumber=${param.accountNumber}&io=0">입금만</a>
				<a href="list?accountNumber=${param.accountNumber}&io=1">출금만</a>
				<a href="list?accountNumber=${param.accountNumber}">입금/출금</a>
			</div>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>거래일</th>
						<th>구분</th>
						<th>금액</th>
						<th>잔액</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.tradeDate}</td>
							<td class="${dto.tradeIO=='0'?'text-primary':'text-danger'}">
								<c:choose>
									<c:when test="${dto.tradeIO=='0'}">입금</c:when>
									<c:otherwise>출금</c:otherwise>
								</c:choose>
							</td>
							<td class="${dto.tradeIO=='0'?'text-primary':'text-danger'}">${dto.tradeAmount}</td>
							<td>${dto.tradeBalance}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	
</div>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>