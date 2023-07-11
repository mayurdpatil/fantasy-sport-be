package com.ipl.nextg.controller;

import com.ipl.nextg.config.MemoryUsers;
import com.ipl.nextg.dao.InMemoryUser;
import com.ipl.nextg.response.Leaderboard;
import com.ipl.nextg.response.ResponseHandler;
import com.ipl.nextg.service.LeaderboardService;
import com.ipl.nextg.util.Helper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardController {

    @Autowired
    LeaderboardService leaderboardService;

    @GetMapping(value="getLeaderboard")
    public ResponseEntity<Object> getTokens(@RequestHeader("session-token") String sessionToken)
    {
        //[TODO: mAYUR] Move this functionality to kernel or middleware
        Optional<InMemoryUser> returnData = Optional.empty();
        returnData = MemoryUsers.getSessionToken(sessionToken);
        if (returnData.isPresent())
            return ResponseHandler.generateResponse("Leaderboard fetched successfully", HttpStatus.OK, leaderboardService.retrieveAllLeaderboard());
        else
            return ResponseHandler.generateResponse("Invalid session", HttpStatus.UNAUTHORIZED, returnData);
    }

}
