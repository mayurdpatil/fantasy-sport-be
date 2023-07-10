package com.ipl.nextg.dao;

import com.ipl.nextg.dto.User;
import com.ipl.nextg.dto.mapper.UserMapper;
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
					"SELECT * from tbl_users where usr_email=? and usr_password=?",
					new Object[]{email, encPassword}, new UserMapper()));
		}catch (EmptyResultDataAccessException e)
		{
			return user;
		}
	}
}
