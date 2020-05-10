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
                    <small>${user.firstname} ${user.lastname}</small> <br>
                    <small>${rank.title}</small>
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
                <h3 class="col-12">Build Accessories:</h3>
                <a href="itemSearchAll" class="padding">Add Item</a>
            </div>
            <div class="row justify-content-center">
                <c:forEach items="${items}" var="item" varStatus="status">
                    <div class="col-3 img-thumbnail mb-3 mx-1">
                        <div class="card text-center">
                            <img class="card-img-top" src="${item.image}" alt="">
                            <div class="card-body">
                                <h5 class="card-title">${item.name}</h5>
                                <div class="card-subtitle">
                                    <small>${item.category}</small> <br/>
                                    <small>${item.type}</small> <br/>
                                    <c:set var="id" scope="page">${pairs[status.index].id}</c:set>
                                    <c:out value="${id}"/>
                                    <small><a class="card-link" href="removePair?id=${id}">Remove Item</a></small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </main>

<c:import url="template/footer.html"/>

</body>
</html>
