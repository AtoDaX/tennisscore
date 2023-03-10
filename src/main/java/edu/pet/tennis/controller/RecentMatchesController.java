package edu.pet.tennis.controller;

import edu.pet.tennis.models.Match;
import edu.pet.tennis.services.FinishedMatchesService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RecentMatchesController {
    public void handleGet(HttpServletRequest request){
        int page = 1;
        int recordsPerPage = 1;
        List<Match> allMatches;
        String filter=null;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        if (request.getParameter("filter_by_player_name") != null && !request.getParameter("filter_by_player_name").isBlank()){
            filter = request.getParameter("filter_by_player_name");
            allMatches = FinishedMatchesService.getFiltered(filter);
        } else {
            allMatches = FinishedMatchesService.getAll();
        }


        List<Match> matches = new ArrayList<>();
        if (allMatches.size()!=0){
            for (int i = (page-1)*recordsPerPage; i<page*recordsPerPage; i++){
                matches.add(allMatches.get(i));
            }
        }

        int noOfRecords = allMatches.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("matches", matches);
        request.setAttribute("filter_by_player_name",filter);
        request.setAttribute("size", matches.size());
    }
}
