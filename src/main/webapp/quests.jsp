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
                            <th scope="col">Title</th>
                            <th scope="col">Skill Points</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>The Dweller of the Deep</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>The Marooned Mariner</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>The Way Forward</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Deal With The Bandits</td>
                            <td>1 or 2</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Victario's Secrets</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Piety's Pets</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>An Indomitable Spirit</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>In Service to Science</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>Kitava's Torments</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>The Father of War</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>The Puppet Mistress</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>The Cloven One</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">7</th>
                            <td>The Master of a Million Faces</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">7</th>
                            <td>Queen of Despair</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">7</th>
                            <td>Kishara's Star</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>Love is Dead</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>Reflection of Terror</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">8</th>
                            <td>The Gemling Legion</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">9</th>
                            <td>Queen of the Sands</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">9</th>
                            <td>The Ruler of Highgate</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">10</th>
                            <td>Vilenta's Vengeance</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <th scope="row">10</th>
                            <td>An End to Hunger</td>
                            <td>2</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

</main>

<c:import url="template/footer.html"/>

</body>
</html>

