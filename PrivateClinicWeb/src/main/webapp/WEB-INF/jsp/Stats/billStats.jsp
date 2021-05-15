<%-- 
    Document   : stats
    Created on : Apr 16, 2021, 6:49:27 PM
    Author     : duonghuuthanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">Thống Kê Doanh Thu Theo Ngày</h1>

<form>
    <div class="form-group">
        <label>Ngày bắt đầu : </label>
        <input placeholder="From date..." type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Ngày kết thúc : </label>
        <input placeholder="To date..." type="date" name="toDate" class="form-control" />
    </div>
    <div class="form-group">
        <input class="btn btn-success" type="submit" value="Tra cứu" />
    </div>
</form>
<table class="table table-striped">
    <tr class="text-center">
        <th>Ngày thống kê</th>
        <th>Số lượng bệnh nhân đến khám</th>
        <th>Tổng Tiền trong ngày</th>
    </tr>
    <c:forEach items="${statsByDate}" var="stats">
        <tr class="text-center">
            <td>${stats[0]}</td>
            <td>${stats[1]} bệnh nhân</td>
            <td>${stats[2]} VNĐ</td>
        </tr>
    </c:forEach>

</table>

<div>
    <canvas id="myChart" width="400" height="400"></canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js@3.1.0/dist/chart.min.js">

</script>
<script>
    let d = [];
    let b = [];
    <c:forEach items="${amounts}" var="c">
    d.push(${c});
    </c:forEach>
    <c:forEach items="${labelDate}" var="a">
    var x = "Ngày: ${a}";
    b.push(x);
    </c:forEach>
    console.info(d);
    console.info(b);
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: b,
            datasets: [{
                    label: 'Thông kê doanh thu theo ngày',
                    data: d,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1,
                    hoverBorderColor: '#000'
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>

