package com.ipl.nextg.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ValidateUserRequest {

    private String username;
    private String password;

}
