<%--
  Created by IntelliJ IDEA.
  User: atopiraka
  Date: 09.03.2023
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Final score</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
  <h1>Match ${uuid} is finished!</h1>
</header>
  <div class="mainblock">
    <h2>Final score:</h2>
    <p>${p1name} ${p1set} - ${p2set} ${p2name}</p>
    <a href="/tennis_war_exploded">Main page</a>
    <a href="new-match">New match</a>
    <a href="matches">Recent matches</a>
  </div>
</body>
</html>
