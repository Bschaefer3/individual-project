<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/notLoggedNavBar.jsp"/>

    <main>
        <div class="row">
            <div class="col-4 mx-auto text-center">
                <h1>Sign Up</h1>
            </div>
        </div>

        <c:if test="${errorMessage != null}">
            <div class="row">
                <div class="p-3 mb-2 bg-danger text-white col-6 mx-auto text-center rounded">${errorMessage}</div>
            </div>
        </c:if>

        <div class="row">
            <div class="col-8 mx-auto text-center">
                <form action="signup" method="post" class="container">
                    <div class="form-row">
                        <div class="form-group col-6 mx-auto">
                            <label for="username">User name</label>
                            <input type="text" id="username" name="username" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="fname">First name</label>
                            <input type="text" id="fname" name="fname" class="form-control">
                        </div>
                        <div class="form-group col">
                            <label for="lname">Last name</label>
                            <input type="text" id="lname" name="lname" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="password1">Password</label>
                            <input type="password" id="password1" name="password1" class="form-control">
                        </div>
                        <div class="form-group col">
                            <label for="password2">Confirm Password</label>
                            <input type="password" id="password2" name="password2" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-4 mx-auto">
                            <label for="rank">Rank</label>
                            <input id="rank" type="text" value="user" name="rank" readonly class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-4 mx-auto">
                            <button type="submit" class="btn btn-primary">Sign up</button>
                            &emsp; <button type="reset" class="btn btn-secondary">Clear</button>
                        </div>
                    </div>
                    <div class="form-row">
                        <small class="form-text text-muted col">Never share this information with anyone!</small>
                    </div>
                </form>
            </div>
        </div>
    </main>

<c:import url="template/footer.html"/>

</body>
</html>
