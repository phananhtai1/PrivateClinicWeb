<%-- 
    Document   : index
    Created on : May 2, 2021, 9:50:33 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section id="banner">

    <!-- Slider -->
    <div id="main-slider" class="flexslider">
        <ul class="slides">
            <li>
                <img src="<c:url value="images/slides/1.jpg" />" alt="" />
                <div class="flex-caption container">
                    <h3>Caring for Health</h3> 
                    <p>Doloribus omnis minus temporibus perferendis ipsa</p>  
                </div>
            </li>
            <li>
                <img src="<c:url value="images/slides/2.jpg" />" alt="" />
                <div class="flex-caption container">
                    <h3>Best Equipments</h3> 
                    <p>Doloribus omnis minus temporibus perferendis ipsa</p>  					
                </div>
            </li>
        </ul>
    </div>
    <!-- end slider -->

</section>
<section class="txt-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="aligncenter"><h1 class="aligncenter">We Care You</h1>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores quae porro consequatur aliquam, incidunt eius magni provident, doloribus omnis minus temporibus perferendis nesciunt quam repellendus nulla nemo ipsum odit corrupti consequuntur possimus.</div>

            </div>
        </div>
    </div>
</section>


<section id="services">


    <div class="container">
        <div class="row">
            <div class="features">
                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="0ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 0ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/1.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Child Care</h4>
                            <p>Backed by some of the biggest names in the industry, Firefox OS is an open platform that fosters greater</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="100ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 100ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/2.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Women Care</h4>
                            <p>Backed by some of the biggest names in the industry, Firefox OS is an open platform that fosters greater</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="200ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 200ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/3.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Family</h4>
                            <p>Morbi vitae tortor tempus, placerat leo et, suscipit lectus. Phasellus ut euismod massa, eu eleifend ipsum.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="300ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 300ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/4.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Heart</h4>
                            <p>Morbi vitae tortor tempus, placerat leo et, suscipit lectus. Phasellus ut euismod massa, eu eleifend ipsum.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="400ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 400ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/5.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Eye Care</h4>
                            <p>Morbi vitae tortor tempus, placerat leo et, suscipit lectus. Phasellus ut euismod massa, eu eleifend ipsum.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="500ms" style="visibility: visible; -webkit-animation-duration: 300ms; -webkit-animation-delay: 500ms;">
                    <div class="media service-box">
                        <div class="pull-left">
                            <img src="<c:url value="images/7.png" />" alt="" />
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Testing</h4>
                            <p>Morbi vitae tortor tempus, placerat leo et, suscipit lectus. Phasellus ut euismod massa, eu eleifend ipsum.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
            </div>
        </div>	 


    </div>

</section>

<section class="aboutUs">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aligncenter"><h2 class="aligncenter">Welcome!</h2>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</div>
                <br/>
            </div>
        </div> 
        <div class="row">
            <div class="col-md-6">
                <img src="<c:url value="images/img1.png" />" alt="">
                <div class="space"></div>
            </div>
            <div class="col-md-6">
                <p><h5>Lorem ipsum dolor sit amet, cadipisicing  sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium, ut unde fuga error commodi architecto, oribus omnis minus autem nemo numquam, ipsa architecto non. magni consequuntlaudantium culpa tenetur at id, beatae pet.</h5></p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. adipisicing  sit amet, consectetur adipisicing elit. Atque sed, quidem quis praesentium,m deserunt.</p>
                <ul class="list-unstyled">
                    <li><i class="fa fa-arrow-circle-right pr-10 colored"></i> Lorem ipsum enimdolor sit amet</li>
                    <li><i class="fa fa-arrow-circle-right pr-10 colored"></i> Explicabo deleniti neque aliquid</li>
                    <li><i class="fa fa-arrow-circle-right pr-10 colored"></i> Consectetur adipisicing elit</li>
                    <li><i class="fa fa-arrow-circle-right pr-10 colored"></i> Lorem ipsum dolor sit amet</li>
                    <li><i class="fa fa-arrow-circle-right pr-10 colored"></i> Quo issimos molest quibusdam temporibus</li>
                </ul>
            </div>
        </div>

    </div>
</section>
<section id="events">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aligncenter"><h2 class="aligncenter">Our Events</h2>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores quae porro consequatur aliquam, incidunt eius magni provident, doloribus omnis minus temporibus perferendis nesciunt quam repellendus nulla nemo ipsum odit corrupti consequuntur possimus.</div>
                <br>
            </div>
        </div>
        <div class="row" class="eventsLink">
            <div class="col-md-4">
                <div class="post3">
                    <img src="<c:url value="images/e1.png" />" alt="">
                    <a href="javascript:;">
                        <time datetime="2019-03-01">
                            <span class="year">2019</span>
                            <span class="month">Feb</span>
                        </time>
                        <p>Lorem ipsum dolor sit amet, consectetur adipis.</p>
                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="post3">
                    <img src="<c:url value="images/e2.png" />" alt="">
                    <a href="javascript:;">
                        <time datetime="2019-03-01">
                            <span class="year">2019</span>
                            <span class="month">March</span>
                        </time>
                        <p>Apsum dolor sit amet, consectetur adipisdslif.</p>
                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="post3">
                    <img src="<c:url value="images/e3.png" />" alt="">
                    <a href="javascript:;">
                        <time datetime="2019-03-01">
                            <span class="year">2019</span>
                            <span class="month">April</span>
                        </time>
                        <p>Dolor sit amet, consectetur adipisic indfeft</p>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section> 