package com.example.scoreboard;

import java.util.ArrayList;
import java.util.Date;

public class Game {

    public static ArrayList<Game> gameArrayList = new ArrayList<>();

    private int id;
    private String oldGame;
    private String teamNameA;
    private String scoreA;
    private String teamNameB;
    private String scoreB;
    private Date played;

    public Game(int id, String oldGame, String teamNameA, String scoreA, String teamNameB, String scoreB, Date played) {
        this.id = id;
        this.oldGame = oldGame;
        this.teamNameA = teamNameA;
        this.scoreA = scoreA;
        this.teamNameB = teamNameB;
        this.scoreB = scoreB;
        this.played = played;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOldGame() {
        return oldGame;
    }

    public void setGame(String game) {
        this.oldGame = oldGame;
    }

    public String getTeamNameA() {
        return teamNameA;
    }

    public void setTeamNameA(String teamNameA) {
        this.teamNameA = teamNameA;
    }

    public String getScoreA() {
        return scoreA;
    }

    public void setScoreA(String scoreA) {
        this.scoreA = scoreA;
    }

    public String getTeamNameB() {
        return teamNameB;
    }

    public void setTeamNameB(String teamNameB) {
        this.teamNameB = teamNameB;
    }

    public String getScoreB() {
        return scoreB;
    }

    public void setScoreB(String scoreB) {
        this.scoreB = scoreB;
    }

    public Date getPlayed() {
        return played;
    }

    public void setPlayed(Date played) {
        this.played = played;
    }
}
