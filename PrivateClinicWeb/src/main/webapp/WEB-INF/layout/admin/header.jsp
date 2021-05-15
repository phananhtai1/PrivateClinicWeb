<%-- 
    Document   : header
    Created on : Apr 7, 2021, 1:05:26 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row bg-info sticky-top mb-3">
    <div class="col-md-9">
        <nav class="navbar navbar-expand-sm ">
            <ul class="navbar-nav">

                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/admin" />">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/admin/medicine" />">Thuốc</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/admin/patient" />">Bệnh nhân</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/admin/medicalForm" />">Phiếu Khám</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/admin/employee" />">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/admin/appointment" />">Lịch hẹn</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/admin/prescription" />">Toa thuốc</a>

                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/admin/bill" />">Hóa đơn</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="javascript;:" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Thống kê
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="<c:url value="/admin/billStats" />">Doanh thu theo ngày</a>
                        <a class="dropdown-item" href="<c:url value="/admin/billStatsMonth" />">Doanh thu theo tháng</a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
    <div class="col-md-3 text-center">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <div style="padding: 8px">
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/admin/login" />">
                        Đăng nhập
                    </a>
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/admin/register" />">
                        Đăng ký
                    </a> 
                </div>

            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <a class="nav-link text-white d-inline-block py-3" href="#">
                    ${pageContext.request.userPrincipal.name}
                </a>
                <a class="nav-link text-white d-inline-block" href="<c:url value="/logout" />">
                    Đăng xuất
                </a>
            </c:when>
        </c:choose>
    </div>
</div>



