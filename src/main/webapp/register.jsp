<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/16/2021
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
-->

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="style/user.css"/>
    <script src="scripts/register.js" defer></script>
</head>
<body>
<a class="main-page-link" href="/main"> Main Page </a>

<div class="confirm_password_body" style="height: 100%;">
    <form method="POST" class="confirm_password">
        <div class="space_between">
            <label for="username">Username <span> * </span></label>
            <input class="input_password type="text" name="username" placeholder="Username" required/>
        </div>
        <div class="space_between">
            <label for="password">Password <span> * </span></label>
            <input class="input_password type="password" name="password" placeholder="********" required/>
        </div>
        <div class="space_between">
            <label for="name">Name <span> * </span></label>
            <input class="input_password type="text" name="name" placeholder="Name" required/>
        </div>
        <div class="space_between">
            <label for="surname">Surname <span> * </span></label>
            <input class="input_password type="text" name="surname" placeholder="Surname" required/>
        </div>

        <button type="submit" class="submit_button">Register</button>

        <div class="wrong_password">
            <p class="error-text">${error}</p>
        </div>
    </form>
</div>
</body>
</html>
