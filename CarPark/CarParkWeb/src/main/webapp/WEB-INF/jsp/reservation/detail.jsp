<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Reservation">
    
    <jsp:attribute name="body">
        <fmt:formatDate value="${reservation.fromDate}" pattern="dd/MM/yyyy" var="resFromDate" />
        <fmt:formatDate value="${reservation.toDate}" pattern="dd/MM/yyyy" var="resToDate" />
        <table class="table">
            <tr>
                <td class="col-md-2"><b>Id</b></td>
                <td>${reservation.id}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>From date</b></td>
                <td><c:out value="${resFromDate}" /></td>
            </tr>
            <tr>
                <td class="col-md-2"><b>To date</b></td>
                <td><c:out value="${resToDate}" /></td>
            </tr>
            <tr>
                <td class="col-md-2"><b>First name</b></td>
                <td>${reservation.employee.firstName}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Last name</b></td>
                <td>${reservation.employee.lastName}</td>
            </tr>
            <tr>
                <td class="col-md-2"> <a href="${pageContext.request.contextPath}/employee/detail/${reservation.employee.id}">See detail of employee for this reservation</a></td>
            </tr>
            
            <tr>
                <td class="col-md-2"><b>Car model</b></td>
                <td>${reservation.car.model}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Car color</b></td>
                <td>${reservation.car.color}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Car plate number</b></td>
                <td>${reservation.car.plateNumber}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Is cancelled</b></td>
                <td>${reservation.cancelled}</td>
            </tr>
            <tr>
                <td class="col-md-2"> <a href="${pageContext.request.contextPath}/car/detail/${reservation.car.id}">See detail of car for this reservation</a></td>
            </tr>
            
            <tr>
                <td><input type="button" value="Back" onclick="history.go(-1)" class="btn btn-danger"></td>
            </tr>
        </table>
    </jsp:attribute>
</my:pagetemplate>
