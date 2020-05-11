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
        <h4>Add Task</h4>
    </div>

    <div class="col-6 mx-auto">
        <form action="taskadded" method="get">
            <div class="form-group">
                <label for="task">Task Description</label>
                <textarea id="task" class="form-control" name="task" rows="5"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
            &emsp; <button type="reset" class="btn btn-secondary">Clear</button>
        </form>
    </div>
</div>

<c:import url="template/footer.html"/>

</body>
</html>

