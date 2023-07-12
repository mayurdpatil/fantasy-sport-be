package com.ipl.nextg.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubmitScoreRequest {

    private Integer matchId;
    private Integer teamId;

}
