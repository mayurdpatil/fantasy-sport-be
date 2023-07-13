package com.ipl.nextg.dao;

import com.ipl.nextg.dto.AllMatch;
import com.ipl.nextg.dto.CurrentMatch;
import com.ipl.nextg.dto.mapper.AllMatchMapper;
import com.ipl.nextg.dto.mapper.CurrentMatchMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MatchDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${custom.config.match.attempts}")
	Integer configMaxAttempts;

	public List<CurrentMatch> retrieveCurrentMatches(Integer userId) {
		return  jdbcTemplate.query("SELECT m.mat_id AS id, m.mat_city AS city, TIME(m.mat_start_time) AS time, DATE(m.mat_start_time) AS date,"
				+ " mat_score AS score, t1.tm_name AS localTeamName, t2.tm_name AS guestTeamName, t1.tm_id AS localTeamId, t2.tm_id AS guestTeamId,"
				+ " t1.tm_logo AS localTeamLogo, t2.tm_logo AS guestTeamLogo, s.sc_score AS earnedScore, s.sc_team AS selectedTeamId, s.sc_attempt AS consumedAttempts "
				+ " FROM tbl_matches as m"
				+ " JOIN tbl_teams as t1 ON m.mat_local_tm_id = t1.tm_id"
				+ " JOIN tbl_teams as t2 ON m.mat_visitor_tm_id = t2.tm_id "
				+ " LEFT JOIN tbl_score as s ON s.sc_match_id = m.mat_id and s.sc_player_id = ? "
				+ " WHERE DATE(mat_start_time) =  '"+ LocalDate.now() +"' "
				+ " ORDER BY mat_id ASC", new Object[]{userId}, new CurrentMatchMapper(configMaxAttempts));
	}

	public LocalDateTime getMatchStartTime(Integer matchId) {
		return jdbcTemplate.queryForObject("SELECT mat_start_time FROM tbl_matches WHERE mat_id = ?",
				new Object[]{matchId}, LocalDateTime.class);
	}

	public Integer retrievePlayersAttempts(Integer matchId, Integer usrId) {
		try {
			return jdbcTemplate.queryForObject("select sc_attempt from tbl_score where sc_match_id = ? and sc_player_id = ?", new Object[]{matchId, usrId}, Integer.class);
		}catch (EmptyResultDataAccessException e){
			return 0;
		}
	}

	public void addPlayersTeam(Integer matchId, Integer teamId, Integer usrId) {
			jdbcTemplate.update("INSERT INTO tbl_score(sc_match_id, sc_player_id, sc_team, sc_score, sc_attempt) VALUES(?, ?, ?, 0, 1)", matchId, usrId, teamId);
	}
	public void updatePlayersTeam(Integer matchId, Integer teamId, Integer usrId, Integer attempts) {
		jdbcTemplate.update("UPDATE tbl_score SET sc_attempt = sc_attempt+1, sc_team=? WHERE sc_match_id = ? AND sc_player_id = ? ", teamId, matchId, usrId);
	}

  public List<AllMatch> retrieveAllMatches() {
		return jdbcTemplate.query("SELECT m.mat_id AS id, m.mat_city AS city, m.mat_start_time AS matchStartTime, mat_score AS score, t1.tm_name AS localTeamName,"
				+ " t2.tm_name AS guestTeamName, t1.tm_id AS localTeamId, t2.tm_id AS guestTeamId, t1.tm_logo AS localTeamLogo, t2.tm_logo AS guestTeamLogo, mat_result AS result, mat_wining_tm_id AS winningTeamId"
				+ " FROM tbl_matches as m"
				+ " JOIN tbl_teams as t1 ON m.mat_local_tm_id = t1.tm_id"
				+ " JOIN tbl_teams as t2 ON m.mat_visitor_tm_id = t2.tm_id", new Object[]{}, new AllMatchMapper());
  }

	public void updatePlayerScores(Integer matchId, Integer teamId, Integer matchScore) {
		jdbcTemplate.update("UPDATE tbl_users as u JOIN tbl_score as s on u.usr_id = s.sc_player_id "
				+ " SET usr_rating = usr_rating + ? "
				+ " WHERE s.sc_match_id = ? AND sc_team = ? ", matchScore, matchId, teamId);
	}

	public Integer updateWinningTeam(Integer matchId, Integer teamId) {
		return jdbcTemplate.update("UPDATE tbl_matches SET mat_result='C', mat_wining_tm_id=? WHERE mat_id=?", teamId, matchId);
	}

	public String checkMatchStatus(Integer matchId) {
		try {
			return jdbcTemplate.queryForObject("SELECT mat_result from tbl_matches WHERE mat_id = ?", new Object[]{matchId}, String.class);
		}catch (EmptyResultDataAccessException e){
			return "C";
		}
	}
}
