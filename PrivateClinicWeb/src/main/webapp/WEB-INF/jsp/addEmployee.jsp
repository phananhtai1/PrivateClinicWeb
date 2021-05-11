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

<h1 class="text-center text-success m-3">Thêm Thông Tin Nhân Viên</h1>  
<c:url value="/employee/addEmployee/add" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addEmployee">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="employee.fullname" /></label>
        <form:input cssClass="form-control" path="fullname" />
    </div>
    <div class="form-group">
        <label><spring:message code="employee.birth" /></label>
        <form:input cssClass="form-control" path="birthDate" type="date" />
    </div>
    <div class="form-group">
        <label><spring:message code="employee.sex" /></label>
        <form:input cssClass="form-control" path="sex" />
    </div>
    <div class="form-group">
        <label><spring:message code="employee.address" /></label>
        <form:input cssClass="form-control" path="address" />
    </div>
    <div class="form-group">
        <label><spring:message code="employee.phone" /></label>
        <form:input cssClass="form-control" path="phone" type="number" />
    </div>
    
    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="addEmployee.submit" />" />
    </div>
</form:form>
