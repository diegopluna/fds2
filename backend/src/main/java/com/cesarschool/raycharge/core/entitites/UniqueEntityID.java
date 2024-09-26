package com.cesarschool.raycharge.core.entitites;

import java.util.UUID;

public class UniqueEntityID {
  private String value;

  public String toString() {
    return this.value;
  }

  public UniqueEntityID() {
    this.value = UUID.randomUUID().toString();
  }

  public UniqueEntityID(String value) {
    this.value = value;
  }

  public boolean equals(UniqueEntityID id) {
    return id.toString() == this.value;
  }

}
