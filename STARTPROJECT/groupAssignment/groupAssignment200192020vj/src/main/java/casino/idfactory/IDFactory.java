package casino.idfactory;

import casino.bet.Bet;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
  { try {
      GeneralID object = (GeneralID) Class.forName(type).newInstance();

          return object;
  }
  catch(ClassNotFoundException ex) {
      System.out.println(ex.toString());
  } catch (IllegalAccessException e) {
      e.printStackTrace();
  } catch (InstantiationException e) {
      e.printStackTrace();
  }

//      if(type.equals("bet"))
//          return new BetID();
//      else if(type.equals("card"))
//          return new CardID();
//      else if(type.equals("machine"))
//          return new GamingMachineID();
//      else if(type.equals("round"))
//          return new BettingRoundID();
      return null;
  }
}
