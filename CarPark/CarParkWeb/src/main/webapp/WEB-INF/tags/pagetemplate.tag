<%@tag pageEncoding="utf-8" dynamic-attributes="dynattrs" %>
<%@attribute name="title" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" required="true" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title><c:out value="${title}" /></title>
        
        <jsp:invoke fragment="head" />
    </head>
    
    <body>
        
        <ul>
            <li><a href="${pageContext.request.contextPath}/office/list">Offices</a></li>
            <li><a href="${pageContext.request.contextPath}/employee/list">Employees</a></li>
            <li><a href="${pageContext.request.contextPath}/reservation/list">Reservations</a></li>
        </ul>
        
        <jsp:invoke fragment="body" />
    </body>
</html>