<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Employees">
    <jsp:attribute name="body">
        
        <div class="panel panel-default">
        <div class="panel-heading">List of employees</div>
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Date of birth</th>
                    <th>Address</th>
                    <th>Telephone</th>
                    <th>Admin</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    
                    <fmt:formatDate value="${employee.dateOfBirth}" pattern="dd/MM/yyyy" var="empBirthDate" />
                    
                    <tr>
                        <td class="col-md-1">
                                <a href="${pageContext.request.contextPath}/employee/detail/${employee.id}" class="btn btn-sm btn-default">Detail</a>
                        </td>
                        <td class="col-md-2"><c:out value="${employee.firstName}" /></td>
                        <td class="col-md-2"><c:out value="${employee.lastName}" /></td>
                        <td class="col-md-2"><c:out value="${empBirthDate}" /></td>
                        <td class="col-md-2"><c:out value="${employee.address}" /></td>
                        <td class="col-md-2"><c:out value="${employee.telephone}" /></td>
                        <td class="col-md-2"><c:out value="${employee.admin}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        
        <div class="form-group row">
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/employee/new" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    Add a new employee
                </a>
            </div>
        </div>
    </jsp:attribute>
</my:pagetemplate>
