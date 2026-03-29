package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.Match;

import java.util.List;

public class MatchRepository extends Repository<Match> {
    public List<Match> filterByTeam(String team) {
        return filter(match ->
                match.getHomeTeam().equalsIgnoreCase(team) || match.getAwayTeam().equalsIgnoreCase(team));
    }
}
