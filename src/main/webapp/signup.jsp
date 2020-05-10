<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:import url="template/notLoggedNavBar.jsp"/>

    <main>
        <div class="row">
            <div class="col-4 mx-auto text-center">
                <form action="signup" method="post" class="container">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="username">User name</label>
                            <input type="text" id="username" name="username">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="fname">First name</label>
                            <input type="text" id="fname" name="fname">
                        </div>
                        <div class="form-group col">
                            <label for="lname">Last name</label>
                            <input type="text" id="lname" name="lname">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="rank">Rank</label>
                            <input id="rank" type="text" value="User" name="rank" readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="password1">Password</label>
                            <input type="password" id="password1" name="password">
                        </div>
                        <div class="form-group col">
                            <label for="password2">Confirm Password</label>
                            <input type="password" id="password2" name="password">
                        </div>
                    </div>
                    <div class="form-row">
                        <button type="submit" class="btn btn-primary">Log In</button>
                        <button type="reset" class="btn btn-secondary">Clear</button>
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
