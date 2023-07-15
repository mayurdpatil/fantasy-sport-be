package com.ipl.nextg.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AllMatch {
  private Integer id;
  private String city;
  private String matchStartTime;
  private Integer score;
  private String localTeamName;
  private String guestTeamName;
  private Integer localTeamId;
  private Integer guestTeamId;
  private String localTeamLogo;
  private String guestTeamLogo;
  private String result;
  private Integer winningTeamId;
}