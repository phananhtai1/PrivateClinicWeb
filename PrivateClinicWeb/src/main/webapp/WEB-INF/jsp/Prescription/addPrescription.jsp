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
<h1 class="text-center text-success m-3">Tạo Toa Thuốc</h1>
<c:forEach items="${infoPatient}" var="info">
    <h3 class="text-info my-4">Thông tin bệnh nhân</h3>
    <div class="row mb-4">
        <div class="col-md-4 mb-3"><b><spring:message code="patient.fullname" /></b> <span>${info[1]}</span> </div>
        <div class="col-md-4"><b><spring:message code="patient.birth" /></b> <span>${info[2]}</span> </div>
        <div class="col-md-4"><b><spring:message code="patient.sex" /></b> <span>${info[3]}</span> </div>
        <div class="col-md-4"><b><spring:message code="patient.phone" /></b> <span>${info[5]}</span> </div>
        <div class="col-md-8"><b><spring:message code="patient.address" /></b> <span>${info[4]}</span> </div>
    </div>
    <h3 class="text-info my-4">Thông tin phiếu khám bệnh</h3>
    <div class="row">
        <div class="col-md-12 mb-3"><b><spring:message code="mf.symptom" /></b> <span>${info[7]}</span> </div>
        <div class="col-md-12 mb-3"><b><spring:message code="mf.diagnostic" /></b> <span>${info[8]}</span> </div>
        <div class="col-md-12 mb-3"><b><spring:message code="mf.examinationDate" /></b> <span>${info[9]}</span> </div>
    </div>
</c:forEach>
<h3 class="text-info my-4">Thiết lập toa thuốc cho bệnh nhân</h3>
<c:url value="/admin/prescription/addPrescription/?medicalForm=${param.medicalFormId}" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addPrescription">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
    <div class="form-group">
        <label for="medicine"><spring:message code="pr.medicine" /></label>
        <form:select id="medicine" path="medicine" 
                     cssClass="form-control">
            <c:forEach items="${medicine}" var="me">
                <option value="${me.id}">${me.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="pr.quantity" /></label>
        <form:input type="number" cssClass="form-control" id="quantity" path="quantity" min="1" />
    </div>
    <div class="form-group">
        <label><spring:message code="pr.usage" /></label>
        <form:select cssClass="form-control" id="usage" path="usage">
            <option value="Trước khi ăn 15 phút">Trước khi ăn 15 phút</option>
            <option value="Trước khi ăn 30 phút">Trước khi ăn 30 phút</option>
            <option value="Sau khi ăn 15 phút">Sau khi ăn 15 phút</option>
            <option value="Sau khi ăn 30 phút">Sau khi ăn 30 phút</option>
        </form:select>
    </div>
    <div class="text-right">
        <form:hidden path="medicalForm" value="${param.medicalFormId}"/>
        <input type="submit" class="btn btn-success" value="<spring:message code="addPr.submit"/>" />
    </div>
</form:form>