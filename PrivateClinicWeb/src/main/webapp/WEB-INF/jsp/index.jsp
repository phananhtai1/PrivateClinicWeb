<%-- 
    Document   : index
    Created on : May 2, 2021, 9:50:33 PM
    Author     : Administrator
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1 style="color: red">${message}</h1>
        
        <ul>
            <c:forEach items="${medicines}" var="medi">
                <li>${medi.id} - ${medi.name} - ${medi.unit} - ${medi.price}</li>
            </c:forEach>
        </ul>
    </body>
</html>
