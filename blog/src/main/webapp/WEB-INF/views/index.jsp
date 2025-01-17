<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">
  <div class="card m-2">
    <div class="card-body">
      <h4 class="card-title">제목 부분</h4>
      <p class="card-text">내용 부분</p>
      <a href="#" class="btn btn-primary">상세보기</a>
    </div>
  </div>
  <br>
</div>

<%@ include file="layout/footer.jsp" %>