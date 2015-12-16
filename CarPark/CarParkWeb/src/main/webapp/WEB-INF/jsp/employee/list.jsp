<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:pagetemplate title="Employees">
    <jsp:attribute name="body">
        <h1>List of employees</h1>
        employees size: ${employeesSize}
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td><c:out value="${employee.firstName}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</my:pagetemplate>
