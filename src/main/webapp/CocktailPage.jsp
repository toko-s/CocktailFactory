<%--
  Created by IntelliJ IDEA.
  User: davidtodua
  Date: 06.08.21
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Cocktail</title>
    <link rel="stylesheet" href="style/cocktailsPage.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <a href="/cocktails">Back to cocktails!</a>
    <li>
        ${cocktail.name}
        ${cocktail.rating}
            <span class="fa fa-star ${cocktail.rating > 0 ? "checked" : ""} 0"></span>
            <span class="fa fa-star ${cocktail.rating > 1 ? "checked" : ""} 1"></span>
            <span class="fa fa-star ${cocktail.rating > 2 ? "checked" : ""} 2"></span>
            <span class="fa fa-star ${cocktail.rating > 3 ? "checked" : ""} 3"></span>
            <span class="fa fa-star ${cocktail.rating > 4 ? "checked" : ""} 4"></span>
        <span class="voters" >(${cocktail.voters})</span>
    </li>
    <img src="cocktail_images/${cocktail.id}.jpg" alt="No picture" onerror="this.src='assets/cocktails/no_photo.png'">

    <c:forEach items='${cocktail.ingredients}' var='ingredient'>
        <p>${ingredient.name}</p>
    </c:forEach>

</body>
</html>
