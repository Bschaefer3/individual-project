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
<c:choose>
    <c:when test="${user != null}">
        <div class="row">
            <div class="col-12 text-center">
                <h1>${user.username}'s Task List and Quests</h1>
            </div>
            <a href="addtask">Add Task</a>
        </div>

        <div class="row">
            <div class="col mx-auto">
                <table class="table">
                    <caption>${user.username}'s Task List</caption>
                    <thead>
                    <tr>
                        <th scope="col">Completed</th>
                        <th scope="col">Description</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <th scope="row" class="
                                            <c:if test="${task.completion == 1}">
                                            text-muted
                                            </c:if>">
                                <c:choose>
                                    <c:when test="${task.completion == 0}">
                                        <i class="far fa-circle"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="far fa-check-circle"></i>
                                    </c:otherwise>
                                </c:choose>
                            </th>
                            <td class="
                                        <c:if test="${task.completion == 1}">
                                        text-muted
                                        </c:if>">
                                ${task.task}
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${task.completion == 0}">
                                        <a href="changetask?id=${task.id}">Complete</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="changetask?id=${task.id}">Incomplete</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a href="removetask?id=${task.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
    </c:when>
    <c:otherwise>
        <div class="col-6 mx-auto">
            <h3>You need to log in to add your own tasks!</h3>
        </div>
    </c:otherwise>
</c:choose>

            <div class="col-6 mx-auto">
                <table class="table">
                    <caption>All Quests</caption>
                    <thead>
                        <tr>
                            <th scope="col">Act #</th>
                            <th scope="col">Description</th>
                            <th scope="col">Skill Points</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row"></th>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

</main>

<c:import url="template/footer.html"/>

</body>
</html>

