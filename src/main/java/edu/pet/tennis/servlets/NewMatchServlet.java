package edu.pet.tennis.servlets;

import edu.pet.tennis.controller.MatchGeneratorController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NewMatchServlet", value = "/new-match")
public class NewMatchServlet extends HttpServlet {
    private final MatchGeneratorController matchGeneratorController = new MatchGeneratorController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("fads");
        request.getRequestDispatcher("new-match.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String player1Name = request.getParameter("player1");
        String player2Name = request.getParameter("player2");


        if (player1Name == null || player2Name == null){
            response.sendError(400,"Invalid player name!");
            return;
        }
        if (player1Name.isBlank() || player2Name.isBlank()){
            response.sendError(400,"Invalid player name!");
            return;
        }
        if(player1Name.equals(player2Name)){
            response.sendError(400, "Player names can't be same!");
            return;
        }
        String generatedUUID = matchGeneratorController.handlePost(player1Name,player2Name);
        String redirect = String.format("/tennis_war_exploded/match-score?uuid=%s",generatedUUID);
        response.sendRedirect(redirect);
        //request.getRequestDispatcher(redirect).forward(request,response);

    }
}
