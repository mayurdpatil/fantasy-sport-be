package com.ipl.nextg.service;

import com.ipl.nextg.dao.MatchDAO;
import com.ipl.nextg.dto.AllMatch;
import com.ipl.nextg.dto.CurrentMatch;
import com.ipl.nextg.request.SubmitScoreRequest;
import com.ipl.nextg.util.Helper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class MatchService {

  @Autowired
  MatchDAO matchDAO;

  public List<CurrentMatch> retrieveTodaysMatch(Integer userId)
  {
    return matchDAO.retrieveCurrentMatches(userId);
  }

  public boolean checkMatchTimeDeadline(Integer matchId) {
    Long difference = Helper.getPendingSeconds(matchDAO.getMatchStartTime(matchId));
    //TODO[mAYUR]: LOGS for difference value...
    return (difference > 0) ? true : false;
  }

  public Integer checkUserAttemptsForMatch(SubmitScoreRequest submitScoreRequest, Integer usrId) {
    return matchDAO.retrievePlayersAttempts(submitScoreRequest.getMatchId(), usrId);
  }

  public Map<String, Integer> submitMatchScore(SubmitScoreRequest submitScoreRequest, Integer usrId, Integer attempts) {
    Map<String, Integer> returnData = new HashMap<>();
    if(attempts.equals(0))
      matchDAO.addPlayersTeam(submitScoreRequest.getMatchId(), submitScoreRequest.getTeamId(), usrId);
    else
      matchDAO.updatePlayersTeam(submitScoreRequest.getMatchId(), submitScoreRequest.getTeamId(), usrId, attempts);
    returnData.put("attemptsConsumed", attempts + 1);
    return returnData;
  }

  public List<AllMatch> retrieveAllMatches() {
    return matchDAO.retrieveAllMatches();
  }

  public Integer updateWinningTeam(Integer matchId, Integer teamId, Integer matchScore) {
    matchDAO.updatePlayerScores(matchId, teamId, matchScore);
    return matchDAO.updateWinningTeam(matchId, teamId);
  }

  public boolean checkMatchStatus(Integer matchId) {
    return (matchDAO.checkMatchStatus(matchId).equals("P") ) ? true : false;
  }
}