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
        <div class="col-6 mx-auto">
            <c:choose>
                <c:when test="${user != null}">
                    <h3>${item.name} has been added to your list!</h3>
                </c:when>
                <c:otherwise>
                    <h3>You need to log in to add ${item.name} to your list!</h3>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mx-auto text-center">
            <c:choose>
                <c:when test="${user != null}">
                    <a href="profile">View Profile</a>
                </c:when>
                <c:otherwise>
                    <a href="profile">Log In</a>
                </c:otherwise>
            </c:choose>
            <a href="itemSearchAll">Back to Search</a>
        </div>
    </div>
</main>

<c:import url="template/footer.html"/>

</body>
</html>

