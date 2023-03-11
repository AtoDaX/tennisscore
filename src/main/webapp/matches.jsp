<%@ page import="java.util.List" %>
<%@ page import="edu.pet.tennis.models.Match" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Recent matches</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="nav">
    <a href="/tennis_war_exploded">Tennis scoreboard</a>
    <a href="new-match">New match</a>
    <a class="current" href="matches">Recent matches</a>
    <div class="search-container">
        <form action="matches" method="get" name="playerfilter">
            <input type="text" placeholder="Player name..." name="filter_by_player_name">
            <button type="submit">Find...</button>
        </form>

    </div>
</div>

<div class="content">
    <h1>Recent matches</h1>
            <c:if test="${size>0}">
            <table class="info">
                <tr>
                    <th>Player1</th>
                    <th>Player2</th>
                    <th>Winner</th>
                </tr>
                <c:forEach var="match" items="${matches}">
                    <tr>
                        <td>${match.getPlayer1().getName()}</td>
                        <td>${match.getPlayer2().getName()}</td>
                        <td>${match.getWinner().getName()}</td>
                    </tr>
                </c:forEach>
            </table>




                <table class="paginator">
                    <tr>
                        <c:if test="${currentPage != 1}">
                            <td><a href="matches?filter_by_player_name=${filter_by_player_name}&page=${currentPage - 1}">Previous</a></td>
                        </c:if>
                        <c:forEach begin="1" end="${noOfPages}" var="i">
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                    <td>${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="matches?filter_by_player_name=${filter_by_player_name}&page=${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${currentPage lt noOfPages}">
                            <td><a href="matches?filter_by_player_name=${filter_by_player_name}&page=${currentPage + 1}">Next</a></td>
                        </c:if>
                        </c:if>
                    </tr>
                </table>



            <c:if test="${size eq 0}">
                <h1>No matches!</h1>
            </c:if>
    </div>
<div class="footer">
    <p>footer</p>
</div>



</body>
</html>
