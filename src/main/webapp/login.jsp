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
    <script src="scripts/register.js" defer></script>
    <link rel="stylesheet" href="./style/user.css">
  </head>
  <body>
    <a href="/register">Register </a>
      <div class="confirm_password_body" style="height: 100%;">
        <form method="POST" class="confirm_password">
          <div class="username space_between">
            <label for="username">Username</label>
            <input class="input_password" type="text" name="username" value='${name}' /><br />
          </div>
          <div class="password space_between">
            <label for="password">Password</label>
            <input class="input_password" type="password" name="password" /><br />
          </div>
          <button class="submit_button" type="submit">Login</button>

          <div class="wrong_password">
            <p class="error-text">${head}</p>
          </div>
        </form>
      </div>
  </body>
</html>
