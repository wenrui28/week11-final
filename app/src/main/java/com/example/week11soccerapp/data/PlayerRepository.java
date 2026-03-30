package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.Player;

import java.util.List;

public class PlayerRepository extends Repository<Player> {
    public List<Player> filterByTeam(String team) {
        if (team == null || team.trim().isEmpty()) {
            throw new IllegalArgumentException("Team cannot be empty.");
        }
        return filter(player -> player.getTeam().equalsIgnoreCase(team.trim()));
    }
}
