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
    <div class="col-12 mx-auto text-center">
        <h4>Edit your Build</h4>
    </div>

    <div class="col-6 mx-auto">
        <form action="updateBuild" method="get">
            <div class="form-group">
                <label for="build">${user.username}'s Build Description</label>
                <textarea id="build" class="form-control" name="build" rows="5">${build.build}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
</div>

<c:import url="template/footer.html"/>

</body>
</html>

