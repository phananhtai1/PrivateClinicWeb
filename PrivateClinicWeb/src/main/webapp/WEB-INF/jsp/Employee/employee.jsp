<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Nhân Viên</h1>

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
<a href="<c:url value="/admin/employee/addEmployee" />" class="btn btn-success">Thêm nhân viên</a>
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã nhân viên
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
        <c:forEach items="${employee}" var = "em">
            <tr id="employee${em.id}">
                <td class="text-center"> ${em.id}</td>
                <td>${em.fullname}</td>
                <td>${em.birthDate}</td>
                <td>${em.sex}</td>
                <td>${em.address}</td>
                <td>${em.phone}</td>
                <td class="text-center"> <a href="<c:url value="/admin/employee/updateEmployee" />/?employeeId=${em.id}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteEmployee(${em.id})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>

