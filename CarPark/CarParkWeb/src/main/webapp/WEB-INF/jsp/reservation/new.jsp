<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="New reservation">
    <jsp:attribute name="body">
        
        <form:form method="post" action="${pageContext.request.contextPath}/reservation/create"
                   modelAttribute="reservationCreate" cssClass="form-horizontal" role="form" data-toggle="validator">
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="fromDate" cssClass="col-sm-1 control-label">From date:</form:label>
                <div class="col-sm-4">
                    <form:input path="fromDate" class="form-control"  required="required" data-error="Please insert date (format:dd.mm.yyyy. eg: 1.1.2014)" pattern="^(?:(?:31(\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"/>
                    <form:errors path="fromDate" cssClass="help-block"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="toDate" cssClass="col-sm-1 control-label">To date:</form:label>
                <div class="col-sm-4">
                    <form:input path="toDate" class="form-control" required="required" data-error="Please insert date (format:dd.mm.yyyy. eg: 1.1.2014)" pattern="^(?:(?:31(\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"/>
                    <form:errors path="toDate" cssClass="help-block"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="carid" cssClass="col-sm-1 control-label">Car:</form:label>
                <div class="col-sm-4">   
                    <form:select id="carid" path="carid" name="carid" class="form-control" required="required">
                         <form:options items="${availableCars}" itemValue="id" itemLabel="model"/>
                    </form:select>
                </div>
            </div>
                
           <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="officeid" cssClass="col-sm-1 control-label">Office:</form:label>
                <div class="col-sm-4">   
                    <form:select id="officeid" path="officeid" name="officeid" class="form-control" required="required">
                         <form:options items="${offices}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="employeeid" cssClass="col-sm-1 control-label">Employee:</form:label>
                <div class="col-sm-4">   
                    <form:select id="employeeid" path="employeeid" name="employeeid" class="form-control" required="required">
                         <form:options items="${employees}" itemValue="id" itemLabel="lastName"/>
                    </form:select>
                </div>
            </div>
                
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
            <a href="${pageContext.request.contextPath}/reservation/list" class="btn btn-danger">Back</a>
            <button class="btn btn-primary" type="submit">Create reservation</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
