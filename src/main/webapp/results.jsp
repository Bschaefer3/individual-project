<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Search Users</title>
        <link rel="stylesheet" href="css/master.css">
    </head>
    <body>

    <div>
        <h2>Search Results: </h2>

        <table>
            <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>Last Name</th>
                <th>First Name</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    </body>
</html>
