package casino.idfactory;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@RunWith(JUnitParamsRunner.class)

public class IDFactoryTest {

    private static final Object[] FactoryGeneralIdTypes() {
        return new Object[] {
                new Object[] {"casino.idfactory.BettingRoundID",new BettingRoundID()},
                new Object[] {"casino.idfactory.BetID",new BetID()},
                new Object[] {"casino.idfactory.GamingMachineID",new GamingMachineID()},
                new Object[] {"casino.idfactory.CardID",new CardID()}
        };
    }

    @Test
    @Parameters(method = "FactoryGeneralIdTypes")
    public void Factory_Is_Creating_Wanted_General_ID(String types,Object classType)
    {
        //arrange
        IDFactory factory = new IDFactory();
        //act
        GeneralID subclass = (GeneralID) factory.CreateID(types);
        //assert
        assertThat("Creation of all unique different ID classes from the ID factory",subclass, instanceOf(classType.getClass())); // returns type Generic ID
    }

    @Test
    public void Factory_Is_Given_Invalid_Type_For_General_ID()
    {
        IDFactory factory = new IDFactory();
        GeneralID subclass = (GeneralID) factory.CreateID("teacher");
        assertThat("Invalid Types are failing, by giving null",subclass, is(nullValue())); // returns type Generic ID
    }

    @Test
    public void On_New_Type_Created_Id_Is_Not_Null()
    {
        IDFactory factory = new IDFactory();
        BettingRoundID subclass = (BettingRoundID) factory.CreateID("casino.idfactory.BettingRoundID");
        assertThat("ID constructor works fine when new type is created",subclass.GetID(), is(notNullValue()));
    }
}