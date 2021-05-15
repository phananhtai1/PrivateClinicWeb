<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h1 class="text-center mt-3 mb-5">Danh Sách Toa Thuốc</h1>
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã toa thuốc
            </th>
            <th class="text-center">
                Mã phiếu khám
            </th>
            <th class="text-center">
                Tên thuốc
            </th>
            <th class="text-center">
                Số lượng
            </th>
            <th class="text-center">
                Cách dùng
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${prescription}" var = "pr">
            <tr id="prescription${pr[0]}">
                <td class="text-center"> ${pr[0]}</td>
                <td class="text-center">${pr[1]}</td>
                <td>${pr[2]}</td>
                <td class="text-center">${pr[3]}</td>
                <td>${pr[4]}</td>
                <td class="text-center"> 
                    <a href="<c:url value="/admin/prescription/updatePrescription" />/?mediId=${pr[0]}"  class="btn btn-primary">Cập Nhật</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deletePrescription(${pr[0]})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>

