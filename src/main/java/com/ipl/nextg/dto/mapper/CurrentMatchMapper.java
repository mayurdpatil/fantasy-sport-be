package com.ipl.nextg.dto.mapper;

import com.ipl.nextg.dto.CurrentMatch;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

@NoArgsConstructor
@Getter
@Setter
public class CurrentMatchMapper implements RowMapper<CurrentMatch> {

  private Integer maxAttempts;

  public CurrentMatchMapper(Integer maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  public CurrentMatch mapRow(ResultSet rs, int rowNum) throws SQLException{
    CurrentMatch match = new CurrentMatch();
    match.setId(rs.getInt("id"));
    match.setCity(rs.getString("city"));
    match.setTime(rs.getString("time"));
    match.setDate(rs.getString("date"));
    match.setScore(rs.getInt("score"));
    match.setLocalTeamName(rs.getString("localTeamName"));
    match.setGuestTeamName(rs.getString("guestTeamName"));
    match.setLocalTeamId(rs.getInt("localTeamId"));
    match.setGuestTeamId(rs.getInt("guestTeamId"));
    match.setLocalTeamLogo(rs.getString("localTeamLogo"));
    match.setGuestTeamLogo(rs.getString("guestTeamLogo"));
    match.setEarnedScore(rs.getInt("earnedScore"));
    match.setSelectedTeamId(rs.getInt("selectedTeamId"));
    match.setConsumedAttempts(rs.getInt("consumedAttempts"));
    match.setMaxAllowedAttempts(maxAttempts);
    return match;
  }
}