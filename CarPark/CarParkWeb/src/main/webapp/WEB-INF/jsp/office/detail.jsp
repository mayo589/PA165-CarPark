<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:pagetemplate title="Office">
    <jsp:attribute name="body">
        <table class="table">
            <tr>
                <td class="col-md-2"><b>Id</b></td>
                <td>${office.id}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Name</b></td>
                <td>${office.name}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Address</b></td>
                <td>${office.address}</td>
            </tr>
            <tr>
                <td><input type="button" value="Back" onclick="history.go(-1)" class="btn btn-danger"></td>
            </tr>
        </table>
    </jsp:attribute>
</my:pagetemplate>
