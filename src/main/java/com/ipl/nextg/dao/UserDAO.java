package com.ipl.nextg.dao;

import com.ipl.nextg.dto.User;
import com.ipl.nextg.dto.mapper.LeaderboardMapper;
import com.ipl.nextg.dto.mapper.UserMapper;
import com.ipl.nextg.response.Leaderboard;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Optional<User> validateCredentials(String email, String encPassword)
	{
		Optional<User> user = Optional.empty();
		try {
			return Optional.of(jdbcTemplate.queryForObject(
					"SELECT * FROM tbl_users WHERE usr_email=? AND usr_password=?",
					new Object[]{email, encPassword}, new UserMapper()));
		}catch (EmptyResultDataAccessException e)
		{
			return user;
		}
	}

	public Optional<List<Leaderboard>> retrieveAllLeaderboard() {
		return Optional.of(jdbcTemplate.query("SELECT usr_id, usr_fname, usr_lname, usr_profile, usr_rating, usr_gender FROM tbl_users WHERE usr_status='A' ORDER BY usr_rating DESC", new LeaderboardMapper()));
	}
}
