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

<div class="nav">
    <a href="/tennis_war_exploded">Tennis scoreboard</a>
    <a href="new-match">New match</a>
    <a href="matches">Recent matches</a>
    <div class="search-container">
        <form action="matches" method="get" name="playerfilter">
            <input type="text" placeholder="Player name..." name="filter_by_player_name">
            <button type="submit">Find...</button>
        </form>

    </div>
</div>
  <div class="content">
      <h1>Match ${uuid} is finished!</h1>
    <h2>Final score: ${p1name} ${p1set} - ${p2set} ${p2name}</h2>
  </div>
<div class="footer">
    <p>footer</p>
</div>
</body>
</html>
