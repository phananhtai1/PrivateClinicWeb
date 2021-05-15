<%-- 
    Document   : header
    Created on : Apr 7, 2021, 1:05:26 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    <div class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/"/>"><img src="<c:url value="/images/logo.png" />" alt="logo"/></a>
            </div>
            <div class="navbar-collapse collapse ">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">Home</a></li> 
                    <li><a href="<c:url value="/" />">About Us</a></li>
                    <li><a href="<c:url value="/" />">Services</a></li>
                    <li><a href="<c:url value="/" />">Portfolio</a></li>
                    <li><a href="<c:url value="/" />">Pricing</a></li>
                    <li><a href="<c:url value="/appointment" />">Appointment</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>



