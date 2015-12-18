<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="New reservation">
    <jsp:attribute name="body">
        <form:form method="post" action="${pageContext.request.contextPath}/reservation/create"
                   modelAttribute="reservationCreate" cssClass="form-horizontal">
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="fromDate" cssClass="col-sm-1 control-label">From date:</form:label>
                <div class="col-sm-4">
                    <form:input path="fromDate" class="form-control"/>
                    <form:errors path="fromDate" cssClass="help-block"/>
                </div>
            </div>
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="toDate" cssClass="col-sm-1 control-label">To date:</form:label>
                <div class="col-sm-4">
                    <form:input path="toDate" class="form-control"/>
                    <form:errors path="toDate" cssClass="help-block"/>
                </div>
            </div>
                
            <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
            <a href="${pageContext.request.contextPath}/reservation/list" class="btn btn-danger">Back</a>
            <button class="btn btn-primary" type="submit">Create reservation</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
