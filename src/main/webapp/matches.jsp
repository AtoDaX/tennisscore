<%@ page import="java.util.List" %>
<%@ page import="edu.pet.tennis.models.Match" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
    <title>Recent matches</title>
</head>
<body>
<h1>Recent matches:</h1>
<p>
<form action="matches" method="get" name="playerfilter">
    Player: <input type="text" name="filter_by_player_name" placeholder="Player name" >
    <input type="submit" value="Find">
</form>
</p>
<c:if test="${size>0}">

    <p>
    <table border="1" cellpadding="3">
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

    <table border="1" cellpadding="5" cellspacing="5">
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
    <p>No matches!</p>
</c:if>


<div>
    <a href="/tennis_war_exploded">Main page</a>
    <a href="new-match">New match</a>
</div>



</body>
</html>
