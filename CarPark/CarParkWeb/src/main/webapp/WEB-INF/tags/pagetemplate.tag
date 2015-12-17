<%@tag pageEncoding="utf-8" dynamic-attributes="dynattrs" %>
<%@attribute name="title" %>
<%@attribute name="head" fragment="true" %>
<%@attribute name="body" fragment="true" required="true" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title><c:out value="${title}" /></title>
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/flatly/bootstrap.min.css"/>
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
        <jsp:invoke fragment="head" />
    </head>
    
    <body>
        <div class="container">
            <br/>
            <h1>CarPark Control Center  </h1>
            <br/>
        </div>
        <div class="navbar navbar-inverse">
             <div class="container">
                <ul class="nav navbar-nav">
                    <li class="${ (pageContext.request.requestURI.contains("/car") || pageContext.request.requestURI.contains("/employee") || pageContext.request.requestURI.contains("/office") || pageContext.request.requestURI.contains("/reservation")) ? '' : 'active'}"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li class="${pageContext.request.requestURI.contains("/car") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/car/list">Cars</a></li>
                    <li class="${pageContext.request.requestURI.contains("/office") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/office/list">Offices</a></li>
                    <li class="${pageContext.request.requestURI.contains("/employee") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/employee/list">Employees</a></li>
                    <li class="${pageContext.request.requestURI.contains("/reservation") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/reservation/list">Reservations</a></li>
                </ul>
             </div>
        </div>
        
        <div class="container">
            <jsp:invoke fragment="body" />
        </div>
        
         <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
    </body>
</html>
