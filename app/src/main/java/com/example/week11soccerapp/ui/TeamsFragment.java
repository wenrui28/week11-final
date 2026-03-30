package com.example.week11soccerapp.ui;

import com.example.week11soccerapp.data.DataProvider;
import com.example.week11soccerapp.data.Repository;
import com.example.week11soccerapp.data.TeamRepository;
import com.example.week11soccerapp.iterator.TeamIterator;
import com.example.week11soccerapp.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamsFragment extends BaseEntityListFragment<Team> {
    @Override
    protected Repository<Team> createRepository() {
        TeamRepository repository = new TeamRepository();
        List<Team> original = DataProvider.forTeams().getItems();
        TeamIterator iterator = new TeamIterator(original);
        List<Team> iterated = new ArrayList<>();
        while (iterator.hasNext()) {
            iterated.add(iterator.next());
        }
        repository.addAll(iterated);
        return repository;
    }

    @Override
    protected String getSubtitle(Team item) {
        return item.getCountry() + " • " + item.getLeague() + "\n" +
                item.getStadium() + " • Founded " + item.getFoundedYear();
    }

    @Override
    protected String getEntityLabel() {
        return "Teams";
    }
}
