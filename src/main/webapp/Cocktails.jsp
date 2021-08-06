<%--
  Created by IntelliJ IDEA.
  User: davidtodua
  Date: 06.08.21
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Cocktails</title>
    <link rel="stylesheet" href="style/cocktails.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <ul>
        <c:forEach items='${requestScope.get("list")}' var='cocktail'>
           <li>${cocktail.name}
               ${cocktail.rating}
            <span class="fa fa-star ${cocktail.rating > 0 ? "checked" : ""}"></span>
            <span class="fa fa-star ${cocktail.rating > 1 ? "checked" : ""}"></span>
            <span class="fa fa-star ${cocktail.rating > 2 ? "checked" : ""}"></span>
            <span class="fa fa-star ${cocktail.rating > 3 ? "checked" : ""}"></span>
            <span class="fa fa-star ${cocktail.rating > 4 ? "checked" : ""}"></span>
               <span class="voters" >(${cocktail.voters})</span>
               <form method="get" action="/cocktailpage">
                   <button>
                       <input type="hidden" name="id" value=${cocktail.id} />
                   </button>
               </form>

           </li>

        </c:forEach>
    </ul>
</body>
</html>
