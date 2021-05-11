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

<h1 class="text-center text-success m-3">Cập nhật lịch hẹn khám bệnh</h1>  
<c:url value="/appointment/updateAppointment/update" var="action" />
<form:form method="post"  action="${action}" modelAttribute="updateAppointment">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label for="patient"><spring:message code="ap.patient" /></label>
        <form:select id="patient" path="patient" 
                     cssClass="form-control">
            <c:forEach items="${patient}" var="pa">
                <c:if test="${Integer.parseInt(updateAppointment.patient) == pa.id}" >
                    <option value="${pa.id}">${pa.fullname}</option>
                </c:if>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="ap.content" /></label>
        <form:input cssClass="form-control" path="content" />
    </div>
    <div class="form-group">
        <label><spring:message code="ap.appointmentDate" /></label>
        <form:input cssClass="form-control" path="appointmentDate" type="date"/>
    </div>
    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-success" value="<spring:message code="updateAp.submit" />" />
    </div>
</form:form>