package com.ipl.nextg.config;

import com.ipl.nextg.dao.InMemoryUser;
import com.ipl.nextg.dto.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUsers {

  public static Map<String, InMemoryUser> sessionToken = new HashMap<>();

  public static Map<String, InMemoryUser> getSessionToken() {
    return sessionToken;
  }

  public static Optional<InMemoryUser> getSessionToken(String token) {
    try {
      return Optional.of(sessionToken.get(token));
    }
    catch (NullPointerException e)
    {
      return Optional.empty();
    }
  }

  public static void setSessionToken(String token, InMemoryUser user) {
    MemoryUsers.sessionToken.put(token, user);
  }
}
