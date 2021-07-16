<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/16/2021
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <a href="/register">Register </a>

    <h1>${head}</h1>

    <form method = POST>
        <label for="username">Username</label>
        <input type="text" name="username" /><br/>
        <label for="password">Password</label>
        <input type="password" name = "password" /><br/>
        <button type="submit">Login</button>
    </form>
</body>
</html>
