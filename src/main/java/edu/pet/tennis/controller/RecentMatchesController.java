package edu.pet.tennis.controller;

import edu.pet.tennis.models.Match;
import edu.pet.tennis.services.FinishedMatchesPersistenceService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class RecentMatchesController {
    public void handleGet(HttpServletRequest request){
        List<Match> matches = FinishedMatchesPersistenceService.getAll();
        request.setAttribute("matches", matches);
    }
}
