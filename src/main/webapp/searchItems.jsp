<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/navbar.jsp"/>

<main>
    <div class="row">
        <div class="col-6 mx-auto mt-3">
            <form action="itemSearch" method="get">
                <div class="form-group">
                    <label for="search">Item Name:</label>
                    <input type="text" id="search" class="form-control" name="search">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${items}" var="item">
            <div class="col-3 img-thumbnail mb-3 imageContainer">
                <div class="card">
                    <img class="card-img-top itemImage" src="${item.image}" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <div class="card-subtitle text-center">
                            <small>${item.category}</small> <br/>
                            <small>${item.type}</small> <br/>
                            <small><a class="card-link" href="addPair">Add Item to Build</a></small>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

<c:import url="template/footer.html"/>

</body>
</html>
