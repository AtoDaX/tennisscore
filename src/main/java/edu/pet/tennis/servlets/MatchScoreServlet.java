package edu.pet.tennis.servlets;

import edu.pet.tennis.controller.MatchScoreController;
import edu.pet.tennis.models.Match;
import edu.pet.tennis.services.FinishedMatchesPersistenceService;
import edu.pet.tennis.services.MatchScoreCalculationService;
import edu.pet.tennis.services.OngoingMatchesService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MatchScoreServlet", value = "/match-score")
public class MatchScoreServlet extends HttpServlet {
    MatchScoreController matchScoreController = new MatchScoreController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid;
        uuid = request.getParameter("uuid");
        if(request.getParameterMap().isEmpty()){
            response.sendError(400,"No parameters!");
        }
        if (uuid.isBlank()){
            response.sendError(400,"Invalid uuid!");
            return;
        }
        if (OngoingMatchesService.get(uuid).isEmpty()){
            response.sendError(400,"No match with this uuid");
            return;
        }

        matchScoreController.handleGet(request,uuid);
        if (request.getAttribute("winner") != null){
            request.getRequestDispatcher("final-score.jsp").forward(request,response);
        }
        request.setAttribute("uuid", uuid);
        request.getRequestDispatcher("match-score.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        matchScoreController.handlePost(request,uuid);

        String redirect = String.format("/tennis_war_exploded/match-score?uuid=%s",uuid);
        response.sendRedirect(redirect);
    }
}
