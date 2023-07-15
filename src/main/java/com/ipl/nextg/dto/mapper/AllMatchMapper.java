package com.ipl.nextg.dto.mapper;

import com.ipl.nextg.dto.AllMatch;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

@NoArgsConstructor
@Getter
@Setter
public class AllMatchMapper implements RowMapper<AllMatch> {

  private Integer maxAttempts;

  public AllMatchMapper(Integer maxAttempts) {
    this.maxAttempts = maxAttempts;
  }

  public AllMatch mapRow(ResultSet rs, int rowNum) throws SQLException{
    AllMatch match = new AllMatch();
    match.setId(rs.getInt("id"));
    match.setCity(rs.getString("city"));
    match.setMatchStartTime(rs.getString("matchStartTime"));
    match.setScore(rs.getInt("score"));
    match.setLocalTeamName(rs.getString("localTeamName"));
    match.setGuestTeamName(rs.getString("guestTeamName"));
    match.setLocalTeamId(rs.getInt("localTeamId"));
    match.setGuestTeamId(rs.getInt("guestTeamId"));
    match.setLocalTeamLogo(rs.getString("localTeamLogo"));
    match.setGuestTeamLogo(rs.getString("guestTeamLogo"));
    match.setResult(rs.getString("result"));
    match.setWinningTeamId(rs.getInt("winningTeamId"));
    return match;
  }
}