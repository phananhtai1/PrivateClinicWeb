<%-- 
    Document   : base
    Created on : Apr 7, 2021, 1:07:08 PM
    Author     : HP
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="tiles"
          uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>
        <tiles:insertAttribute name="title" />
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- css -->
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" />
    <link href="<c:url value="/css/fancybox/jquery.fancybox.css"/>" rel="stylesheet"> 
    <link href="<c:url value="/css/flexslider.css"/>" rel="stylesheet" /> 
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" />

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>
<body>
    <div id="wrapper" class="home-page">
        <!-- header -->
        <tiles:insertAttribute name="header" />

        <!-- content -->

        <tiles:insertAttribute name="content" />

        <!-- footer -->
        <tiles:insertAttribute name="footer" />
    </div>
    <a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
    <!-- javascript
        ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="js/jquery.js" />"></script>
    <script src="<c:url value="js/jquery.easing.1.3.js" />"></script>
    <script src="<c:url value="js/bootstrap.min.js" />"></script>
    <script src="<c:url value="js/jquery.fancybox.pack.js" />"></script>
    <script src="<c:url value="js/jquery.fancybox-media.js" />"></script> 
    <script src="<c:url value="js/portfolio/jquery.quicksand.js" />"></script>
    <script src="<c:url value="js/portfolio/setting.js" />"></script>
    <script src="<c:url value="js/jquery.flexslider.js" />"></script>
    <script src="<c:url value="js/animate.js" />"></script>
    <script src="<c:url value="js/custom.js" />"></script> 
</body>
</html>
