package edu.pet.tennis.services;

import edu.pet.tennis.dao.MatchDao;
import edu.pet.tennis.models.Match;

import java.util.List;
import java.util.Optional;

public class FinishedMatchesPersistenceService {
    private static MatchDao matchDao = new MatchDao();

    public static void persist(String uuid){
        if (OngoingMatchesService.get(uuid).isEmpty()){
            return;
        }
        matchDao.save(OngoingMatchesService.get(uuid).get());
        OngoingMatchesService.remove(uuid);
    }

    public static Match get(int id){
        Optional<Match> optionalMatch = matchDao.findById(id);
        if (optionalMatch.isPresent()){
            return optionalMatch.get();
        } else {
            //throw ex? return type to optional?
            return null;
        }
    }

    public static List<Match> getFiltered(String filter){
        return matchDao.findMatchesByPlayer(filter);
    }

    public static List<Match> getAll(){
        return matchDao.findAll();
    }
}
