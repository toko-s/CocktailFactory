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
    <link rel="stylesheet" href="style/register.css"/>
    <script src="scripts/register.js" defer></script>
</head>
<body>
<a class="main-page-link" href="/"> Main Page </a>

<div class="container">
    <form method="POST">
        <div>
            <label for="username">Username <span> * </span></label>
            <input type="text" name="username" placeholder="Username" required/>
        </div>
        <div>
            <label for="password">Password <span> * </span></label>
            <input type="password" name="password" placeholder="********" required/>
        </div>
        <div>
            <label for="name">Name <span> * </span></label>
            <input type="text" name="name" placeholder="Name" required/>
        </div>
        <div>
            <label for="surname">Surname <span> * </span></label>
            <input type="text" name="surname" placeholder="Surname" required/>
        </div>
        <div class="error">
            <p class="error-text">${error}</p>
        </div>
        <button type="submit" class="btn">Register</button>
    </form>
</div>
</body>
</html>
