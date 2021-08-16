<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <% String message = (String)session.getAttribute("message");%>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./style/user.css">
</head>
<body class="confirm_password_body">
<form method="POST" class="confirm_password">
    <label for="password">Confirm Password</label>
    <input placeholder="Password" class="input_password" type="password" name="password" id="password"/>
    <button class="submit_button">Submit</button>

    <span class="wrong_password ${message == null ? "hidden" : ""}">${message}</span>
</form>
</body>
</html>
