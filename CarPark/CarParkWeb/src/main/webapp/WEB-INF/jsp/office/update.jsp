<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:pagetemplate title="Update office">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/office/edit/${id}" modelAttribute="officeUpdate" cssClass="form-horizontal">

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="id" cssClass="col-sm-1 control-label">ID</form:label>
                    <div class="col-sm-4">
                    <form:input path="id" cssClass="form-control" disabled="true"/>
                    <form:errors path="id" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="name" cssClass="col-sm-1 control-label">Name:</form:label>
                    <div class="col-sm-4">
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="address" cssClass="col-sm-1 control-label">Address:</form:label>
                    <div class="col-sm-4">
                    <form:input path="address" cssClass="form-control"/>
                    <form:errors path="address" cssClass="help-block"/>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/office/list" class="btn btn-danger">Back</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Update</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>