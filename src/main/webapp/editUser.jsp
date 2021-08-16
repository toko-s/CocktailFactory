<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<% User user = (User)session.getAttribute("user");%>
<% String password = (String)session.getAttribute("password");%>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./style/user.css">
</head>
<body class="confirm_password_body">
<form method="POST" class="confirm_password">
    <label for="username">Username</label>
    <input value="${user.getUsername()}" class="change_item" type="text" name="username" id="username"/>

    <label for="password">Password</label>
    <input placeholder="${password}" class="change_item" type="password" name="password" id="password"/>

    <label for="name">Name</label>
    <input value="${user.getName()}" class="change_item" type="text" name="name" id="name"/>

    <label for="surname">Surname</label>
    <input value="${user.getSurname()}" class="change_item" type="text" name="surname" id="surname"/>
    <button class="submit_button">Submit</button>
</form>
</body>
</html>
