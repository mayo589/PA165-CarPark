<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New employee">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/employee/create"
                   modelAttribute="employeeCreate" cssClass="form-horizontal">

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="firstName" cssClass="col-sm-1 control-label">First name:</form:label>
                    <div class="col-sm-4">
                    <form:input path="firstName" class="form-control"/>
                    <form:errors path="firstName" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="lastName" cssClass="col-sm-1 control-label">Last name:</form:label>
                    <div class="col-sm-4">
                    <form:input path="lastName" class="form-control"/>
                    <form:errors path="lastName" cssClass="help-block"/>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="dateOfBirth" cssClass="col-sm-1 control-label">Date of birth:</form:label>
                    <div class="col-sm-4">
                    <form:input path="dateOfBirth" class="form-control"/>
                    <form:errors path="dateOfBirth" cssClass="help-block"/>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="address" cssClass="col-sm-1 control-label">Address:</form:label>
                    <div class="col-sm-4">
                    <form:input path="address" class="form-control"/>
                    <form:errors path="address" cssClass="help-block"/>
                </div>
            </div>
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="telephone" cssClass="col-sm-1 control-label">Telephone:</form:label>
                    <div class="col-sm-4">
                    <form:input path="telephone" class="form-control"/>
                    <form:errors path="telephone" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="admin" cssClass="col-sm-1 control-label">Admin:</form:label>
                    <div class="col-sm-4">
                    <form:checkbox path="admin" class="form-control"/>
                    <form:errors path="admin" cssClass="help-block"/>
                </div>
            </div>    
                
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="passwordHash" cssClass="col-sm-1 control-label">Password:</form:label>
                    <div class="col-sm-4">
                    <form:password path="passwordHash" class="form-control"/>
                    <form:errors path="passwordHash" cssClass="help-block"/>
                </div>
            </div>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Create</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
