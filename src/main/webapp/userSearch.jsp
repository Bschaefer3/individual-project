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
        <div class="col-6 mx-auto mt-3">
            <form action="userSearch" method="post">
                <div class="form-group">
                    <label for="search">User name:</label>
                    <input type="text" id="search" class="form-control" name="search">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mx-auto">
            <table class="table">
                <caption>User Search</caption>
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">User name</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="info">
                    <tr>
                        <th scope="row">${info.id}</th>
                        <td>${info.username}</td>
                        <td>${info.firstname}</td>
                        <td>${info.lastname}</td>
                        <td><a href="viewProfile?id=${info.id}">View Profile</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>

<c:import url="template/footer.html"/>

</body>
</html>
