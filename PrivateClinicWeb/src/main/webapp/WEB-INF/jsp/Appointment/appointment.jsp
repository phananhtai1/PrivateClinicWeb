<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Lịch Hẹn</h1>
<form>
    <div class="form-group">
        <label>Ngày bắt đầu:</label>
        <input placeholder="From date..." type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Ngày kết thúc:</label>
        <input placeholder="To date..." type="date" name="toDate" class="form-control" />
    </div>
    <div class="form-group text-right">
        <input class="btn btn-primary" type="submit" value="Tra cuu" />
    </div>
</form>
<a href="<c:url value="/admin/appointment/addAppointment" />" class="btn btn-success">Đặt lịch hẹn</a> 
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã lịch hẹn
            </th>
            <th class="text-center">
                Tên bệnh nhân đặt lịch
            </th>
            <th class="text-center">
                Nội dung
            </th>
            <th class="text-center">
                Ngày hẹn
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${appointment}" var = "ap">
            <tr id="appointment${ap[0]}">
                <td class="text-center"> ${ap[0]}</td>
                <td>${ap[1]}</td>
                <td>${ap[2]}</td>
                <td>${ap[3]}</td>
                <td class="text-center"> <a href="<c:url value="/admin/appointment/updateAppointment" />/?appointmentId=${ap[0]}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteAppointment(${ap[0]})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
