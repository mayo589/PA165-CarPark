<%-- 
    Document   : accessDenied
    Created on : Dec 17, 2015, 6:30:22 PM
    Author     : jen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>not authorized</h1>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </body>
</html>
