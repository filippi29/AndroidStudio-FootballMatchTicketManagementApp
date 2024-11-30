package com.example.septemvris_2023lisi;

import java.util.ArrayList;

public class GameList {
    ArrayList<Game> gamesList = new ArrayList<>();
        public GameList() {

        }

        public void addGame(Game game) {
            gamesList.add(game);
        }

        //μεθοδος που θα καλει την availibleTickets απο την κλάση Game
        // για να βρισκει για την ΤΑΔΕ ομαδα ποσα εισητηρια εχει
        //θα επιστρέφει String για να το βαζουμε στο Toast
        public String calculateTickets(String teams){
            for(int i=0; i<gamesList.size(); i++){
                if(gamesList.get(i).getTeams().equals(teams)){
                    return gamesList.get(i).availibleTickets() + "";
                }

            }
            return "";
        }

}
