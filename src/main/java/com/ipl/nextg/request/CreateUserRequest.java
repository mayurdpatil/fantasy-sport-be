package com.ipl.nextg.request;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

public class CreateUserRequest {

    private String usr_fname;
    private String usr_lname;
    private String usr_password;
    private String usr_profile;
    private Integer usr_type;
    private String usr_gender;
    private char usr_status='A';
    private Integer usr_rating=0;

    public String getUsr_fname() {
        return usr_fname;
    }

    public CreateUserRequest setUsr_fname(String usr_fname) {
        this.usr_fname = usr_fname;
        return this;
    }

    public String getUsr_lname() {
        return usr_lname;
    }

    public CreateUserRequest setUsr_lname(String usr_lname) {
        this.usr_lname = usr_lname;
        return this;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public CreateUserRequest setUsr_password(String usr_password) {
        this.usr_password = usr_password;
        return this;
    }

    public String getUsr_profile() {
        return usr_profile;
    }

    public CreateUserRequest setUsr_profile(String usr_profile) {
        this.usr_profile = usr_profile;
        return this;
    }

    public Integer getUsr_type() {
        return usr_type;
    }

    public CreateUserRequest setUsr_type(Integer usr_type) {
        this.usr_type = usr_type;
        return this;
    }

    public String getUsr_gender() {
        return usr_gender;
    }

    public CreateUserRequest setUsr_gender(String usr_gender) {
        this.usr_gender = usr_gender;
        return this;
    }

    public char getUsr_status() {
        return usr_status;
    }

    public CreateUserRequest setUsr_status(char usr_status) {
        this.usr_status = usr_status;
        return this;
    }

    public Integer getUsr_rating() {
        return usr_rating;
    }

    public CreateUserRequest setUsr_rating(Integer usr_rating) {
        this.usr_rating = usr_rating;
        return this;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "usr_fname='" + usr_fname + '\'' +
                ", usr_lname='" + usr_lname + '\'' +
                ", usr_password='" + usr_password + '\'' +
                ", usr_profile='" + usr_profile + '\'' +
                ", usr_type=" + usr_type +
                ", usr_gender='" + usr_gender + '\'' +
                ", usr_status=" + usr_status +
                ", usr_rating=" + usr_rating +
                '}';
    }
}
