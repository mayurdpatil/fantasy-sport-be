package com.ipl.nextg.service;

import com.ipl.nextg.config.MemoryUsers;
import com.ipl.nextg.controller.LeaderboardController;
import com.ipl.nextg.dao.InMemoryUser;
import com.ipl.nextg.dao.UserDAO;
import com.ipl.nextg.dao.UserRepository;
import com.ipl.nextg.dto.User;
import com.ipl.nextg.request.ValidateUserRequest;
import com.ipl.nextg.response.Leaderboard;
import com.ipl.nextg.util.Helper;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardService {

  @Autowired
  UserDAO userDAO;

  public Optional<List<Leaderboard>> retrieveAllLeaderboard()
  {
    return userDAO.retrieveAllLeaderboard();
  }
}