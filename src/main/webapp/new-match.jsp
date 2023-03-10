<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>New match</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<header>
    <h1>Create new match</h1>
</header>
    <div class="mainblock">
        <form action="new-match" method="post" name="newmatchform">
            First player: <input type="text" name="player1" placeholder="P1 name" required autocomplete="false"><br>
            Second player: <input type="text" name="player2" placeholder="P2 name" required autocomplete="false"><br>
            <input type="submit" value="Start match!">
        </form>
    </div>
</body>
</html>
