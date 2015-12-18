<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="New reservation">
    <jsp:attribute name="body">
        <h1>New office</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/reservation/create"
                   modelAttribute="reservationCreate">
            
            From date:
            <div>
                <form:input path="fromDate" class="date"></form:input>
            </div>
            
            To date:
            <div>
                <form:input path="toDate" class="date"></form:input>
            </div>
            <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Create</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
