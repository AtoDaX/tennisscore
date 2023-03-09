package edu.pet.tennis.services;

import edu.pet.tennis.dao.PlayerDao;
import edu.pet.tennis.models.Match;
import edu.pet.tennis.models.Player;

import java.util.Optional;

public class MatchGenerationService {
    private static final PlayerDao playerDao = new PlayerDao();

    public static Match generateMatch(String player1Name, String player2Name){
        Optional<Player> p1 = playerDao.findByName(player1Name);
        Optional<Player> p2 = playerDao.findByName(player2Name);

        Player player1;
        Player player2;

        if (p1.isPresent()){
            player1 = p1.get();
        } else {
            Player toInsert = new Player();
            toInsert.setName(player1Name);
            playerDao.save(toInsert);
            player1 = playerDao.findByName(player1Name).get();
        }
        if (p2.isPresent()){
            player2 = p2.get();
        } else {
            Player toInsert = new Player();
            toInsert.setName(player2Name);
            playerDao.save(toInsert);
            player2 = playerDao.findByName(player2Name).get();
        }
        Match newMatch = new Match();
        newMatch.setPlayer1(player1);
        newMatch.setPlayer2(player2);
        return newMatch;
    }
}
