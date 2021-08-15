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
</head>
<body>
    <a href="/cocktails">Back to cocktails!</a>
    <li>${cocktail.name}
            ${cocktail.rating}
        <span class="fa fa-star ${cocktail.rating > 0 ? "checked" : ""}"></span>
        <span class="fa fa-star ${cocktail.rating > 1 ? "checked" : ""}"></span>
        <span class="fa fa-star ${cocktail.rating > 2 ? "checked" : ""}"></span>
        <span class="fa fa-star ${cocktail.rating > 3 ? "checked" : ""}"></span>
        <span class="fa fa-star ${cocktail.rating > 4 ? "checked" : ""}"></span>
        <span class="voters" >(${cocktail.voters})</span>
    </li>

    <c:forEach items='${cocktail.ingredients}' var='ingredient'>
        <p>${ingredient}</p>
    </c:forEach>

</body>
</html>
