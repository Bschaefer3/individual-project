<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/navbar.jsp"/>

<main>
    <div class="row">
        <div class="col-12 text-center">
            <h1>Admin Page</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-4 user-info">
            <h3>${user.username}</h3>
            <small>${user.firstname} ${user.lastname}</small> <br>
            <small>${rank.title}</small>
        </div>

        <div class="col-4">
            <h3>Add Item to Database</h3>
            <form action="addItem" method="get">
                <div class="form-group">
                    <label for="newitem">Item Id</label>
                    <input id="newitem" class="form-control" name="newitem">
                </div>
                <button type="submit" class="btn btn-primary">Add Item</button>
            </form>
        </div>

        <div class="col-4">
            <c:if test="${item != null}">
                <div class="img-thumbnail mb-3 imageContainer">
                    <div class="card">
                        <img class="card-img-top itemImage" src="${item.image}" alt="">
                        <div class="card-body text-center">
                            <h5 class="card-title">${item.name}</h5>
                            <div class="card-subtitle">
                                <small>${item.category}</small> <br/>
                                <small>${item.type}</small> <br/>
                                <br><small><a class="card-link" href="removeItem?itemid=${item.id}&admin=true">Delete Item</a></small>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mx-auto">
            <table class="table">
                <caption>All Users</caption>
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
                            <td><a href="removeuser?id=${info.id}">Delete</a></td>
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
