<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:pagetemplate title="Offices">
    <jsp:attribute name="body">
        <h1>List of offices</h1>
        <a href="${pageContext.request.contextPath}/office/new">New</a>
        <table>
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
                        <td>
                            <a href="${pageContext.request.contextPath}/office/detail/${office.id}" class="btn btn-info btn-block">Detail</a>
                        </td>
                        <td>${office.id}</td>
                        <td><c:out value="${office.name}" /></td>
                        <td><c:out value="${office.address}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</my:pagetemplate>
