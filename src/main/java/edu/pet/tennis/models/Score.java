package edu.pet.tennis.models;

import java.util.*;

public class Score {

    private static int playerNumber;
    private final Map<Integer, List<Integer>> scorePlayers;
    private final int countSetsToWin;
    private boolean matchEnd;

    public Score() {
        playerNumber = 0;
        scorePlayers = new HashMap<>();
        countSetsToWin = 2;
        matchEnd = false;
    }

    public void initializationPlayersAndScore() {
        List<Integer> pointsGamesSetsAd = new ArrayList<>();
        Collections.addAll(pointsGamesSetsAd, 0, 0, 0, 0);
        scorePlayers.put(++playerNumber, pointsGamesSetsAd);
    }

    public void winPointsPlayer(int winPlayerNumber, int losePlayerNumber) {
        int pointsWinPlayer = scorePlayers.get(winPlayerNumber).get(0);
        int pointsLosePlayer = scorePlayers.get(losePlayerNumber).get(0);

        if (!matchEnd) {
            if (pointsWinPlayer < 30) {
                pointsWinPlayer += 15;
                scorePlayers.get(winPlayerNumber).set(0, pointsWinPlayer);
            } else if (pointsWinPlayer == 30) {
                pointsWinPlayer += 10;
                scorePlayers.get(winPlayerNumber).set(0, pointsWinPlayer);
            } else if (pointsWinPlayer == 40) {
                scoreAfterFortyPoints(winPlayerNumber, losePlayerNumber, pointsWinPlayer, pointsLosePlayer);
            }
        }
    }

    private void scoreAfterFortyPoints(int winPlayerNumber, int losePlayerNumber, int pointsWinPlayer, int pointsLosePlayer) {
        if ((pointsWinPlayer - pointsLosePlayer) >= 10) {
            scorePlayers.get(winPlayerNumber).set(0, 0);
            scorePlayers.get(losePlayerNumber).set(0, 0);
            winGamePlayer(winPlayerNumber, losePlayerNumber);
        } else if (scorePlayers.get(winPlayerNumber).get(3) == 1 && scorePlayers.get(losePlayerNumber).get(3) == 0) {
            scorePlayers.get(winPlayerNumber).set(3, 0);
            scorePlayers.get(winPlayerNumber).set(0, 0);
            scorePlayers.get(losePlayerNumber).set(0, 0);
            winGamePlayer(winPlayerNumber, losePlayerNumber);
        } else if (scorePlayers.get(winPlayerNumber).get(3) == 0 && scorePlayers.get(losePlayerNumber).get(3) == 1){
            scorePlayers.get(winPlayerNumber).set(3, 0);
            scorePlayers.get(losePlayerNumber).set(3, 0);
        } else {
            scorePlayers.get(winPlayerNumber).set(3, 1);
            scorePlayers.get(losePlayerNumber).set(3, 0);
        }
    }

    private void winGamePlayer(int winPlayerNumber, int losePlayerNumber) {
        int gamesOfWinPlayer = scorePlayers.get(winPlayerNumber).get(1);
        int gamesOfLosePlayer = scorePlayers.get(losePlayerNumber).get(1);

        if (gamesOfWinPlayer >= 5 && (gamesOfWinPlayer - gamesOfLosePlayer) >= 1) {
            scorePlayers.get(winPlayerNumber).set(1, 0);
            scorePlayers.get(losePlayerNumber).set(1, 0);
            winSetPlayer(winPlayerNumber);
        } else {
            gamesOfWinPlayer++;
            scorePlayers.get(winPlayerNumber).set(1, gamesOfWinPlayer);
        }
    }

    private void winSetPlayer(int winPlayerNumber) {
        int setsOfWinPlayer = scorePlayers.get(winPlayerNumber).get(2);

        if (setsOfWinPlayer == countSetsToWin - 1) {
            setsOfWinPlayer++;
            scorePlayers.get(winPlayerNumber).set(2, setsOfWinPlayer);
            matchEnd = true;
        } else {
            setsOfWinPlayer++;
            scorePlayers.get(winPlayerNumber).set(2, setsOfWinPlayer);
        }
    }

    public String getPointsPlayer(int playerNumber) {
        if (scorePlayers.get(playerNumber).get(3) == 1) {
            return "Ad";
        } else {
            return String.valueOf(scorePlayers.get(playerNumber).get(0));
        }
    }

    public int getGamePlayer(int playerNumber) {
        return scorePlayers.get(playerNumber).get(1);
    }

    public int getSetPlayer(int playerNumber) {
        return scorePlayers.get(playerNumber).get(2);
    }

    public boolean isMatchEnd() {
        return matchEnd;
    }
}