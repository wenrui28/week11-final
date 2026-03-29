package com.example.week11soccerapp.ui;

import com.example.week11soccerapp.data.DataProvider;
import com.example.week11soccerapp.data.PlayerRepository;
import com.example.week11soccerapp.data.Repository;
import com.example.week11soccerapp.model.Player;

public class PlayersFragment extends BaseEntityListFragment<Player> {
    @Override
    protected Repository<Player> createRepository() {
        PlayerRepository repository = new PlayerRepository();
        repository.addAll(DataProvider.forPlayers().getItems());
        return repository;
    }

    @Override
    protected String getSubtitle(Player item) {
        return item.getPosition() + " • " + item.getTeam() + "\n" +
                item.getCountry() + " • Age " + item.getAge() + " • #" + item.getJerseyNumber();
    }

    @Override
    protected String getEntityLabel() {
        return "Players";
    }
}
