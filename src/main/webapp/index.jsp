
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Italiana&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/style.css">
    <script src="scripts/login.js" defer></script>
    <script src="scripts/cocktails.js" defer></script>
    <script src="scripts/mainPage.js" defer></script>
</head>
<body>

<div class="header">
    <span class="name">Cocktail Factory</span>
    <div class="login_signup ${applicationScope.get("user") != null ? "hidden" : ""}">
        <div class="popup">
            <i id="sign-in" class="fas fa-sign-in-alt"></i>
            <span class="popuptext" id="myPopupSignIn">Sign In</span>
        </div>

        <div class="popup">
            <i id="sign-up" class="fas fa-user-plus"></i>
            <span class="popuptext" id="myPopupSignUp">Sign Up</span>
        </div>
    </div>

    <div class="user-signout ${applicationScope.get("user") == null ? "hidden" : ""}">
        <div class="popup">
            <i id="log-out" class="fas fa-sign-out-alt"></i>
            <span class="popuptext" id="myPopupLogOut">Log Out</span>
        </div>

        <div class="popup">
            <i id="my-page" class="fas fa-user"></i>
            <span class="popuptext" id="myPopupMyPage">My Account</span>
        </div>
    </div>
</div>

<div class="top_drinks">
    <div class="top_drinks_name">
        <span>Top Drinks</span>
        <i class="fas fa-cocktail"></i>
    </div>

    <div class="top_drinks_list">
        <div class="scale">
            <img src="assets/cocktails/Chambord.jpg">
            <span>Chambord</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/Mojito.jpg">
            <span>Mojito</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/Random.jpg">
            <span>Random</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/WhiteNegroni.jpg">
            <span>White Negroni</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/WitchHeart.jpg">
            <span>Witch Heart</span>
        </div>
    </div>
</div>

<div class="top_drinks">
    <div class="top_drinks_name">
        <span>Fancy Bars</span>
        <img src="assets/bar.png">
    </div>

    <div class="top_drinks_list">
        <div class="scale">
            <img src="assets/cocktails/Chambord.jpg">
            <span>Chambord</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/Mojito.jpg">
            <span>Mojito</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/Random.jpg">
            <span>Random</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/WhiteNegroni.jpg">
            <span>White Negroni</span>
        </div>
        <div class="scale">
            <img src="assets/cocktails/WitchHeart.jpg">
            <span>Witch Heart</span>
        </div>
    </div>
</div>

<div id="menu" class="menu">
    <i class="fas fa-bars"></i> <span>Menu</span>
</div>
</body>

<script src="https://kit.fontawesome.com/dcb70c1fc2.js" crossorigin="anonymous"></script>

</html>