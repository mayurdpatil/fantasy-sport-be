package com.ipl.nextg.controller;

import com.ipl.nextg.config.MemoryUsers;
import com.ipl.nextg.dao.InMemoryUser;
import com.ipl.nextg.request.SubmitScoreRequest;
import com.ipl.nextg.response.ResponseHandler;
import com.ipl.nextg.service.MatchService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

  @Autowired
  MatchService matchService;

  @Value("${custom.config.match.attempts}")
  Integer configMaxAttempts;

  @GetMapping("/getMatches")
  public ResponseEntity<Object> getMatches(@RequestHeader("session-token") String sessionToken)
  {
    Optional<InMemoryUser> returnData = MemoryUsers.getSessionToken(sessionToken);
    return ResponseHandler.generateResponse("Match list fetched successfully", HttpStatus.OK,
        matchService.retrieveTodaysMatch(returnData.get().getUsrId()));
  }

  @PostMapping("/submitScore")
  public ResponseEntity<Object> submitScore(@RequestHeader("session-token") String sessionToken, @RequestBody SubmitScoreRequest submitScoreRequest)
  {
    Optional<InMemoryUser> sessionData = MemoryUsers.getSessionToken(sessionToken);
      if(matchService.checkMatchTimeDeadline(submitScoreRequest.getMatchId())) {
        Integer attempts = matchService.checkUserAttemptsForMatch(submitScoreRequest, sessionData.get().getUsrId());
        if(attempts < configMaxAttempts)
          return ResponseHandler.generateResponse("User attempt acknowledged successfully ", HttpStatus.OK, matchService.submitMatchScore(submitScoreRequest, sessionData.get().getUsrId(), attempts));
        else
          return ResponseHandler.generateResponse("User Already consumed his attempts", HttpStatus.BAD_REQUEST, attempts);
      }
      else
        return ResponseHandler.generateResponse("Submission time expired", HttpStatus.BAD_REQUEST, null);
  }


  @GetMapping("admin/getMatches")
  public ResponseEntity<Object> getAllMatches(@RequestHeader("session-token") String sessionToken)
  {
    return ResponseHandler.generateResponse("All matches fetched successfully", HttpStatus.OK, matchService.retrieveAllMatches());
  }

  @PostMapping("admin/setResult")
  public ResponseEntity<Object> saveMatchResult(@RequestHeader("session-token") String sessionToken, @RequestParam("matchId") Integer matchId, @RequestParam("teamId") Integer teamId, @RequestParam("matchScore") Integer matchScore)
  {
    if(matchService.checkMatchStatus(matchId))
      return ResponseHandler.generateResponse("Winning team updated successfully", HttpStatus.OK, matchService.updateWinningTeam(matchId, teamId, matchScore));
    else
      return ResponseHandler.generateResponse("Winning team already updated for this match", HttpStatus.BAD_REQUEST, null);
  }
}
