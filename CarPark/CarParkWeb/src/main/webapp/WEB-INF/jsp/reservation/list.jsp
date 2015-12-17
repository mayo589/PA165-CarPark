<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Reservations">
    <jsp:attribute name="body">
        <h1>List of reservations</h1>
        <div class="CSSTableGenerator">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>From date</th>
                        <th>To date</th>
                        <th>Employee name</th>
                        <th>Car informations</th>
                        <th>Cancelled</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${reservations}" var="reservation">
                        <tr>
                            <td>${reservation.id}</td>
                            <td><c:out value="${reservation.fromDate}" /></td>
                            <td><c:out value="${reservation.toDate}" /></td>
                            <td><c:out value="${reservation.employee.firstName}" /> &nbsp; <c:out value="${reservation.employee.lastName}" /></td>
                            <td><c:out value="${reservation.car.model}" /> &nbsp; <c:out value="${reservation.car.plateNumber}" /></td>
                            <td><c:out value="${reservation.cancelled}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:attribute>
</my:pagetemplate>
