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
                new Object[] {"bet",new BetID()},
                new Object[] {"round",new BettingRoundID()},
                new Object[] {"machine",new GamingMachineID()},
                new Object[] {"card",new CardID()}
        };
    }

    @Test
    @Parameters(method = "FactoryGeneralIdTypes")
    public void Factory_Is_Creating_Wanted_General_ID(String types,Object classType)
    {
        //arrange
        IDFactory factory = new IDFactory();
        //act
        GeneralID subclass = factory.CreateID(types);
        //assert
        assertThat(subclass, instanceOf(classType.getClass())); // returns type Generic ID
    }

    @Test
    public void Factory_Is_Given_Invalid_Type_For_General_ID()
    {
        IDFactory factory = new IDFactory();
        GeneralID subclass = factory.CreateID("teacher");
        assertThat(subclass, is(nullValue())); // returns type Generic ID
    }

    @Test
    public void On_New_Type_Created_Id_Is_Not_Null()
    {
        IDFactory factory = new IDFactory();
        BettingRoundID subclass = (BettingRoundID) factory.CreateID("round");
        assertThat(subclass.GetID(), is(notNullValue()));
    }
}