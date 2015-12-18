<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:pagetemplate title="Update employee">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/employee/edit/${id}" modelAttribute="employeeUpdate" cssClass="form-horizontal">

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="id" cssClass="col-sm-1 control-label">ID</form:label>
                    <div class="col-sm-4">
                    <form:input path="id" cssClass="form-control" disabled="true"/>
                    <form:errors path="id" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="firstName" cssClass="col-sm-1 control-label">First name:</form:label>
                    <div class="col-sm-4">
                    <form:input path="firstName" cssClass="form-control"/>
                    <form:errors path="firstName" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="lastName" cssClass="col-sm-1 control-label">Last name:</form:label>
                    <div class="col-sm-4">
                    <form:input path="lastName" cssClass="form-control"/>
                    <form:errors path="lastName" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="dateOfBirth" cssClass="col-sm-1 control-label">Date of birth:</form:label>
                    <div class="col-sm-4">
                    <form:input path="dateOfBirth" cssClass="form-control"/>
                    <form:errors path="dateOfBirth" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="address" cssClass="col-sm-1 control-label">Address:</form:label>
                    <div class="col-sm-4">
                    <form:input path="address" cssClass="form-control"/>
                    <form:errors path="address" cssClass="help-block"/>
                </div>
            </div>


            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="telephone" cssClass="col-sm-1 control-label">Telephone:</form:label>
                    <div class="col-sm-4">
                    <form:input path="telephone" cssClass="form-control"/>
                    <form:errors path="telephone" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="admin" cssClass="col-sm-1 control-label">Admin:</form:label>
                    <div class="col-sm-4">
                    <form:checkbox path="admin" cssClass="form-control"/>
                    <form:errors path="admin" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="passwordHash" cssClass="col-sm-1 control-label">Password:</form:label>
                    <div class="col-sm-4">
                    <form:password dir="" showPassword="false" path="passwordHash" cssClass="form-control" />
                    <form:errors path="passwordHash" cssClass="help-block"/>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/employee/list" class="btn btn-danger">Back</a>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Update</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>