package com.ipl.nextg.controller;

import com.google.common.collect.ImmutableMap;
import com.ipl.nextg.request.ScheduleMatchRequest;
import com.ipl.nextg.response.ResponseHandler;
import com.ipl.nextg.service.MatchService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/")
public class AdminController {
  @Autowired
  MatchService matchService;
  @GetMapping("getMatches")
  public ResponseEntity<Object> getAllMatches(@RequestHeader("session-token") String sessionToken)
  {
    return ResponseHandler.generateResponse("All matches fetched successfully", HttpStatus.OK, matchService.retrieveAllMatches());
  }
  @PostMapping("setResult")
  public ResponseEntity<Object> saveMatchResult(@RequestHeader("session-token") String sessionToken, @RequestParam("matchId") Integer matchId, @RequestParam("teamId") Integer teamId, @RequestParam("matchScore") Integer matchScore)
  {
    if(matchService.checkMatchStatus(matchId))
      return ResponseHandler.generateResponse("Winning team updated successfully", HttpStatus.OK, matchService.updateWinningTeam(matchId, teamId, matchScore));
    else
      return ResponseHandler.generateResponse("Winning team already updated for this match", HttpStatus.BAD_REQUEST, null);
  }

  @GetMapping("getTeams")
  public ResponseEntity<Object> getLeagueTeams(@RequestHeader("session-token") String sessionToken, @RequestParam("leagueId") Integer leagueId)
  {
    return ResponseHandler.generateResponse("All teams fetched successfully", HttpStatus.OK, matchService.retrieveLeagueTeams(leagueId));
  }

  @GetMapping("getLocations")
  public ResponseEntity<Object> getLocations(@RequestHeader("session-token") String sessionToken)
  {
    return ResponseHandler.generateResponse("All locations fetched successfully", HttpStatus.OK, matchService.retrieveMatchLocations());
  }

  @PostMapping("scheduleMatch")
  public ResponseEntity<Object> scheduleMatch(@RequestHeader("session-token") String sessionToken, @RequestBody
      ScheduleMatchRequest match)
  {
    Boolean returnData = matchService.scheduleMatch(match);
    return ResponseHandler.generateResponse("Match scheduled successfully", HttpStatus.OK, returnData);
  }
}
