package edu.pet.tennis.services;

import edu.pet.tennis.models.Match;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class OngoingMatchesService {
    private static  Map<String, Match> ongoingMatches = new HashMap<String, Match>();

    public static String put(Match match){
        String uuid = UUID.randomUUID().toString();
        while (ongoingMatches.containsKey(uuid)){
            uuid = UUID.randomUUID().toString();
        }
        ongoingMatches.put(uuid,match);
        return uuid;
    }

    public static void remove(String uuid){
        ongoingMatches.remove(uuid);
    }

    public static Optional<Match> get(String uuid){
        if (ongoingMatches.containsKey(uuid)){
            return Optional.of(ongoingMatches.get(uuid));
        } else {
            return Optional.empty();
        }

    }

}
