<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Car ${car.model} information">
    <jsp:attribute name="body">
        <table class="table">
            <tr>
                <td class="col-md-2"><b>Model</b></td>
                <td>${car.model}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Color</b></td>
                <td>${car.color}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Vin</b></td>
                <td>${car.vin}</td>
            </tr>
            <tr>
                <td class="col-md-2"><b>Plate Number</b></td>
                <td>${car.plateNumber}</td>
            </tr>
            
            <tr>
                <td class="col-md-2"><b>Fuel Capacity</b></td>
                <td>${car.fuelCapacity}</td>
            </tr>
            <tr>
                <td><input type="button" value="Back" onclick="history.go(-1)" class="btn btn-danger"></td>
            </tr>
        </table>
    </jsp:attribute>
</my:pagetemplate>