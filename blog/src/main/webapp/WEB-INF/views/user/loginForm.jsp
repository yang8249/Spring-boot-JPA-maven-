<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	  <form action="/action_page.php" class="was-validated">
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox" name="remember" required>
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>