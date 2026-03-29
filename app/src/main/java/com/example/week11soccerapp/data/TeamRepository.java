package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.Team;

import java.util.List;
import java.util.stream.Collectors;

public class TeamRepository extends Repository<Team> {
    public List<Team> filterByLeague(String league) {
        return filter(team -> team.getLeague().equalsIgnoreCase(league));
    }

    public List<String> getLeagueNames() {
        return items.stream()
                .map(Team::getLeague)
                .distinct()
                .sorted((a, b) -> a.compareToIgnoreCase(b))
                .collect(Collectors.toList());
    }
}
