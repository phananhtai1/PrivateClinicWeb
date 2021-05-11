<%-- 
    Document   : header
    Created on : Apr 7, 2021, 1:05:26 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row bg-info sticky-top">
    <div class="col-md-8">
        <nav class="navbar navbar-expand-sm ">
            <ul class="navbar-nav">

                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/" />">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/medicine" />">Thuốc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/patient" />">Bệnh nhân</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/medicalForm" />">Phiếu Khám</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/employee" />">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/appointment" />">Lịch hẹn</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/prescription" />">Toa thuốc</a>

                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/bill" />">Hóa đơn</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/" />"></a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-md-4 text-center">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <div style="padding: 8px">
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/login" />">
                        Đăng nhập
                    </a>
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/register" />">
                        Đăng ký
                    </a> 
                </div>

            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <a class="nav-link text-white d-inline-block" href="#">
                    ${pageContext.request.userPrincipal.name}
                </a>
                <a class="nav-link text-white d-inline-block" href="<c:url value="/logout" />">
                    Đăng xuất
                </a>
            </c:when>
        </c:choose>
    </div>
</div>



