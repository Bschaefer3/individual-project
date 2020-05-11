<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">

<c:import url="template/header.html"/>
<body class="container">

<c:choose>
    <c:when test="${user != null}">
        <c:import url="template/navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="template/notLoggedNavBar.jsp"/>
    </c:otherwise>
</c:choose>

<!-- Header -->
<div class="row align-items-center bg-light mb-3">
    <div class="col-md-8 mb-3" >
        <h1><b>Your experience <br />
            <span class="text-secondary">Streamlined</span></b></h1>
        <p>Keep track of everything you need in one place!</p>
        <c:choose>
            <c:when test="${user != null}">
                <button class="btn btn-primary m-2" onclick="location.href='profile'" type="button">PROFILE</button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary" onclick="location.href='profile'" type="button"> LOG IN </button>
                <button class="btn btn-secondary" onclick="self.close()" type="button"> SIGN UP </button>
            </c:otherwise>
        </c:choose>
    </div>

    <!-- League Title -->
    <div class="col-md-4">
        <div class="ml-3">
            <img class="ml-auto" src="images/poeLogo.png" alt="Path of Exile / League: Delirium">
        </div>
    </div>
</div>

<!-- Body -->
<div class="py-5">
    <div class="row">
        <div class="col-sm-12">
            <div class="text-center mx-auto">
                <h7 class="font-weight-bold text-black-50">FEATURES</h7>
                <h2 class="font-weight-bold">A better way to keep track and stay organized</h2>
                <p class="w-50 mx-auto">Path of Exile (<code>PoE</code>) Tracker features a variety of tools to keep
                you organized and ready for your adventure through <em>Wraeclast</em>!</p>
            </div>
        </div>
    </div>

    <!-- Feature Cards -->
    <div class="row">

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-search"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Item and User Search</h6>
                            <p class="card-text"><small class="text-muted">Our item and user search features let you
                                keep track of your friends and the items your crew will be needing!</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-drafting-compass"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Theory Crafting and Builds</h6>
                            <p class="card-text"><small class="text-muted">Every user has the ability to create their
                                own build. You and all of your friends can stay organized by keeping track of them
                                here!</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-clipboard"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Tips and Leveling</h6>
                            <p class="card-text"><small class="text-muted">Check out our Tips and Leveling page to see
                                the latest tricks and advice for making your adventure as smooth and as fast as
                                possible.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-list-ul"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Task and Quest Tracker</h6>
                            <p class="card-text"><small class="text-muted">Knock off all of the required quests and even
                                keep track of your own tasks with our Task and Quest Tracker.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<div class="row bg-light p-5">
    <div class="col-12 col-md-8">
        <c:choose>
            <c:when test="${user != null}">
                <h2 class="font-weight-bold">Get Started at your Profile! <br />
            </c:when>
            <c:otherwise>
                <h2 class="font-weight-bold">Ready to start? <br />
                <span class="text-secondary">Sign up for free today.</span></h2>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="col-12 col-md-4 my-auto text-center">
        <c:choose>
            <c:when test="${user != null}">
                <button class="btn btn-primary m-2" onclick="location.href='profile'" type="button">PROFILE</button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary m-2" onclick="location.href='signup'" type="button">TRY IT FREE</button>
                <button class="btn btn-secondary m-2" onclick="location.href='https://www.nimh.nih.gov/health/find-help/index.shtml'" type="button">NO THANKS</button>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<c:import url="template/footer.html"/>

</body>
</html>
