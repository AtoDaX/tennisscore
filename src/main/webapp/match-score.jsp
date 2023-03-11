
<%@ page import="edu.pet.tennis.models.Player" %><%--
  Created by IntelliJ IDEA.
  User: atopiraka
  Date: 08.03.2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Match score</title>
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

        <table class="info">
            <tr>
                <td></td>
                <th>${p1name}</th>
                <th>${p2name}</th>
            </tr>
            <tr>
                <td>Score</td>
                <td>${p1score}</td>
                <td>${p2score}</td>
            </tr>
            <tr>
                <td>Game</td>
                <td>${p1game}</td>
                <td>${p2game}</td>
            </tr>
            <tr>
                <td>Set</td>
                <td>${p1set}</td>
                <td>${p2set}</td>
            </tr>
        </table>

        <div class="score-form">
            <form class="scoreform" action="match-score?uuid=${uuid}" method="post" name="scoredform">
                <button name = pscored value="1">${p1name} scored!</button>
                <button name="pscored" value="2">${p2name} scored!</button>
            </form>
        </div>




</div>
<div class="footer">
    <p>footer</p>
</div>
</body>
</html>
