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
        <input type="text" name="name"><br>
        <label for="rating">Rating:</label>
        <input type="text" name="rating"><br>
        <label for="type">Type</label>
        <select class="type">
            <option value="">none</option>
            <option value="HIGHER">higher</option>
            <option value="LOWER">lower</option>
        </select><br>
        <button type="submit">Search</button>
    </form>
</body>
</html>
