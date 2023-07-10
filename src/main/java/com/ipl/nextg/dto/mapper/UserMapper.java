package com.ipl.nextg.dto.mapper;

import com.ipl.nextg.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int rowNum) throws SQLException{
    User user = new User();
    user.setUsrId(rs.getInt("usr_id"));
    user.setUsrFname(rs.getString("usr_fname"));
    user.setUsrLname(rs.getString("usr_lname"));
    user.setUsrEmail(rs.getString("usr_email"));
    user.setUsrProfile(rs.getString("usr_profile"));
    user.setUsrType(rs.getInt("usr_type"));
    user.setUsrGender(rs.getString("usr_gender"));
    user.setUsrStatus(rs.getString("usr_status"));
    user.setUsrRating(rs.getInt("usr_rating"));
    user.setUsrLastLoginOn(rs.getString("usr_last_login"));
    return user;
  }
}