<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.07.2021
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="style/user.css">
</head>
<body>
    <div>Welcome ${user.getName()} ${user.getSurname()}</div>
    <div>Username: ${user.getUsername()}</div>
    <a>Change Password</a>

    <div class="splide">
    <div class="splide__track">
        <ul class="splide__list">
            <li class="splide__slide">Slide 01</li>
            <li class="splide__slide">Slide 02</li>
            <li class="splide__slide">Slide 03</li>
            <li class="splide__slide">Slide 04</li>
            <li class="splide__slide">Slide 05</li>
        </ul>
    </div>
    </div>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/css/splide.min.css">
    <script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/js/splide.min.js"></script>
    <script src="scripts/user.js"></script>

</body>
</html>
