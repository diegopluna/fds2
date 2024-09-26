package com.cesarschool.raycharge.core.entitites;

import lombok.Getter;

public abstract class Entity<T> {
  @Getter
  private UniqueEntityID id;
  protected T props;

  public Entity(
      T props) {
    this.props = props;
    this.id = new UniqueEntityID();
  }

  public Entity(
      T props, UniqueEntityID id) {
    this.props = props;
    this.id = id;
  }
}
