<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- NavBar -->
<div class="row">
    <div class="bg-light w-100">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a href="home" class="navbar-brand text-secondary"><i class="fas fa-chess-king"></i></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbar" aria-controls="navbarTogglerDemo01"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="itemSearchAll">Item Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="userSearch">User Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="tips">Tips and Leveling</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="quests">Tasks</a>
                    </li>
                </ul>
                <ul class="navbar-nav my-2">
                    <c:if test="${rank.title == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="admin">Admin</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Log Out</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>