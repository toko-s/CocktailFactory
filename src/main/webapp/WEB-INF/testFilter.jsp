<%--
  Created by IntelliJ IDEA.
  User: Drama
  Date: 7/17/2021
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cocktails</title>
</head>
<body>
    <form method="post">
        <label for="name">Cocktail name:</label>
        <input type="text" name="name"></br>
        <label for="rating">Rating:</label>
        <input type="text" name="rating"></br>
        <label for="type">LOWER</label>
        <input type="radio" name="type" value="LOWER"></br>
        <label for="type">HIGHER</label>
        <input type="radio" name="type" value="HIGHER" checked></br>
        <button type="submit">Search</button>
    </form>
</body>
</html>
