package com.sg.crackthecode2.data;
import com.sg.crackthecode2.models.Game;
import com.sg.crackthecode2.models.Round;

import java.util.List;

public interface GameDao {

    Game add(Game game, String solution);

    void addRound(int gameid, Round round);

    Game findById(int id);

    List<Game> getAll();

    void setGameFinishedToTrue(int id);

    List<Round> getGameRounds(int gameId);
    //METHODS BELOW ARE NON JDCBTEMPLATE AND WORK FINE
    // Game add(Integer id, Game game);    //  Adding game to inMemoryDao

    //Hashtable<Integer, Game> getAll();   // Retrieve all games

    //Game findById(int id);  // Retrieve a specific game

}
