<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New office">
    <jsp:attribute name="body">
        
        <form:form method="post" action="${pageContext.request.contextPath}/office/create"
                   modelAttribute="officeCreate" cssClass="form-horizontal" role="form" data-toggle="validator">
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="name" cssClass="col-sm-1 control-label">Name:</form:label>
                <div class="col-sm-4">
                    <form:input path="name" class="form-control" required="required" />
                    <form:errors path="name" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
            
            <div class="form-group ${isbn_error?'has-error':''}">
                <form:label path="address" cssClass="col-sm-1 control-label">Address:</form:label>
                <div class="col-sm-4">
                    <form:input path="address" class="form-control" required="required" />
                    <form:errors path="address" cssClass="help-block"/>
                    
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <span class="help-block with-errors"></span>
                </div>
            </div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <a href="${pageContext.request.contextPath}/office/list" class="btn btn-danger">Back</a>
            <button class="btn btn-primary" type="submit">Create office</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
