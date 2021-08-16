<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Cocktail" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% List<Cocktail> addedCocktails = (List)session.getAttribute("addedCocktails");%>
<% List<Cocktail> favCocktails = (List)session.getAttribute("favCocktails");%>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Italiana&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./style/user.css">
</head>

<body>
<div class="header">
    <div class="title">${user.getName()} ${user.getSurname()}'s corner</div>

   <div class="header_right_side">
       <a class="add_cocktail" href="/main">
           <i class="fas fa-home" style="margin-top: 0"></i>
       </a>

       <a class="add_cocktail" href="/addCocktail">
           <i class="fas fa-glass-martini-alt"></i>
           <i class="fas fa-plus"></i>
       </a>

       <a class="edit_user" href="/confirmPassword">
           <i class="fas fa-user-edit"></i>
       </a>
   </div>
</div>

<span class="spline_title">My Cocktails</span>

<div id="one" class="splide ${addedCocktails.size() == 0 ? "hidden" : ""}">
    <div class="splide__track">
        <ul class="splide__list">
            <c:forEach items="${addedCocktails}" var="cocktail">
                <li cocktailID = '1${cocktail.getId()}' class="splide__slide">
                    <img src="cocktail_images/${cocktail.getId()}.jpg" alt="Image not found" onerror="this.src='assets/cocktails/no_photo.png';  document.querySelector(`[cocktailID = '1${cocktail.getId()}']`).classList.add('background_no_photo'); "/>
                    <div class="cocktail_footer">
                        <span class="scale_name margin_left">${cocktail.getName()}</span>
                        <div class="right_side">
                            <div class="rating">
                                <i class="far fa-smile ${cocktail.getRating() > 3.5 ? "" : "hidden"}"></i>
                                <i class="far fa-meh ${cocktail.getRating() > 1.5 && cocktail.getRating() <= 3.5 ? "" : "hidden"}"></i>
                                <i class="far fa-frown ${cocktail.getRating() <= 1.5 ? "" : "hidden"}"></i>
                                <span>${cocktail.getRating()}</span>
                            </div>

                            <div>
                                <i class="fas fa-user-check"></i>
                                <span>${cocktail.getVoters()}</span>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="no_cocktail_message ${addedCocktails.size() != 0 ? "hidden" : ""}">
    You don't have any cocktails
</div>


<span class="spline_title">Favourite Cocktails</span>
<div id="two" class="splide two ${favCocktails.size() == 0 ? "hidden" : ""}">
    <div class="splide__track">
        <ul class="splide__list">
            <c:forEach items="${favCocktails}" var="cocktail">
                <li cocktailID = '2${cocktail.getId()}' class="splide__slide">
                    <img src="cocktail_images/${cocktail.getId()}.jpg" alt="Image not found" onerror="this.src='assets/cocktails/no_photo.png';  document.querySelector(`[cocktailID = '2${cocktail.getId()}']`).classList.add('background_no_photo')"/>
                    <div class="cocktail_footer">
                        <span class="scale_name margin_left">${cocktail.getName()}</span>
                        <div class="right_side">
                            <div class="rating">
                                <i class="far fa-smile ${cocktail.getRating() > 3.5 ? "" : "hidden"}"></i>
                                <i class="far fa-meh ${cocktail.getRating() > 1.5 && cocktail.getRating() <= 3.5 ? "" : "hidden"}"></i>
                                <i class="far fa-frown ${cocktail.getRating() <= 1.5 ? "" : "hidden"}"></i>
                                <span>${cocktail.getRating()}</span>
                            </div>

                            <div>
                                <i class="fas fa-user-check"></i>
                                <span>${cocktail.getVoters()}</span>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="no_cocktail_message ${favCocktails.size() != 0 ? "hidden" : ""}">
    You don't have any favourite cocktails
</div>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/css/splide.min.css">
<script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/js/splide.min.js"></script>
<script src="scripts/user.js"></script>
<script src="https://kit.fontawesome.com/dcb70c1fc2.js" crossorigin="anonymous"></script>

</body>

</html>