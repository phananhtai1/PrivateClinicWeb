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

<h1 class="text-center text-success m-3">Đặt lịch hẹn khám bệnh</h1>  
<c:url value="/admin/appointment/addAppointment" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addAppointment">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label for="patient"><spring:message code="ap.patient" /></label>
        <form:select id="patient" path="patient" 
                     cssClass="form-control">
            <c:forEach items="${patient}" var="pa">
                <option value="${pa.id}">${pa.fullname}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <label><spring:message code="ap.content" /></label>
        <form:input cssClass="form-control" path="content" placeholder="Nội dung lịch hẹn"/>
        <form:errors path="content" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="ap.appointmentDate" /></label>
        <form:input cssClass="form-control" path="appointmentDate" type="date"/>
        <form:errors path="appointmentDate" cssClass="text-danger" />
    </div>
    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="addAp.submit" />" />
    </div>
</form:form>
