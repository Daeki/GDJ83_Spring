<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
	<tbody>
		<c:forEach items="${list}" var="comment">
			<tr>
				<td>${comment.boardContents}</td>
				<td>${comment.boardWriter}</td>
				<td>${comment.createDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item ${pager.pre?'':'disabled'}">
				      <a class="page-link pn" href="#?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
				    </li>
				    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				    <li class="page-item"><a class="page-link pn" href="#?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				    </c:forEach>
				    <li class="page-item ${pager.next?'':'disabled'}" >
				      <a class="page-link pn" href="#?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
				    </li>
				  </ul>
				</nav>
				<button class="pn">Test</button>