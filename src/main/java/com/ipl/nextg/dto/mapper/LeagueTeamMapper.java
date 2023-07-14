package com.ipl.nextg.dto.mapper;

import com.ipl.nextg.dto.LeagueTeam;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

@NoArgsConstructor
@Getter
@Setter
public class LeagueTeamMapper implements RowMapper<LeagueTeam> {

  public LeagueTeam mapRow(ResultSet rs, int rowNum) throws SQLException{
    LeagueTeam team = new LeagueTeam();
    team.setId(rs.getInt("id"));
    team.setName(rs.getString("name"));
    return team;
  }
}