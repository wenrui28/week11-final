package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.Match;

import java.util.List;

public class MatchRepository extends Repository<Match> {
    public List<Match> filterByTeam(String team) {
        if (team == null || team.trim().isEmpty()) {
            throw new IllegalArgumentException("Team cannot be empty.");
        }
        String value = team.trim();
        return filter(match ->
                match.getHomeTeam().equalsIgnoreCase(value) || match.getAwayTeam().equalsIgnoreCase(value));
    }
}
