<%-- 
    Document   : medicine
    Created on : May 6, 2021, 9:44:41 PM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center mt-3 mb-5 text-success">Thông Tin Hóa Đơn</h1>
<div class="row">
    <div class="col-md-12">
        <nav>
            <div class="nav nav-tabs">
                <a href="#tab-content-1" class="nav-item nav-link active" data-toggle="tab">Thông tin bênh nhân</a>
                <a href="#tab-content-2" class="nav-item nav-link" data-toggle="tab">Thông tin phiếu khám</a>
                <a href="#tab-content-3" class="nav-item nav-link" data-toggle="tab">Toa thuốc</a>
                <a href="#tab-content-4" class="nav-item nav-link" data-toggle="tab">Hóa đơn</a>
            </div>
        </nav>
        <!-- Noi dung -->
        <div class="tab-content my-4">
            <div class="tab-pane fade show active" id="tab-content-1">
                <table class="table table-striped table-bordered">
                    <tbody>
                        <c:forEach items="${infoPatient}" var="pa">
                            <tr>
                                <th><spring:message code="patient.fullname" /></th>
                                <td>${pa[1]}</td>

                            </tr>
                            <tr>
                                <th><spring:message code="patient.birth" /></th>
                                <td>${pa[2]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="patient.sex" /></th>
                                <td>${pa[3]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="patient.phone" /></th>
                                <td>${pa[5]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="patient.address" /></th>
                                <td>${pa[4]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>        
            </div>
            <div class="tab-pane fade show" id="tab-content-2">
                <table class="table table-striped table-bordered">
                    <tbody>
                        <c:forEach items="${infoPatient}" var="pa">
                            <tr>
                                <th><spring:message code="mf.employee" /></th>
                                <td>${pa[10]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="mf.symptom" /></th>
                                <td>${pa[7]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="mf.diagnostic" /></th>
                                <td>${pa[8]}</td>
                            </tr>
                            <tr>
                                <th><spring:message code="mf.examinationDate" /></th>
                                <td>${pa[9]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade show" id="tab-content-3">
                <table class="table table-striped table-bordered">
                    <thead>
                        <th><spring:message code="pr.medicine" /></th>
                        <th><spring:message code="medicine.unit" /></th>
                        <th><spring:message code="pr.quantity" /></th>
                        <th><spring:message code="pr.usage" /></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${infoPrescription}" var="pres">
                            <tr>
                                <td>${pres[0]}</td>
                                <td>${pres[4]}</td>
                                <td>${pres[2]}</td>
                                <td>${pres[3]}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade show" id="tab-content-4">
                <table class="table table-striped table-bordered">
                    <tbody>
                        <c:forEach items="${infoBill}" var="bill">
                            <tr>
                                <th><spring:message code="bill.charge" /></th>
                                <td>${bill[2]} VNĐ</td>
                            </tr>
                            <tr>
                                <th><spring:message code="bill.medicineCost" /></th>
                                <td>${bill[3]} VNĐ</td>
                            </tr>
                            <tr>
                                <th><spring:message code="bill.totalAmount" /></th>
                                <td>${bill[4]} VNĐ</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/main.js" />"></script>
