package com.ipl.nextg.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class InMemoryUser {

  private int usrId;
  private String usrName;
  private String usrEmail;
  private Integer usrType;
  private Integer usrRating;


}
