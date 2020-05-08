<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/navbar.jsp"/>

    <main>
        <c:if test="${user != null}">
            <div class="row">
                <div class="col-12 text-center">
                    <h1>User Profile</h1>
                </div>
            </div>

            <div class="row">
                <div class="col-4 user-info">
                    <h3>${user.username}</h3>
                    <small>${user.firstname} ${user.lastname}</small>
                </div>

                <div class="col-8">
                    <h3>Build Idea:</h3>
                    <br/>
                    <p>${build.build}</p>
                    <br/>
                    <a href="build">Edit Build</a>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <h3>Build Accessories:</h3>
                    <a href="itemSearch">Add Item</a>
                    <c:forEach items="${items}" var="item">
                        <div class="col-3 img-thumbnail mb-3">
                            <div class="card">
                                <img class="card-img-top" src="${item.image}" alt="">
                                <div class="card-body">
                                    <h5 class="card-title">${item.name}</h5>
                                    <div class="card-subtitle text-center">
                                        <small>${item.category}</small> <br/>
                                        <small>${item.type}</small> <br/>
                                        <small><a class="card-link" href="#">Remove Item</a></small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </main>

<c:import url="template/footer.html"/>

</body>
</html>
