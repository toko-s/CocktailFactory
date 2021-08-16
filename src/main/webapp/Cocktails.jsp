<%--
  Created by IntelliJ IDEA.
  User: davidtodua
  Date: 06.08.21
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cocktails</title>
    <link rel="stylesheet" href="style/cocktails.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="scripts/cocktails.js" defer></script>
</head>
<body>

<form method="get" action="/cocktails">
    <div id="name">
        <label for="name"></label>
        <input type="text" placeholder="name" name="name">
    </div>
    <div id="rating">
        <label for="rating"></label>
        <input type="number" placeholder="rating" name="rating" min="0" max="5" step="1">
    </div>
    <div>
        <select name="rating-type">
            <option value="HIGHER">higher</option>
            <option value="LOWER">lower</option>
        </select>
    </div>
    <div>
        <input type="radio" id="order-asc" value="ASCENDING" name="order-by">
        <label for="order-asc">Ascending</label>
        <input type="radio" id="order-desc" value="DESCENDING" name="order-by">
        <label for="order-desc">Descending</label>
    </div>
    <button type="submit">Search</button>
</form>

<p hidden id="userID">${applicationScope.get("user").id}</p>

<ul>
    <c:forEach items='${requestScope.get("list")}' var='cocktail'>
        <li>
            <div class="cocktail">
                <span hidden id="${cocktail.id}"></span>
                <span>${cocktail.name}</span>
                <span>${cocktail.rating}</span>
                <span class="fa fa-star ${cocktail.rating > 0 ? "checked" : ""} 0"></span>
                <span class="fa fa-star ${cocktail.rating > 1 ? "checked" : ""} 1"></span>
                <span class="fa fa-star ${cocktail.rating > 2 ? "checked" : ""} 2"></span>
                <span class="fa fa-star ${cocktail.rating > 3 ? "checked" : ""} 3"></span>
                <span class="fa fa-star ${cocktail.rating > 4 ? "checked" : ""} 4"></span>
                <span class="voters">(${cocktail.voters})</span>
                <img src="cocktail_images/${cocktail.id}.jpg" alt="No picture">
                <span class='fa fa-heart ${cocktail.favourite ? "fav" : ""}'></span>
                <form method="get" action="/cocktailpage">
                    <button>
                        details
                        <input type="hidden" name="id" value='${cocktail.id}'/>
                    </button>
                </form>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
