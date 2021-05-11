<%-- 
    Document   : addmedi
    Created on : May 6, 2021, 10:12:13 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Thêm Thuốc Mới</h1>  
<c:url value="/medicine/addMedi/add" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addmedi">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="addmedi.name" /></label>
        <form:input cssClass="form-control" path="name" />
    </div>
    <div class="form-group">
        <label><spring:message code="addmedi.unit" /></label>
        <form:input cssClass="form-control" path="unit" />
    </div>
    <div class="form-group">
        <label><spring:message code="addmedi.price" /></label>
        <form:input cssClass="form-control" path="price" />
    </div>
    <div class="form-group">
        <label><spring:message code="addmedi.manufacturingDate" /></label>
        <form:input type="date" cssClass="form-control" path="manufacturingDate" />
    </div>
    <div class="form-group">
        <label><spring:message code="addmedi.expiryDate" /></label>
        <form:input type="date" cssClass="form-control" path="expiryDate" />
    </div>
    
    <div>
        <%--<form:hidden path="id" />--%>
        <input type="submit" class="btn btn-success" value="<spring:message code="addmedi.submit" />" />
    </div>
</form:form>
