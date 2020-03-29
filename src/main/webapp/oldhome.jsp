<html lang="en" dir="ltr">
<head>
    <title>Home Page</title>
</head>
<body>
<a href="searchUser.jsp">Search Users (Login Required)</a>
<hr />
<h3>Search Users (Restful Service)</h3>
<form action="rest/searchUsersById" method="get">

    <div>
        <label for="term" class="label">Search Term: </label>
        <input type="text" name="term" id="term">
    </div>

    <label>Search Type</label>
    <div>
        <input type="radio" name="type" id="id" value="id" checked>
        <label for="id">
            ID
        </label>
    </div>
    <div>
        <input type="radio" name="type" id="ln" value="lastname">
        <label for="ln">
            Last Name
        </label>
    </div>
    <div>
        <input type="radio" name="type" id="fn" value="firstname">
        <label for="fn">
            First Name
        </label>
    </div>

    <br />

    <button type="submit"> Search </button>

</form>

</body>
</html>
