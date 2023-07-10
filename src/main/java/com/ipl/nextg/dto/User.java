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
public class User {

	private Integer usrId;
	private String usrFname;
	private String usrLname;
	private String usrEmail;
	private String usrPassword;
	private String usrProfile;
	private Integer usrType;
	private String usrGender;
	private String usrStatus;
	private Integer usrRating;
	private String usrLastLoginOn;

}
