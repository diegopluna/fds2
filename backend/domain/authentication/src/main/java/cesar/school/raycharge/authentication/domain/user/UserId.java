package cesar.school.raycharge.authentication.domain.user;

import org.jmolecules.ddd.types.Identifier;
import org.jmolecules.ddd.types.ValueObject;

import java.util.UUID;

import static org.apache.commons.lang3.Validate.isTrue;

public class UserId implements ValueObject, Identifier {
  private final String id;

  public UserId(String id) {
    isTrue(!id.isEmpty(), "Id must not be empty");
    this.id = id;
  }

  public UserId() {
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof UserId userId) {
      return id.equals(userId.id);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return id;
  }
}
