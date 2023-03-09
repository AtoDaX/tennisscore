<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New match</title>
</head>
<body>
    <h1>Create new match</h1>
    <form action="new-match" method="post" name="newmatchform">
        First player: <input type="text" name="player1" placeholder="P1 name" required><br>
        Second player: <input type="text" name="player2" placeholder="P2 name" required><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>
