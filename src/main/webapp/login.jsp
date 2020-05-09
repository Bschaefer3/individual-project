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

<div class="col-4 mx-auto text-center">
    <h1>Log In</h1>
</div>

<div class="row">
    <div class="col-4 mx-auto">
        <form action="j_security_check" method="post">
            <div class="form-group">
                <label for="username">User name:</label>
                <input type="text" id="username" name="j_username">
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="j_password">
                <small class="form-text text-muted">Never share your log-in information with anyone!</small>
                <br />
            </div>
            <button type="submit" class="btn btn-primary">Log In</button>
        </form>
    </div>
</div>

<c:import url="template/footer.html"/>

</body>
</html>

