package edu.pet.tennis.controller;

import edu.pet.tennis.models.Match;
import edu.pet.tennis.services.MatchGenerationService;
import edu.pet.tennis.services.OngoingMatchesService;

public class MatchGeneratorController {
    public String handlePost(String player1Name, String player2Name){
        Match newMatch = MatchGenerationService.generateMatch(player1Name,player2Name);
        String uuid = OngoingMatchesService.put(newMatch);
        return uuid;
    }
}
