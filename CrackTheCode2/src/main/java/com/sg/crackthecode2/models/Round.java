package com.sg.crackthecode2.models;

public class Round {
    private int roundid;
    private int gameid;
    private int exactMatch;
    private int partialmatch;
    private String result;
    private String dateTime;

    public Round() {}
    public int getExactMatch()  {   return exactMatch;  }

    public int getPartialmatch()    {   return partialmatch;    }

    public void setExactMatch(int eMatch)   {this.exactMatch = eMatch;}

    public void setPartialmatch(int pMatch) {this.partialmatch = pMatch;}

    public void setRoundid(int id) {this.roundid = id;}

    public void setGameid(int id) {this.gameid = id;};

    public void setDateTime(String datetime){this.dateTime = new String(datetime);}

    public String getDateTime() {   return this.dateTime;   }

    public void setResult(String result) {  this.result = result;   }
}
