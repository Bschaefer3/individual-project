<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/notLoggedNavBar.jsp"/>

<main>
    <div class="row">
        <div class="col-12 mx-auto text-center">
            <h2>Your account has been created!</h2>
            <h4>Time to log in and get started.</h4>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mx-auto text-center">
        <a href="profile" class="btn btn-primary">Log In</a>
        &emsp; <a href="home" class="btn btn-secondary">Home</a>
        </div>
    </div>
    <br>
</main>

<c:import url="template/footer.html"/>

</body>
</html>
