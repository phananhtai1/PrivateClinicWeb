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
<c:url value="/admin/medicine/addMedi" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addmedi">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />

    <div class="form-group">
        <label><spring:message code="medicine.name" /></label>
        <form:input cssClass="form-control" path="name" placeholder="Nhập tên thuốc" />
        <form:errors path="name" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.unit" /></label>
        <form:select cssClass="form-control" path="unit" id="unit">
            <option value="Hộp">Hộp</option>
            <option value="Chai">Chai</option>
            <option value="Vỉ">Vỉ</option>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.price" /></label>
        <form:input cssClass="form-control" path="price" placeholder="Nhập giá thuốc"  />
        <form:errors path="price" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="manufacturingDateId"><spring:message code="medicine.manufacturingDate" /></label>
        <form:input type="date" cssClass="form-control" id="manufacturingDateId" path="manufacturingDate"/>
        <form:errors path="manufacturingDate" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="expiryDateId"><spring:message code="medicine.expiryDate" /></label>
        <form:input type="date" cssClass="form-control" id="expiryDateId" path="expiryDate"/>
        <form:errors path="expiryDate" cssClass="text-danger" />
    </div>

    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="addmedi.submit" />" />
    </div>
</form:form>
