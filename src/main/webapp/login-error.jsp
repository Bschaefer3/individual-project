<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:choose>
    <c:when test="${user != null}">
        <c:import url="template/navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="template/notLoggedNavBar.jsp"/>
    </c:otherwise>
</c:choose>

<div class="row">
    <div class="col-6 mx-auto text-center">
        <h3>Log-in Failed</h3>
        <img src="images/ouch.png" alt="Ouch Text">
        <br/>
        <a href="profile">Try again!</a>
    </div>
</div>

<c:import url="template/footer.html"/>

</body>
</html>

