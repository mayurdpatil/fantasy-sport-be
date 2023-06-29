package com.ipl.nextg.dao;

import com.ipl.nextg.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {

}
