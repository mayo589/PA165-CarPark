<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<my:pagetemplate title="Add a new car">
    <jsp:attribute name="body">

        <form:form method="post" action="${pageContext.request.contextPath}/car/create" modelAttribute="carCreate" cssClass="form-horizontal" role="form" data-toggle="validator">
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="model" cssClass="col-sm-1 control-label" >Model</form:label>
                <div class="col-sm-4">
                    <form:input path="model" cssClass="form-control" required="required" placeholder="BMW M5"/>
                    <form:errors path="model" cssClass="help-block with-errors"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            <div class="form-group ${author_error?'has-error':''}">
                <form:label path="color" cssClass="col-sm-1 control-label">Color</form:label>
                <div class="col-sm-4">
                    <form:input path="color" cssClass="form-control" placeholder="Black"/>
                    <form:errors path="color" cssClass="help-block"/>
                </div>
            </div>
            <div class="form-group ${title_error?'has-error':''}">
                <form:label path="vin" cssClass="col-sm-1 control-label">Vin</form:label>
                <div class="col-sm-4">
                    <form:input path="vin" cssClass="form-control" required="required" placeholder="1GCEK29C69Z137770"/>
                     <form:errors path="model" cssClass="help-block with-errors"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            <div class="form-group ${title_error?'has-error':''}">
                <form:label path="plateNumber" cssClass="col-sm-1 control-label">Plate number</form:label>
                <div class="col-sm-4">
                    <form:input path="plateNumber" cssClass="form-control" required="required"  placeholder="5B5-1495"/>
                    <form:errors path="plateNumber" cssClass="help-block"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            <div class="form-group ${title_error?'has-error':''}">
                <form:label path="fuelCapacity" cssClass="col-sm-1 control-label">Fuel capacity</form:label>
                <div class="col-sm-4">
                <form:input path="fuelCapacity" cssClass="form-control" placeholder="75" required="required" type="number" min="0"/>
                    <form:errors path="fuelCapacity" cssClass="help-block"/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/car/list" class="btn btn-danger">Back</a>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button class="btn btn-primary" type="submit">Create car</button>
        </form:form>

    </jsp:attribute>
</my:pagetemplate>