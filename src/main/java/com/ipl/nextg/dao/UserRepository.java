package com.ipl.nextg.dao;

import com.ipl.nextg.dto.User;
public interface UserRepository {

  User findByEmail(String email);
}
