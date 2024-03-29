<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<my:pagetemplate title="Cars">
    <jsp:attribute name="body">
           
        <div class="panel panel-default">
            <div class="panel-heading">All cars in CarPark</div>
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Model</th>
                        <th>Color</th>
                        <th>Vin</th>
                        <th>Fuel Capacity</th>
                        <th>Plate Number</th>
                        <th>Available</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <td class="col-md-1">
                                <a href="${pageContext.request.contextPath}/car/detail/${car.id}" class="btn btn-sm btn-default">Detail</a>
                            </td>
                            <td class="col-md-2"><c:out value="${car.model}"/></td>
                            <td class="col-md-2"><c:out value="${car.color}"/></td>
                            <td class="col-md-2"><c:out value="${car.vin}"/></td>
                            <td class="col-md-2"><c:out value="${car.fuelCapacity}"/></td>
                            <td class="col-md-2"><c:out value="${car.plateNumber}"/></td>
                            <td class="col-md-2">
                                <c:choose>
                                    <c:when test="${empty car.isAvailable || car.isAvailable}">
                                        Available
                                    </c:when>
                                    <c:otherwise>
                                        Reserved
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <td class="col-md-1 col-lg-1">
                                    <a href="${pageContext.request.contextPath}/car/update/${car.id}" class="btn btn-sm btn-warning">Update</a>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="form-group row">
                <div class="col-md-2">
                    <a href="${pageContext.request.contextPath}/car/new" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        Add a new car
                    </a>
                </div>
            </div>
        </sec:authorize>
    </jsp:attribute>
</my:pagetemplate>
