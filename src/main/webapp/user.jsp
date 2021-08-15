<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Cocktail" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% List<Cocktail> cocktails = (List)session.getAttribute("cocktails");%>

<head>
    <link rel="stylesheet" href="./style/user.css">
</head>

<body>
<div>Welcome ${user.getName()} ${user.getSurname()}</div>
<div>Username: ${user.getUsername()}</div>
<a>Change Password</a>

<div class="splide">
    <div class="splide__track">
        <ul class="splide__list">
            <c:forEach items="${cocktails}" var="cocktail">
                <li class="splide__slide">

                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/css/splide.min.css">
<script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/js/splide.min.js"></script>
<script src="scripts/user.js"></script>

</body>

</html>