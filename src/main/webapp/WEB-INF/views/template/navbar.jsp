<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navigation = 상단 메뉴-->
<nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
	<div class="container px-5">
		<a class="navbar-brand" href="/"><span class="fw-bolder text-primary">Bank</span></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
				<li class="nav-item"><a class="nav-link" href="/">HOME</a></li>
                <li class="nav-item"><a class="nav-link" href="/notice/list">Notice</a></li>
                <li class="nav-item"><a class="nav-link" href="/product/list">Product</a></li>
                <li class="nav-item"><a class="nav-link" href="/qna/list">QnA</a></li>
                <c:choose>
                	<c:when test="${member ne null}">
                		<li class="nav-item"><a class="nav-link" href="/member/mypage">My page</a></li>
		                <li class="nav-item"><a class="nav-link" href="/member/logout">Sign out</a></li>
                	</c:when>
                	<c:otherwise>
		                <li class="nav-item"><a class="nav-link" href="/member/join">Sign in</a></li>
		                <li class="nav-item"><a class="nav-link" href="/member/login">Sign up</a></li>
                	</c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>