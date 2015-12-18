<%@page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<my:pagetemplate>
    <jsp:attribute name="body">
        <h1>not authorized</h1>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </jsp:attribute>
</my:pagetemplate>
