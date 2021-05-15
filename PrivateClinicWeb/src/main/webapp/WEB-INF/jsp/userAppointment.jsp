<%-- 
    Document   : userAppointment
    Created on : May 15, 2021, 1:12:02 AM
    Author     : Administrator
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<section id="inner-headline">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="pageTitle">Contact Us</h2>
            </div>
        </div>
    </div>
</section>
<section id="content">

    <div class="container">
        <div class="row"> 
            <div class="col-md-12">
                <div class="about-logo">
                    <h3>Book An Appointment Online</h3>
                </div> 
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="done">
                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        Your message has been sent. Thank you!
                    </div>
                </div>
                <div class="contact-form">

                    <form method="post" action="contact.php" id="contactform" class="contact">
                        <div class="form-group has-feedback">
                            <label for="fullname">Họ và tên*</label>
                            <input type="text" id="fullname" class="form-control" name="fullname" placeholder="Nhập họ và tên">
                            <i class="fa fa-user form-control-feedback"></i>
                        </div>
                        
                        <div class="form-group has-feedback">
                            <label for="sex">Giới tính*</label>
                            <select id="sex" name="sex" class="form-control">
                                <option value="Name">Nam</option>
                                <option value="Nữ">Nữ</option>
                            </select>
                            <i class="fas fa-venus-mars form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="address">Địa chỉ*</label>
                            <input type="text" class="form-control" id="address" name="address" placeholder="Nhập địa chỉ">
                            <i class="fas fa-map-marker-alt form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="phone">Phone*</label>
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="Nhập số điện thoại">
                            <i class="fas fa-phone-alt form-control-feedback"></i>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="content">Nội dung lịch hẹn*</label>
                            <textarea class="form-control" rows="6" name="content" placeholder="Nhập nội dung lịch hẹn"></textarea>
                            <i class="fa fa-pencil form-control-feedback"></i>
                        </div>
                         <div class="form-group has-feedback">
                            <label for="appointmentDate">Ngày hẹn khám*</label>
                            <input type="date" id="appointmentDate" class="form-control" name="appointmentDate" style="padding-right: 5px;">
                        </div>
                        <input type="submit" value="Submit" id="submit" class="submit btn btn-default">
                    </form>


                </div>
            </div>
            <div class="col-md-6">
                <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
                <div style="overflow:hidden;height:500px;width:600px;">
                    <div id="gmap_canvas" style="height:500px;width:600px;"></div>
                    <style>#gmap_canvas img{max-width:none!important;background:none!important}</style>
                    <a class="google-map-code" href="http://www.trivoo.net" id="get-map-data">trivoo</a>
                </div>
                <script type="text/javascript">
                    function init_map(){
                        var myOptions = {
                            zoom:14, 
                            center:new google.maps.LatLng(10.8164335,106.6770908), 
                            mapTypeId: google.maps.MapTypeId.ROADMAP}; 
                        map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);
                        marker = new google.maps.Marker({map: map, position: new google.maps.LatLng(10.8164335,106.6770908)}); 
                        infowindow = new google.maps.InfoWindow({content:"<b>The Breslin</b><br/>371 Nguyễn Kiệm<br/> HCM city" }); 
                        google.maps.event.addListener(marker, "click", function(){infowindow.open(map, marker); }); 
                        infowindow.open(map, marker); }google.maps.event.addDomListener(window, 'load', init_map);
                </script>
            </div>
        </div>
    </div>

</section>
