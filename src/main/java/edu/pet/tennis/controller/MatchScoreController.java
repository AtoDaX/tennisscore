package edu.pet.tennis.controller;

import edu.pet.tennis.models.Match;
import edu.pet.tennis.services.FinishedMatchesPersistenceService;
import edu.pet.tennis.services.MatchScoreCalculationService;
import edu.pet.tennis.services.OngoingMatchesService;
import jakarta.servlet.http.HttpServletRequest;

public class MatchScoreController {
    public void handleGet(HttpServletRequest request, String uuid){

        Match ongoing = OngoingMatchesService.get(uuid).get();

        boolean isEnd = ongoing.getScore().isMatchEnd();

        String p1score = ongoing.getScore().getPointsPlayer(1);
        int p1game = ongoing.getScore().getGamePlayer(1);
        int p1set = ongoing.getScore().getSetPlayer(1);


        String p2score = ongoing.getScore().getPointsPlayer(2);
        int p2game = ongoing.getScore().getGamePlayer(2);
        int p2set = ongoing.getScore().getSetPlayer(2);

        request.setAttribute("uuid", uuid);
        request.setAttribute("p1name",ongoing.getPlayer1().getName());
        request.setAttribute("p1score", p1score);
        request.setAttribute("p1game",p1game);
        request.setAttribute("p1set",p1set);

        request.setAttribute("p2score",p2score);
        request.setAttribute("p2name",ongoing.getPlayer2().getName());
        request.setAttribute("p2game", p2game);
        request.setAttribute("p2set",p2set);

        if (isEnd && p1set>p2set){
            ongoing.setWinner(ongoing.getPlayer1());
            request.setAttribute("winner",ongoing.getPlayer1().getName());
            FinishedMatchesPersistenceService.persist(uuid);

        } else if (isEnd && p2set>p1set){
            ongoing.setWinner(ongoing.getPlayer2());
            request.setAttribute("winner",ongoing.getPlayer2().getName());
            FinishedMatchesPersistenceService.persist(uuid);
        }

    }

    public void handlePost(HttpServletRequest request, String uuid){
        int numberOfScored;
        try {
            numberOfScored = Integer.parseInt(request.getParameter("pscored"));
        } catch (NumberFormatException e){
            return;
        }

        MatchScoreCalculationService.winPoint(uuid,numberOfScored);
    }
}
