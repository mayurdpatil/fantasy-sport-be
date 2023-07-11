package com.ipl.nextg.dto.mapper;

import com.ipl.nextg.response.Leaderboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LeaderboardMapper implements RowMapper<Leaderboard> {

  public Leaderboard mapRow(ResultSet rs, int rowNum) throws SQLException{
    Leaderboard lb = new Leaderboard();
    lb.setUsrId(rs.getInt("usr_id"));
    lb.setName(rs.getString("usr_fname").concat(" "). concat(rs.getString("usr_lname")));
    lb.setUsrProfile(rs.getString("usr_profile"));
    lb.setUsrRating(rs.getInt("usr_rating"));
    lb.setUsrGender(rs.getString("usr_gender"));
    return lb;
  }
}