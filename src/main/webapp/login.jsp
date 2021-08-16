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
    <link rel="stylesheet" href="style/login.css" />
    <script src="scripts/register.js" defer></script>
  </head>
  <body>
    <a href="/register">Register </a>
    <div class="container">
      <form method="POST">
        <div class="username">
          <label for="username">Username</label>
          <input type="text" name="username" value='${name}' /><br />
        </div>
        <div class="password">
          <label for="password">Password</label>
          <input type="password" name="password" /><br />
        </div>
        <div class="error">
          <p class="error-text">${head}</p>
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </body>
</html>
