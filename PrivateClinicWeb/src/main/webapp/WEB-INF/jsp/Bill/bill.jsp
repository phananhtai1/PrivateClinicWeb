<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1 class="text-center mt-3 mb-5">Danh Sách Hóa Đơn</h1>
<form>
    <div class="form-group">
        <input placeholder="From date..." type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <input placeholder="To date..." type="date" name="toDate" class="form-control" />
    </div>
    <div class="form-group text-right">
        <input class="btn btn-primary" type="submit" value="Tra cuu" />
    </div>
</form>
<table border="1" class = "table table-striped table-responsive-md mt-3">
    <thead>
        <tr>
            <th class="text-center">
                Mã hóa đơn
            </th>
            <th class="text-center">
                Mã phiếu khám
            </th>
            <th class="text-center">
                Tên bệnh nhân
            </th>
            <th class="text-center">
                Phí khám bệnh
            </th>
            <th class="text-center">
                Phí thuốc
            </th>
            <th class="text-center">
                Tổng tiền
            </th>
            <th class="text-center">
                Ngày khám
            </th>
            <th class="text-center">
                Thao tác
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${bills}" var = "bill">
            <tr id="bill${bill[0]}">
                <td class="text-center"> ${bill[0]}</td>
                <td>${bill[1]}</td>
                <td>${bill[2]}</td>
                <td>${bill[3]} VNĐ</td>
                <td>${bill[4]} VNĐ</td>
                <td>${bill[5]} VNĐ</td>
                <td>${bill[6]}</td>
                <td class="text-center"> <a href="<c:url value="/admin/bill/billDetail" />/?billId=${bill[0]}&mfId=${bill[1]}"  class="btn btn-primary">Chi tiết</a>
                    <a href="javascript:;" class="btn btn-danger" onclick="deleteBill(${ap[0]})">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
