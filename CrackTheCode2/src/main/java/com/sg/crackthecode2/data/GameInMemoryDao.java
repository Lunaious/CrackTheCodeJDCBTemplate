package com.sg.crackthecode2.data;

/*
// THIS IS THE OLD CLASS WE'RE NOW REPLACING WITH GAMEDATABASEDAO CLASS
// FOR NOW LEAVE IT AS IS
@Repository
public class GameInMemoryDao implements GameDao { // MyDB
    private static final Hashtable<Integer,Game> games = new Hashtable<>();

    //DON'T CHANGE ANY OF THE METHODS BELOW
    @Override
    public Game add(Integer id, Game game){
        games.put(id, game);
        return game;
    }

    @Override
    public Hashtable<Integer, Game> getAll() {   // Return to implement
        return games;
    }

    @Override
    public Game findById(int id) {  // Return to implement
        if(games.containsKey(id))   return games.get(id);
        else    return null;
    }

}
*/