package com.ipl.nextg.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="tbl_users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usr_id")
	private int usrId;
	@Column(name="usr_fname")
	private String usrFname;
	@Column(name="usr_lname")
	private String usrLname;
	@Column(name="usr_email")
	private String usrEmail;
	@Column(name="usr_password")
	private String usrPassword;
	@Column(name="usr_profile")
	private String usrProfile;
	@Column(name="usr_type")
	private Integer usrType;
	@Column(name="usr_gender")
	private String usrGender;
	@Column(name="usr_status")
	private String usrStatus;
	@Column(name="usr_rating")
	private Integer usrRating;
	@Column(name="usr_last_login_on")
	private String usrLastLoginOn;
}
