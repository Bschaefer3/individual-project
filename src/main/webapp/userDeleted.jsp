<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/navbar.jsp"/>

<main>
    <div class="row">
        <div class="col-12 text-center">
            <h1>User Deleted</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-12 user-info text-center">
            <h3>${user.username}</h3>
            <small>${user.firstname} ${user.lastname}</small> <br>
            <small>${rank.title}</small>
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-6 mx-auto text-center">
            <a href="admin" class="btn btn-primary">Admin</a>
            &emsp; <a href="profile" class="btn btn-secondary">Profile</a>
            &emsp; <a href="home" class="btn btn-primary">Home</a>
        </div>
    </div>
    <br>

</main>

<c:import url="template/footer.html"/>

</body>
</html>
