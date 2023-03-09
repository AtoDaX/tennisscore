
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
    <title>Match score</title>
</head>
<body>
    <h1>Match uuid: ${uuid}</h1>

    <p>
    <table border="1" cellpadding="3">
        <tbody >
        <tr>
            <td></td>
            <td>${p1name}</td>
            <td>${p2name}</td>
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
        </tbody>
    </table>
    </p>
    <p>
        <form action="match-score?uuid=${uuid}" method="post" name="scoredform">
        <button name = pscored value="1">${p1name} scored!</button>
        </form>
        <form action="match-score?uuid=${uuid}" method="post" name="scoredform">
            <button name="pscored" value="2">${p2name} scored!</button>
        </form>
    </p>
</body>
</html>
