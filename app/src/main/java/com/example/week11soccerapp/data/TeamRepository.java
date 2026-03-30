package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.Team;

import java.util.List;
import java.util.stream.Collectors;

public class TeamRepository extends Repository<Team> {
    public List<Team> filterByLeague(String league) {
        if (league == null || league.trim().isEmpty()) {
            throw new IllegalArgumentException("League cannot be empty.");
        }
        return filter(team -> team.getLeague().equalsIgnoreCase(league.trim()));
    }

    public List<String> getLeagueNames() {
        return items.stream()
                .map(Team::getLeague)
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }
}
