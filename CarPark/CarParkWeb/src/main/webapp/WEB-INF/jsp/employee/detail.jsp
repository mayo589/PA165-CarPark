<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<my:pagetemplate title="Employee">
    <jsp:attribute name="body">
        
        <fmt:formatDate value="${employee.dateOfBirth}" pattern="dd/MM/yyyy" var="empBirthDate" />
        
        <table class="table">
            <tr>
                <td class="col-md-2"><b>First name:</b></td>
                <td>${employee.firstName}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Last name:</b></td>
                <td>${employee.lastName}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Date of birth:</b></td>
                <td>${empBirthDate}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Address:</b></td>
                <td>${employee.address}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Telephone:</b></td>
                <td>${employee.telephone}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Admin</b></td>
                <td>${employee.admin}</td>
            </tr>
            <tr>
                <td><input type="button" value="Back" onclick="history.go(-1)" class="btn btn-danger"></td>
            </tr>
        </table>
    </jsp:attribute>
</my:pagetemplate>
