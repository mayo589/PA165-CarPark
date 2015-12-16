<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:pagetemplate title="Employees">
    <jsp:attribute name="body">
        <h1>List of employees</h1>
        <a href="${pageContext.request.contextPath}/employee/new">New</a>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>first name</th>
                    <th>last name</th>
                    <th>date of birth</th>
                    <th>address</th>
                    <th>telephone</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td><c:out value="${employee.firstName}" /></td>
                        <td><c:out value="${employee.lastName}" /></td>
                        <td><c:out value="${employee.dateOfBirth}" /></td>
                        <td><c:out value="${employee.address}" /></td>
                        <td><c:out value="${employee.telephone}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</my:pagetemplate>
