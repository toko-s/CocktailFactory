<%--
  Created by IntelliJ IDEA.
  User: Drama
  Date: 8/6/2021
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/test" ENCTYPE="multipart/form-data" method="post" enctype="multipart/form-data" >
    <input type="text" name="text">
    <input type="file" name="file" accept="image/*" />
    <input type="submit" />
</form>
</body>
</html>
