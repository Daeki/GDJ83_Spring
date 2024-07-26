<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover">
	<tbody>
		<c:forEach items="${list}" var="comment" varStatus="i">
			<tr>
				<td id="con${i.index}">${comment.boardContents}</td>
				<td>${comment.boardWriter}</td>
				<td>${comment.createDate}</td>
				<td><c:if test="${comment.boardWriter eq member.userName}"><button class="btn btn-danger dels" data-del-id="${comment.boardNum}" type="button">X</button></c:if></td>
				<td><c:if test="${comment.boardWriter eq member.userName}"><button class="btn btn-primary ups" data-update-con="con${i.index}" data-del-id="${comment.boardNum}" data-bs-toggle="modal" data-bs-target="#commentModal">수정</button></c:if></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

				<nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item ${pager.pre?'':'disabled'}">
				      <a class="page-link pn" data-page-num="${pager.startNum-1}" href="#">Previous</a>
				    </li>
				    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i">
				    <li class="page-item"><a class="page-link pn" data-page-num="${i}" href="#">${i}</a></li>
				    </c:forEach>
				    <li class="page-item ${pager.next?'':'disabled'}" >
				      <a class="page-link pn" data-page-num="${pager.lastNum+1}" href="#">Next</a>
				    </li>
				  </ul>
				</nav>
