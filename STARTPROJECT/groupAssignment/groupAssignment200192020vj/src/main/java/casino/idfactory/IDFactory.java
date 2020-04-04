package casino.idfactory;

import java.security.Timestamp;
import java.util.UUID;

/**
 * Factory for creation of GeneralID objects.
 * creation of the right object is done by specifying the type to create
 * the specified type is case insensitive
 *
 * when the type is not present, null is returned.
 */
public class IDFactory {
  public static GeneralID CreateID(String type)
  {
      return null;
  }
}
