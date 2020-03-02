<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Home Page</title>
    </head>
    <body>
        <div>

            <form action="searchUser">

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


        </div>
    </body>
</html>
