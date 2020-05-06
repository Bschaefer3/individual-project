<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<%@include file="template/header.html"%>
<body class="container">

<%@include file="template/navbar.html"%>

<div class="row">
    <form action="j_security_check" method="post" class="col-12">
        <div class="form-group">
            <label for="username">User name:</label>
            <input type="text" id="username" name="j_username">
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="j_password">
            <small class="form-text text-muted">Never share your log-in information with anyone!</small>
        </div>
        <button type="submit" class="btn btn-primary">Log In</button>
    </form>
</div>

<%@include file="template/footer.html"%>

</body>
</html>

