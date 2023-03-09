<%@ page import="java.util.List" %>
<%@ page import="edu.pet.tennis.models.Match" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recent matches</title>
</head>
<body>
  <h1>Recent matches:</h1>
    <p>
      <%
          List<Match> matches = (List<Match>) request.getAttribute("matches");
          response.getWriter().println("<table border=\"1\" cellpadding=\"3\">");
          response.getWriter().print("<tr>\n" +
                  "            <th>Player1</th>\n" +
                  "            <th>Player2</th>\n" +
                  "            <th>Winner</th>\n" +
                  "        </tr>");


          for (Match match : matches) {
              response.getWriter().println("<tr>");
              response.getWriter().println("<td>" + match.getPlayer1().getName() + "</td>");
              response.getWriter().println("<td>" + match.getPlayer2().getName() + "</td>");
              response.getWriter().println("<td>" + match.getWinner().getName() + "</td>");
              response.getWriter().println("</tr>");
          }
      %>
        </table>
    </p>

</body>
</html>
