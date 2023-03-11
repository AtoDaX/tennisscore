<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New match</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="nav">
        <a href="/tennis_war_exploded">Tennis scoreboard</a>
        <a class="current" href="new-match">New match</a>
        <a href="matches">Recent matches</a>
        <div class="search-container">
            <form action="matches" method="get" name="playerfilter">
                <input type="text" placeholder="Player name..." name="filter_by_player_name">
                <button type="submit">Find...</button>
            </form>

        </div>
    </div>

    <div class="content">

        <h1>New match</h1>


        <form class="new-match" action="new-match" method="post" name="newmatchform">
            <div class="formcontainer">
                <div class="input-container">
                <label for="player1"><strong>Player 1 name</strong></label>
                <input type="text" name="player1" id="player1" placeholder="P1 name" required >
                <label for="player2"><strong>Player 2 name</strong></label>
                <input type="text" name="player2" id="player2" placeholder="P2 name" required >
                <input type="submit" value="Start match!">
                </div>
            </div>
        </form>

    </div>
    <div class="footer">
        <p>footer</p>
    </div>
</body>
</html>
