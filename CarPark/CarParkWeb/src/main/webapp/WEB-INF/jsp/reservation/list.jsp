<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<my:pagetemplate title="Reservations">
    <jsp:attribute name="body">       
        
        <div class="panel panel-default">
        <div class="panel-heading">List of reservations</div>
            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                        <th>Id</th>>
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
                            <td class="col-md-1">
                                <a href="${pageContext.request.contextPath}/reservation/detail/${reservation.id}" class="btn btn-sm btn-default">Detail</a>
                            </td>
                            <td class="col-md-2"><c:out value="${reservation.id}" /></td>
                            <td class="col-md-2"><c:out value="${resFromDate}" /></td>
                            <td class="col-md-2"><c:out value="${resToDate}" /></td>
                            <td class="col-md-2"><c:out value="${reservation.employee.firstName}" /> &nbsp; <c:out value="${reservation.employee.lastName}" /></td>
                            <td class="col-md-2"><c:out value="${reservation.car.model}" /> &nbsp; <c:out value="${reservation.car.plateNumber}" /></td>
                            <td class="col-md-2"><c:out value="${reservation.cancelled}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <div class="form-group row">
            <div class="col-md-2">
                <a href="${pageContext.request.contextPath}/reservation/new" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    Add a new reservation
                </a>
            </div>
        </div>
    </jsp:attribute>
</my:pagetemplate>
