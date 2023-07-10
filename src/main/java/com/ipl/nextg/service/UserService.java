package com.ipl.nextg.service;

import com.ipl.nextg.config.MemoryUsers;
import com.ipl.nextg.dao.InMemoryUser;
import com.ipl.nextg.dao.UserDAO;
import com.ipl.nextg.dao.UserRepository;
import com.ipl.nextg.dto.User;
import com.ipl.nextg.request.ValidateUserRequest;
import com.ipl.nextg.util.Helper;
import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserDAO userDAO;
  private UserRepository userRepository;

  public Optional<User> checkUserCredentials(ValidateUserRequest user)
  {
    return userDAO.validateCredentials(user.getUsername(), Helper.convertStringToMD5(user.getPassword()));
  }

  public String setUserSession(Optional<User> userData) {
    String sessionToken = Helper.convertStringToMD5(Instant.now().toString());
    MemoryUsers.setSessionToken(sessionToken, new InMemoryUser(userData.get().getUsrId(), userData.get().getUsrFname() + " " + userData.get().getUsrLname(), userData.get().getUsrEmail(), userData.get().getUsrType(), userData.get().getUsrRating()));
    return sessionToken;
  }
}