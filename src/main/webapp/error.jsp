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

<main>
    <div class="row">
        <div class="col-12 mx-auto text-center">
            <h1>Yikes!</h1>
            <p>Something went wrong! Leave it to the devs to figure this one out!</p>
            <small class="text-muted">If that will ever happen...</small>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-6 mx-auto text-center">
            <a href="profile" class="btn btn-primary">Profile</a>
            &emsp; <a href="home" class="btn btn-secondary">Home</a>
        </div>
    </div>
    <br>
</main>

<c:import url="template/footer.html"/>

</body>
</html>

