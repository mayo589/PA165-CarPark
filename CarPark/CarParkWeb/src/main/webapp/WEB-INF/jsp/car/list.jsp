<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Cars">
    <jsp:attribute name="body">

        <div class="form-group row">
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/car/new" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                Add a new car
                </a>
            </div>
        </div>

        <table class="table table-hover table-condensed fixed">
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
                        <a href="${pageContext.request.contextPath}/car/detail/${car.id}" class="btn btn-info btn-block">Detail</a>
                    </td>
                    <td class="col-md-2"><c:out value="${car.model}"/></td>
                    <td class="col-md-2"><c:out value="${car.color}"/></td>
                    <td class="col-md-2"><c:out value="${car.vin}"/></td>
                    <td class="col-md-2"><c:out value="${car.fuelCapacity}"/></td>
                    <td class="col-md-2"><c:out value="${car.plateNumber}"/></td>
                    <td class="col-md-2">
                        <form method="post" action="${pageContext.request.contextPath}/car/availabilityOfCar/${car.id}">
                            <c:choose>
                                <c:when test="${empty param.available || param.available}">
                                    Available
                                </c:when>
                                <c:otherwise>
                                    Reserved
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </td>
                    <td class="col-md-1 col-lg-1">
                        Delete btn TODO
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </jsp:attribute>
</my:pagetemplate>