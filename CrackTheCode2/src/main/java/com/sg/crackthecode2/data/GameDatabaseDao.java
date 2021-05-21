package com.sg.crackthecode2.data;

import com.sg.crackthecode2.models.Game;
import com.sg.crackthecode2.models.Game;
import com.sg.crackthecode2.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.List;

@Repository
public class GameDatabaseDao implements GameDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game add(Game game, String solution) {
        final String sql = "INSERT INTO game(game) VALUES(?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, solution);
            return statement;

        }, keyHolder);

        game.setId(keyHolder.getKey().intValue());
        game.setSolution(solution);

        return game;
    }

    @Override
    public void addRound(int gameid, Round round)
    {
        final String sql = "INSERT INTO rounds(gameId, exactmatches, partialmatches) VALUES(?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, String.valueOf(gameid));
            statement.setString(2, String.valueOf(round.getExactMatch()));
            statement.setString(3, String.valueOf(round.getPartialmatch()));
            return statement;

        }, keyHolder);
    }



    @Override
    public Game findById(int id) {

        //System.out.println("id to find: " + id);
        final String sql = "SELECT id, game, finished "
                + "FROM game WHERE id = ?;";

        return jdbcTemplate.queryForObject(sql, new GameMapper(), id);
    }



    @Override
    public List<Game> getAll() {
        final String sql = "SELECT id, game, finished FROM game;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    public void setGameFinishedToTrue(int id) {
        final String sql = "UPDATE game SET finished = true WHERE id = ?;";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, String.valueOf(id));
            return statement;

        }, keyHolder);
    }

    @Override
    public List<Round> getGameRounds(int gameId)
    {
        final String sql = "SELECT * FROM rounds WHERE gameid = " + gameId + " ORDER BY datetime;";
        return jdbcTemplate.query(sql, new RoundMapper());
    }




    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round td = new Round();
            //td.setRoundid(rs.getInt("roundid"));
            //td.setGameid(rs.getInt("gameid"));
            td.setExactMatch(rs.getInt("exactmatches"));
            td.setPartialmatch(rs.getInt("partialmatches"));
            td.setDateTime(rs.getString("datetime"));
            return td;
        }
    }






    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game td = new Game();
            td.setId(rs.getInt("id"));
            td.setSolution(rs.getString("game"));
            td.setFinished(rs.getBoolean("finished"));
            return td;
        }
    }

}