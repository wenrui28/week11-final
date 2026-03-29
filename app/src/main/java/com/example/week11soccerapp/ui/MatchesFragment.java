package com.example.week11soccerapp.ui;

import com.example.week11soccerapp.data.DataProvider;
import com.example.week11soccerapp.data.MatchRepository;
import com.example.week11soccerapp.data.Repository;
import com.example.week11soccerapp.model.Match;

public class MatchesFragment extends BaseEntityListFragment<Match> {
    @Override
    protected Repository<Match> createRepository() {
        MatchRepository repository = new MatchRepository();
        repository.addAll(DataProvider.forMatches().getItems());
        return repository;
    }

    @Override
    protected String getSubtitle(Match item) {
        return item.getCompetition() + " • " + item.getScore() + "\n" +
                item.getDate() + " • " + item.getVenue();
    }

    @Override
    protected String getEntityLabel() {
        return "Matches";
    }
}
