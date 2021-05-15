<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Thuốc</h1>

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
<a href="<c:url value="/admin/medicine/addMedi" />" class="btn btn-success">Thêm thuốc mới</a> 
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã thuốc
            </th>
            <th class="text-center">
                Tên thuốc
            </th>
            <th class="text-center">
                Đơn vị
            </th>
            <th class="text-center">
                Giá
            </th>
            <th class="text-center">
                Ngày sản xuất
            </th>
            <th class="text-center">
                Hạn sử dụng
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${medicine}" var = "medi">
            <tr id="medicine${medi.id}">
                <td class="text-center"> ${medi.id}</td>
                <td>${medi.name}</td>
                <td>${medi.unit}</td>
                <td>${medi.price} VNĐ</td>
                <td>${medi.manufacturingDate}</td>
                <td>${medi.expiryDate}</td>
                <td class="text-center"> <a href="<c:url value="/admin/medicine/updateMedi" />/?mediId=${medi.id}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteMedicine(${medi.id})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
