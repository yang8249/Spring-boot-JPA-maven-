<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta id="_csrf" name="_csrf" th:content="${_csrf.token}"/>
  <meta id="_csrf_header" name="_csrf_header" th:content="${_csrf.headerName}"/>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="/">홈</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  <c:choose>
	  <c:when test="${empty principal}">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/auth/loginForm">로그인</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/auth/joinForm">회원가입</a>
	      </li>
	    </ul>
	  </c:when>
	  <c:otherwise>
		  <ul class="navbar-nav">
		     <li class="nav-item">
		       <a class="nav-link" href="/board/saveForm">글쓰기</a>
		     </li>
		     <li class="nav-item">
		       <a class="nav-link" href="/auth/updateForm">회원정보</a>
		     </li>
		     <li class="nav-item">
		       <a class="nav-link" href="/logout">로그아웃</a>
		     </li>
		   </ul>
	  </c:otherwise>
  </c:choose>
  </div>  
</nav>
<br/>