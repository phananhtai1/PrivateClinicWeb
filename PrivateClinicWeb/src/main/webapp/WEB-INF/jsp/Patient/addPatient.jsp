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
<c:url value="/admin/patient/addPatient" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addPatient">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="patient.fullname" /></label>
        <form:input cssClass="form-control" path="fullname"  placeholder="Nhập họ và tên"  />
        <form:errors path="fullname" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.birth" /></label>
        <form:input cssClass="form-control" path="birthDate" type="date" />
        <form:errors path="birthDate" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.sex" /></label>
        <form:select path="sex" id="sex" cssClass="form-control">
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="patient.address" /></label>
        <form:input cssClass="form-control" path="address" placeholder="Nhập địa chỉ" />
        <form:errors path="address" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="patient.phone" /></label>
        <form:input cssClass="form-control" path="phone" type="number" placeholder="Nhập số điện thoại" />
        <form:errors path="phone" cssClass="text-danger" />
    </div>
    
    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="addPatient.submit" />" />
    </div>
</form:form>
