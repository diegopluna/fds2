package com.cesarschool.raycharge.domain.enterprise.props;

import java.util.Date;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientProps {
  public String name;
  public String cpf;
  public String email;
  public String phone;
  public Date birthdate;
  public String password;
}
