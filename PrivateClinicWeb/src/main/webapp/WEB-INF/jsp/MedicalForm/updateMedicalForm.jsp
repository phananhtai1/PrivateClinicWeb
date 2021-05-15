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

<h1 class="text-center text-success m-3">Lập phiếu khám bệnh</h1>  
<c:url value="/admin/medicalForm/updateMedicalForm" var="action" />
<form:form method="post"  action="${action}" modelAttribute="updateMedicalForm">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />

    <div class="form-group">
        <label for="patient"><spring:message code="mf.patient" /></label>
        <form:select id="patient" path="patient" 
                     cssClass="form-control">
            <c:forEach items="${patient}" var="pa">
                <c:if test="${Integer.parseInt(updateMedicalForm.patient) == pa.id}" >
                    <option value="${pa.id}">${pa.fullname}</option>
                </c:if>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label for="employee"><spring:message code="mf.employee" /></label>
        <form:select id="employee" path="employee" 
                     cssClass="form-control">
            <c:forEach items="${employee}" var="em">
                <option value="${em.id}">${em.fullname}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="mf.symptom" /></label>
        <form:input cssClass="form-control" path="symptom" />
    </div>
    <div class="form-group">
        <label><spring:message code="mf.diagnostic" /></label>
        <form:input cssClass="form-control" path="diagnostic" />
    </div>
    <div class="form-group">
        <label><spring:message code="mf.examinationDate" /></label>
        <form:input cssClass="form-control" path="examinationDate" type="date"/>
    </div>
    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-success" value="<spring:message code="updateMf.submit" />" />
    </div>
</form:form>
