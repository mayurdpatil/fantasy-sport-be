package com.ipl.nextg.dto;

import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrentMatch {

  private Integer id;
  private String city;
  private String time;
  private String date;
  private Integer score;
  private String localTeamName;
  private String guestTeamName;
  private Integer localTeamId;
  private Integer guestTeamId;
  private String localTeamLogo;
  private String guestTeamLogo;
  private Integer earnedScore;
  private Integer selectedTeamId;
  private Integer consumedAttempts;
  private Integer maxAllowedAttempts;
}