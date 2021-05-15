<%-- 
    Document   : updateMedi
    Created on : May 6, 2021, 10:41:18 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Cập Nhật Thuốc</h1>  

<c:url value="/admin/medicine/updateMedi" var="action" />
<form:form method="post"  action="${action}" modelAttribute="updateMedi">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />

    <div class="form-group">
        <label><spring:message code="medicine.name" /></label>
        <form:input cssClass="form-control" path="name" />
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.unit" /></label>
        <form:select path="unit" cssClass="form-control">
            <option value="Hộp">Hộp</option>
            <option value="Chai">Chai</option>
            <option value="Vỉ">Vỉ</option>
        </form:select>
        <%--<form:input cssClass="form-control" path="unit" />--%>
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.price" /></label>
        <form:input cssClass="form-control" path="price" />
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.manufacturingDate" /></label>
        <form:input type="date" cssClass="form-control" path="manufacturingDate" />
    </div>
    <div class="form-group">
        <label><spring:message code="medicine.expiryDate" /></label>
        <form:input type="date" cssClass="form-control" path="expiryDate" />
    </div>

    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-success" value="<spring:message code="updatemedi.submit" />" />
    </div>
</form:form>
