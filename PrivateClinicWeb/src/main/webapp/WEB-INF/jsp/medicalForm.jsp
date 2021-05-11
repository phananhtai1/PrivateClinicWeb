<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Phiếu Khám Bệnh</h1>
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
<a href="<c:url value="/medicalForm/addMedicalForm" />" class="btn btn-success">Lập phiếu khám bệnh</a>
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr style="font-size: 13px;">
            <th class="text-center">
                Mã phiếu khám
            </th>
            <th class="text-center">
                Họ và tên bệnh nhân
            </th>
            <th class="text-center">
                Họ và tên nhân viên
            </th>
            <th class="text-center">
                Triệu chứng
            </th>
            <th class="text-center">
                Chuẩn đoán
            </th>
            <th class="text-center">
                Ngày khám bệnh
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${medicalForm}" var = "mf">
            <tr id="medicalForm${mf[0]}">
                <td class="text-center">${mf[0]}</td>
                <td>${mf[1]}</td>
                <td>${mf[2]}</td>
                <td>${mf[3]}</td>
                <td>${mf[4]}</td>
                <td>${mf[5]}</td>
                <td class="text-center"> <a href="<c:url value="/medicalForm/updateMedicalForm" />/?medicalFormId=${mf[0]}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteEmployee(${em.id})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>

