<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<my:pagetemplate title="Offices">
    <jsp:attribute name="body">
        
        <div class="panel panel-default">
        <div class="panel-heading">List of offices</div>
        <table class="table">
            <thead>
                <tr>
                    <th></th>
                    <th>id</th>
                    <th>name</th>
                    <th>address</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${offices}" var="office">
                    <tr>
                        <td class="col-md-1">
                            <a class="btn btn-sm btn-default" href="${pageContext.request.contextPath}/office/detail/${office.id}">Detail</a>
                        </td>
                        <td class="col-md-2">${office.id}</td>
                        <td class="col-md-2"><c:out value="${office.name}" /></td>
                        <td class="col-md-2"><c:out value="${office.address}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="form-group row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/office/new" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        Add a new office
                    </a>
                </div>
            </div>
        </sec:authorize>
    </jsp:attribute>
</my:pagetemplate>
