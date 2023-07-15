package com.ipl.nextg.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class ScheduleMatchRequest {
    private Integer leagueId=1;
    private Integer localTeamId;
    private Integer guestTeamId;
    private String city;
    private String matchStartTime;
    private Integer mat_score;
}
