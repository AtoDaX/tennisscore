package edu.pet.tennis.services;

import edu.pet.tennis.models.Match;
public class MatchScoreCalculationService {

    public static void winPoint(String uuid, int playerIdWinPoint) {
        if (OngoingMatchesService.get(uuid).isEmpty()){
            return;
        }
        Match currentMatch = OngoingMatchesService.get(uuid).get();
        if (playerIdWinPoint == 1) {
            currentMatch.getScore().winPointsPlayer(1,2);
        } else if (playerIdWinPoint == 2){
            currentMatch.getScore().winPointsPlayer(2,1);
        }
    }
}
