

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success p-3">ĐĂNG KÝ</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<c:url value="/admin/register" var="action" />
<form:form action="${action}" modelAttribute="user" method="post" >
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
        <label for="usernameId">
            <spring:message code="user.username" />
        </label>
        <form:input path="username" id="usernameId" cssClass="form-control" />
        <form:errors path="username" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            <spring:message code="user.password" />
        </label>
        <form:input id="passwordId" path="password" 
                    cssClass="form-control" type="password" />
        <form:errors path="password" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="confirmPasswordId">
            <spring:message code="user.confirmPassword" />
        </label>
        <form:input id="confirmPasswordId" path="confirmPassword" 
                    cssClass="form-control" type="password" />
        <form:errors path="confirmPassword" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="employee">Chọn nhân viên cho tài khoản:</label>
        <form:select id="employee" path="employee" cssClass="form-control">
            <c:forEach items="${employee}" var="em">
                <option value="${em.id}">${em.fullname}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng ký" class="btn btn-danger pull-right" />
    </div>
</form:form>