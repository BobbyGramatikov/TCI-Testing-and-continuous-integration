package casino.cashier;

import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerCardTest {
    @Test
    public void generateNewBetIdReturnsNull() throws NullPointerException {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId = null;
        boolean expected = false;
        boolean actual = false;

        //act
        //mockBetId = playerCard.generateNewBetID();
        if (mockBetId == null){
            actual = true;
        }
        //assert
        assertEquals("Generating an ID returns Null", expected, actual);

    }

    @Test
    public void generateNewBetIdReturnsBetId() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId;
        boolean expected = true;
        boolean actual = false;

        //act
        mockBetId = playerCard.generateNewBetID();
        if (mockBetId.getClass() == BetID.class){
            actual = true;
        }
        //assert
        assertEquals("Does not return BetID", expected, actual);

    }
}