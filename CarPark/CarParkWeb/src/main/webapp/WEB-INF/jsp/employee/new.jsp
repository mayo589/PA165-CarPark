<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New employee">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/employee/create"
                   modelAttribute="employeeCreate" cssClass="form-horizontal" role="form" data-toggle="validator">

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="firstName" cssClass="col-sm-1 control-label">First name:</form:label>
                <div class="col-sm-4">
                    <form:input path="firstName" cssClass="form-control" required="required"/>
                    <form:errors path="firstName" cssClass="help-block with-errors"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="lastName" cssClass="col-sm-1 control-label">Last name:</form:label>
                <div class="col-sm-4">
                    <form:input path="lastName" class="form-control" required="required"/>
                    <form:errors path="lastName" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="dateOfBirth" cssClass="col-sm-1 control-label">Date of birth:</form:label>
                <div class="col-sm-4">
                    <form:input path="dateOfBirth" class="form-control" data-error="Please insert date (format:dd.mm.yyyy. eg: 1.1.2014)" pattern="^(?:(?:31(\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$" required="required"/>
                    <form:errors path="dateOfBirth" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="address" cssClass="col-sm-1 control-label">Address:</form:label>
                    <div class="col-sm-4">
                    <form:input path="address" class="form-control"/>
                    <form:errors path="address" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="telephone" cssClass="col-sm-1 control-label">Telephone:</form:label>
                    <div class="col-sm-4">
                    <form:input path="telephone" class="form-control"/>
                    <form:errors path="telephone" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="admin" cssClass="col-sm-1 control-label">Admin:</form:label>
                    <div class="col-sm-4">
                    <form:checkbox path="admin" class="form-control"/>
                    <form:errors path="admin" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>    
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="passwordHash" cssClass="col-sm-1 control-label">Password:</form:label>
                    <div class="col-sm-4">
                    <form:password path="passwordHash" class="form-control" required="required"/>
                    <form:errors path="passwordHash" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/employee/list" class="btn btn-danger">Back</a>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Create</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
