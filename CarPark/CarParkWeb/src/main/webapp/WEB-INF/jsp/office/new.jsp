<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="New office">
    <jsp:attribute name="body">
        <h1>New office</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/office/create"
                   modelAttribute="officeCreate">
            <div>
                <form:label path="name">Name:</form:label>
                <form:input path="name" />
            </div>
            <div>
                <form:label path="address">Address:</form:label>
                <form:input path="address" />
            </div>
            <button type="submit">Create</button>
        </form:form>
    </jsp:attribute>
</my:pagetemplate>
