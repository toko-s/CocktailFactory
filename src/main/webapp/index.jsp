<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.08.2021
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
    <a href="/main">
        <button class="neon-button">Cocktail Factory</button>
    </a>


    <script>
        const button = document.querySelector('.neon-button')
        button.addEventListener('pointerdown', (event) => {
            event.target.classList.add('active');
        });

        button.addEventListener('pointerup', (event) => {
            event.target.classList.remove('active');
        });

        button.addEventListener('pointerout', (event) => {
            event.target.classList.remove('active');
        });

    </script>
</body>
</html>