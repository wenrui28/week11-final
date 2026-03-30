package com.example.week11soccerapp.model;

public class Player implements SoccerEntity {
    private final String id;
    private final String name;
    private final int age;
    private final String country;
    private final String position;
    private final String team;
    private final int jerseyNumber;

    public Player(String name, int age, String country, String position, String team, int jerseyNumber) {
        if (isBlank(name) || isBlank(country) || isBlank(position) || isBlank(team)) {
            throw new IllegalArgumentException("Player fields cannot be empty.");
        }
        if (age < 15 || age > 50) {
            throw new IllegalArgumentException("Player age is invalid.");
        }
        if (jerseyNumber < 1 || jerseyNumber > 99) {
            throw new IllegalArgumentException("Jersey number is invalid.");
        }
        this.id = name.trim().toLowerCase().replace(" ", "_");
        this.name = name.trim();
        this.age = age;
        this.country = country.trim();
        this.position = position.trim();
        this.team = team.trim();
        this.jerseyNumber = jerseyNumber;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String getSearchText() {
        return (name + " " + country + " " + position + " " + team + " #" + jerseyNumber).toLowerCase();
    }
}
