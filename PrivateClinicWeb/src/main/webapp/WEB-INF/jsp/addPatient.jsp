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

<h1 class="text-center text-success m-3">Thêm Thông Tin Bệnh Nhân</h1>  
<c:url value="/patient/addPatient/add" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addPatient">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="patient.fullname" /></label>
        <form:input cssClass="form-control" path="fullname" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.birth" /></label>
        <form:input cssClass="form-control" path="birthDate" type="date" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.sex" /></label>
        <form:input cssClass="form-control" path="sex" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.address" /></label>
        <form:input cssClass="form-control" path="address" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.phone" /></label>
        <form:input cssClass="form-control" path="phone" type="number" />
    </div>
    
    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="addPatient.submit" />" />
    </div>
</form:form>
