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
</head>
<body>
    <div>Welcome ${user.getName()} ${user.getSurname()}</div>
    <div>Username: ${user.getUsername()}</div>
    <a>Change Password</a>
</body>
</html>
