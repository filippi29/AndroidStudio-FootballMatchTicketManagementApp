package com.example.septemvris_2023lisi;

public class Game {
    String teams;
    int seats;
    int diarkeias;
    public Game(String teams, int tickets1, int tickets2){
        this.teams = teams;
        this.seats = tickets1;
        this.diarkeias = tickets2;
    }

    //getter gia to teams
    public String getTeams() {
        return teams;
    }

    public int availibleTickets(){
        return seats - diarkeias;    //επιστρεφει διαθεσιμα εισητηρια
    }
}
