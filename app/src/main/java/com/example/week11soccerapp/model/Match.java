package com.example.week11soccerapp.model;

public class Match implements SoccerEntity {
    private final String id;
    private final String homeTeam;
    private final String awayTeam;
    private final String score;
    private final String competition;
    private final String date;
    private final String venue;

    public Match(String homeTeam, String awayTeam, String score, String competition, String date, String venue) {
        if (isBlank(homeTeam) || isBlank(awayTeam) || isBlank(score) || isBlank(competition)
                || isBlank(date) || isBlank(venue)) {
            throw new IllegalArgumentException("Match fields cannot be empty.");
        }
        this.homeTeam = homeTeam.trim();
        this.awayTeam = awayTeam.trim();
        this.score = score.trim();
        this.competition = competition.trim();
        this.date = date.trim();
        this.venue = venue.trim();
        this.id = (this.homeTeam + "_vs_" + this.awayTeam + "_" + this.date).toLowerCase().replace(" ", "_");
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
        return homeTeam + " vs " + awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }

    public String getCompetition() {
        return competition;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String getSearchText() {
        return (homeTeam + " " + awayTeam + " " + score + " " + competition + " " + date + " " + venue).toLowerCase();
    }
}
