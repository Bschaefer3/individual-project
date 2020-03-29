<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>POE Tracker</title>
    <!-- CSS Reset -->
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <!-- Bootstrap JS / Popper.js / jQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <!-- FontAwesome -->
    <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          rel="stylesheet"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
          crossorigin="anonymous">
    <!-- Personal Stylesheet -->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body class="container">

<!-- NavBar -->
<div class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a href="index.jsp" class="navbar-brand text-secondary"><i class="fab fa-amilia"></i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbar" aria-controls="navbarTogglerDemo01"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Item Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="oldhome.jsp">User Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tips and Leveling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Tasks</a>
                </li>
            </ul>
            <ul class="navbar-nav my-2">
                <li class="nav-item">
                    <a class="nav-link" href="#">Log&nbsp;In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sign&nbsp;Up</a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<!-- Header -->
<div class="row align-items-center bg-light mb-3">
    <div class="col-md-7 mb-3" >
        <h1><b>Your experience <br />
            <span class="text-secondary">Streamlined</span></b></h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
            fringilla augue vel fringilla.</p>
        <button class="btn btn-primary" type="button"> LOG IN </button>
        <button class="btn btn-secondary" type="button"> SIGN UP </button>
    </div>

    <!-- League Title -->
    <div class="col-md-5">
        <img src="images/poeLogo.png" alt="Path of Exile / League: Delirium">
    </div>
</div>

<!-- Body -->
<div class="py-5">
    <div class="row">
        <div class="col-sm-12">
            <div class="text-center mx-auto">
                <h7 class="font-weight-bold text-black-50">FEATURES</h7>
                <h2 class="font-weight-bold">A better way to keep track and stay organized</h2>
                <p class="w-50 mx-auto">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
                    fringilla augue vel fringilla. Donec sit amet, consectetur
                    adipiscing elit.</p>
            </div>
        </div>
    </div>

    <!-- Feature Cards -->
    <div class="row">

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-comments"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Item and User Search</h6>
                            <p class="card-text"><small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
                                fringilla augue vel fringilla. Donec sit amet, consectetur
                                adipiscing elit.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-rocket"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Theory Crafting and Builds</h6>
                            <p class="card-text"><small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
                                fringilla augue vel fringilla. Donec sit amet, consectetur
                                adipiscing elit.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-clock"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Tips and Leveling</h6>
                            <p class="card-text"><small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
                                fringilla augue vel fringilla. Donec sit amet, consectetur
                                adipiscing elit.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card col-12 col-md-6">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <h1><i class="mt-5 pr-5 text-secondary fas fa-cloud"></i></h1>
                    </div>
                    <div class="col-10">
                        <div class="card-body">
                            <h6 class="card-title font-weight-bold">Task and Quest Tracker</h6>
                            <p class="card-text"><small class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis
                                fringilla augue vel fringilla. Donec sit amet, consectetur
                                adipiscing elit.</small></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Footer -->
<div class="">
    <div class="row bg-light p-5">
        <div class="col-12 col-md-8">
            <h2 class="font-weight-bold">Ready to start? <br />
                <span class="text-secondary">Sign up for free today.</span></h2>
        </div>
        <div class="col-12 col-md-4 my-auto text-center">
            <button class="btn btn-primary m-2" type="button">TRY IT FREE</button>
            <button class="btn btn-secondary m-2" type="button">NO THANKS</button>
        </div>
    </div>

    <div class="row bg-dark text-white-50 p-5">
        <div class="mt-3 col-12 col-lg-12">
            <div class="">
                <h6>SUBSCRIBE FOR A SINGLE PICTURE OF A HOTDOG</h6>
                <p>Get the latest picture of a hotdog by entering your email here.</p>
            </div>
            <div class="">
                <form class="form-inline" action="#" method="post">
                    <input type="text" class="mr-1 form-control" placeholder="Email">
                    <button type="submit" class="btn btn-primary">SUBSCRIBE</button>
                </form>
            </div>
        </div>
    </div>

    <div class="row bg-dark text-white-50">
        <div class="col-12 pl-5">
            <p>Path of Exile content and materials are the intellectual property of their respective owners.</p>
        </div>
    </div>
</div>

</body>
</html>
