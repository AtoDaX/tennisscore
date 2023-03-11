<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tennis scoreboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="nav">
    <a class="current" href="/tennis_war_exploded">Tennis scoreboard</a>
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
        <h1>Content</h1>
    </div>
    <div class="footer">
        <p>footer</p>
    </div>

</body>
</html>