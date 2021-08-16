<%--
  Created by IntelliJ IDEA.
  User: davidtodua
  Date: 15.08.21
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Cocktail</title>
    <script src="scripts/addCocktails.js" defer></script>
    <link rel="stylesheet" href="style/addCocktail.css">
</head>
<body>

<form method="POST" action="/addCocktail" enctype="multipart/form-data">
    <div>
        <label for="CocktailName">Cocktail Name <span> * </span></label>
        <input type="text" name="CocktailName" required/>
    </div>
    <div>
        <label for="UploadImage">Upload Image </label>
        <input type="file" name="UploadImage" accept="image/*"/>
    </div>
    <div class="ingredients">
        <c:forEach items='${requestScope.get("ings")}' var="ing">
            <div>
                <input type="text" name="${ing.name}" value='${ing.name} : none' id='${ing.name}' readonly>
                <input type="text" placeholder="ingredient amount">
                <button class='set-amount'>Set Amount</button>
                <button class="clear-amount">Clear Amount</button>
            </div>
        </c:forEach>
    </div>
    <button type="submit">Add cocktail</button>
    <div>
        <input type="button" name="Add New Ingredient" value="Add New Ingredient" id="add-ingredient">
    </div>
</form>
<div id="new-ingredient">
    <form id="new-ingredient-form">
        <div>
            <label for="ingredientName">Ingredient Name</label>
            <input type="text" name="ingredientName" required id="ingredientName">
        </div>
        <div>
            <label for="ingredientAmount">Ingredient Amount</label>
            <input type="text" name="ingredientAmount" id="ingredientAmount">
        </div>
        <button type="submit" id="new-ingredient-add">add</button>
        <input type="button" value="cancel" id="new-ingredient-cancel">
    </form>
</div>

</body>
</html>
