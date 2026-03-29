package com.example.week11soccerapp.iterator;

import com.example.week11soccerapp.model.Team;
import java.util.List;

public class TeamIterator implements CustomIterator<Team> {
    private final List<Team> teams;
    private int index = 0;

    public TeamIterator(List<Team> teams) {
        if (teams == null) {
            throw new IllegalArgumentException("Team list cannot be null.");
        }
        this.teams = teams;
    }

    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more teams available.");
        }
        return teams.get(index++);
    }
}
