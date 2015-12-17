<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Reservations">
    <jsp:attribute name="body">       
        
        <a href="${pageContext.request.contextPath}/reservation/new">New</a>
        <br />
        <h1>List of reservations</h1>
        <div class="CSSTableGenerator">
            <table>
                <thead>
                    <tr>
                        <th></th>
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
                        
                        <fmt:formatDate value="${reservation.fromDate}" pattern="dd/MM/yyyy" var="resFromDate" />
                        <fmt:formatDate value="${reservation.toDate}" pattern="dd/MM/yyyy" var="resToDate" />
                        
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/reservation/detail/${reservation.id}">Detail</a></td>
                            <td>${reservation.id}</td>
                            <td><c:out value="${resFromDate}" /></td>
                            <td><c:out value="${resToDate}" /></td>
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
