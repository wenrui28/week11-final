package com.example.week11soccerapp.model;

public class Team implements SoccerEntity {
    private final String id;
    private final String name;
    private final String country;
    private final String league;
    private final String stadium;
    private final int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        if (isBlank(name) || isBlank(country) || isBlank(league) || isBlank(stadium)) {
            throw new IllegalArgumentException("Team fields cannot be empty.");
        }
        if (foundedYear < 1800 || foundedYear > 2100) {
            throw new IllegalArgumentException("Invalid founded year.");
        }
        this.name = name.trim();
        this.country = country.trim();
        this.league = league.trim();
        this.stadium = stadium.trim();
        this.foundedYear = foundedYear;
        this.id = this.name.toLowerCase().replace(" ", "_");
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

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    @Override
    public String getSearchText() {
        return (name + " " + country + " " + league + " " + stadium).toLowerCase();
    }
}
