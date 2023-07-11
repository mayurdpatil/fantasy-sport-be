package com.ipl.nextg.response;

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
public class Leaderboard {
	private Integer usrId;
	private String name;
	private String usrProfile;
	private Integer usrRating;
	private String usrGender;
}
