<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Bệnh Nhân</h1>

<form class="mb-5">
    <div class="row">
        <div class="col-md-10 form-group">
            <input type="text" 
                   name="kw"
                   class="form-control" 
                   placeholder="Nhập từ khoá để tìm..." />
        </div>
        <div class="col-md-2">
            <input type="submit" 
                   class="btn btn-primary"
                   value="Tìm kiếm" />
        </div>
    </div>
</form>
<a href="<c:url value="/patient/addPatient" />" class="btn btn-success">Thêm bệnh nhân</a>
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã bệnh nhân
            </th>
            <th class="text-center">
                Họ và Tên
            </th>
            <th class="text-center">
                Ngày sinh
            </th>
            <th class="text-center">
                Giới tính
            </th>
            <th class="text-center">
                Địa chỉ
            </th>
            <th class="text-center">
                Số điện thoại
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${patient}" var = "pa">
            <tr id="patient${pa.id}">
                <td class="text-center"> ${pa.id}</td>
                <td>${pa.fullname}</td>
                <td>${pa.birthDate}</td>
                <td>${pa.sex}</td>
                <td>${pa.address}</td>
                <td>${pa.phone}</td>
                <td class="text-center"> <a href="<c:url value="/patient/updatePatient" />/?patientId=${pa.id}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deletePatient(${pa.id})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>

