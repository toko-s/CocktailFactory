<%--
  Created by IntelliJ IDEA.
  User: davidtodua
  Date: 15.08.21
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Add Cocktail</title>
</head>
<body>
    <form method="POST" action="/addCoctail">
        <button>
            <div>
                <label for="CocktailName">Cocktail Name <span> * </span></label>
                <input type="text" name="CocktailName" />
            </div>
            <div>
                <label for="UploadImage">Upload Image </label>
                <input type="file" name="UploadImage" accept = "image/*" />
            </div>
            <div>
                <c:forEach items='${requestScope.get("ings")}' var="ing">
                    <div>
                        <input type="text" name='${ing.name}' value='${ing.name} : 0'
                               contenteditable="false" >
                        <input type="button" name="Increase" value="Increase">
                        <input type="button" name="Decrease" value="Decrease">
                    </div>


                </c:forEach>
                <div>
                    <input type="button" name="Add New Ingredient" value="Add New Ingredient">
                </div>
                <div>
                    <form>
                        <div>
                            <label for="ingredientName">Ingredient Name</label>
                            <input type="text" name="ingredientName">
                        </div>
                        <div>
                            <label for="ingredientPrice">Ingredient Price</label>
                            <input type="text" name="ingredientPrice">
                        </div>
                    </form>
                </div>
            </div>

<%--            <input type="hidden" name="id" value="s" />--%>
<%--            <input type="hidden" name="id" value="s"/>--%>
<%--            <input type="hidden" name="id" value="s" />--%>
<%--            <input type="hidden" name="id" value="s"/>--%>
        </button>
    </form>

</body>
</html>
