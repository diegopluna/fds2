package com.cesarschool.raycharge.domain.enterprise.entities;

import com.cesarschool.raycharge.core.entitites.Entity;
import com.cesarschool.raycharge.core.entitites.UniqueEntityID;
import com.cesarschool.raycharge.domain.enterprise.props.ClientProps;

public class Client extends Entity<ClientProps> {

  public String getName() {
    return this.props.name;
  }

  private Client(ClientProps props) {
    super(props);
  }

  private Client(ClientProps props, UniqueEntityID id) {
    super(props, id);
  }

  public static Client create(ClientProps props) {
    Client client = new Client(props);
    return client;
  }

  public static Client create(ClientProps props, UniqueEntityID id) {
    Client client = new Client(props, id);
    return client;
  }

}
