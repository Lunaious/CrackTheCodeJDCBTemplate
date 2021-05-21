package com.sg.crackthecode2.models;

import java.util.ArrayList;

public class Game {
    private int gameId;
    //  private ArrayList<com.sg.crackthecode2.models.Round> rounds;
    private String solution;
    private boolean isFinished = false;

    public Game(){};
    public Game(int gameId, String solution)
    {
        this.gameId = gameId;
        this.solution = new String(solution);
        //this.rounds = new ArrayList<com.sg.crackthecode2.models.Round>();
    }

    public int getId()   {   return gameId;  }
    public void setId(int id) { this.gameId = id;   }

    public String getSolution() {return this.solution;}

    public void setSolution(String solution) {this.solution = new String(solution);}

    public boolean getIsFinished()    {return this.isFinished;}

    public void setIsFinishedToTrue() {this.isFinished = true;}

    public void setFinished(boolean finished) { this.isFinished = finished; }

    //public void addRound(com.sg.crackthecode2.models.Round round)   {   rounds.add(round);  }

    //public ArrayList<com.sg.crackthecode2.models.Round> getRounds() {   return rounds;  }
}
