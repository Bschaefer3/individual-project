<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<%@include file="template/header.html"%>
<body class="container">

<%@include file="template/navbar.html"%>


    <main>
        <c:if test="${user != null}">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>User Profile</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-4">
                    <h3>${user.username}</h3>
                    <small>${user.firstname} ${user.lastname}</small>
                </div>

                <div class="col-8">
                    <h3>Build Idea:</h3>
                    <br/>
                    <p>${build.build}</p>
                    <br/>
                    <a href="#">Edit Build</a>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <h3>Build Accessories:</h3>


                </div>
            </div>
        </c:if>
    </main>


<%@include file="template/footer.html"%>

</body>
</html>
