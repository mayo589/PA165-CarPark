<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New employee">
    <jsp:attribute name="body">
        <h1>New employee</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/employee/create"
                   modelAttribute="employeeCreate">
            <div>
                <form:label path="firstName">First name:</form:label>
                <form:input path="firstName" />
            </div>
            <div>
                <form:label path="lastName">Last name:</form:label>
                <form:input path="lastName" />
            </div>
            <div>
                <form:label path="dateOfBirth">Date of birth:</form:label>
                <form:input path="dateOfBirth" />
            </div>
            <div>
                <form:label path="address">Address:</form:label>
                <form:input path="address" />
            </div>
            <div>
                <form:label path="telephone">Telephone:</form:label>
                <form:input path="telephone" />
            </div>
            <div>
                <form:label path="admin">Admin:</form:label>
                <form:checkbox path="admin" />
            </div>
            <div>
                <form:label path="passwordHash">Password:</form:label>
                <form:input path="passwordHash" />
            </div>
            
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">Create</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
