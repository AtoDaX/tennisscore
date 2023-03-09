package edu.pet.tennis.servlets;

import edu.pet.tennis.controller.RecentMatchesController;
import edu.pet.tennis.models.Match;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MatchesServlet", value = "/matches")
public class MatchesServlet extends HttpServlet {
    RecentMatchesController recentMatchesController = new RecentMatchesController();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recentMatchesController.handleGet(request);
        request.getRequestDispatcher("matches.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
