<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<button class="btn btn-secondary" onclick="history.back()" >돌아가기</button>
	<br></br>
	<div>
		글 번호 : <span id="boardId"><i>${board.id}</i></span>
		작성자 : <span id="boardUserName"><i>${board.user.username}</i></span>
	</div>
	  <div class="form-group">
		<h2>${board.title}</h2>
	  </div>
	  <hr/>
	  <div class="form-group">
		  <div>
		  	${board.content}
		  </div>
	  </div>
	  <hr/>
	  <br></br>
	  <c:if test="${board.user.id == principal.user.id}">
		<button class="btn btn-warning"><a href="/board/${board.id}/updateForm">수정</a></button>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>
</div>
    
<script type="text/javascript" src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>