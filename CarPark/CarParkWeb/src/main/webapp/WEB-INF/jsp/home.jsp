<%@page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<my:pagetemplate>
     <jsp:attribute name="body">

        <div>
            <div class="jumbotron">
                <div class="container">
                    <h1>Welcome in CarPark</h1>      
                    <p>The most wonderful tool for managing cars, employees and offices.</p>
                </div>
            </div>

           
            <div class="container">
                <c:choose>
                    <c:when test="${not empty user}">
                        <h1>
                            <fmt:message key="home.hi">
                                <fmt:param value="${userData.userDataInfo}"/>
                            </fmt:message>
                        </h1>
                        <p>${user}</p>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <p>Logged as administrator.</p>
                        </sec:authorize>

                    </c:when>
                    <c:otherwise>
                        <div class="panel panel-danger">
                           <div class="panel-heading">Please, login!</div>
                           <div class="panel-body">
                                You are not logged in as user or administrator. You have no permissions...
                                <a class="btn btn-xs btn-danger " href="${pageContext.request.contextPath}/login" role="button">Login</a>
                           </div> 
                        </div>
                        
                    </c:otherwise>
                </c:choose> 
            </div>
                
        </div>


    </jsp:attribute>
</my:pagetemplate>