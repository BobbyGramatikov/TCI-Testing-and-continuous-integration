package casino.cashier;

import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerCardTest {
    @Test
    public void generateNewBetIdReturnsNull() throws NullPointerException {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId;// = playerCard.generateNewBetID();
        boolean expected = false;
        boolean actual = false;
        //doReturn(mockBetId).when(playerCard).generateNewBetID(); !Player card should be spy

        //act
        mockBetId = playerCard.generateNewBetID();
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

    @Test
    public void generateNewBetIDAddsBetIdToTheSet() {
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

    @Test
    public void returnBetIdsReturnNull() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        Set<BetID> mockBetIds;
        boolean expected = true;
        boolean actual = true;

        //act
        mockBetIds = playerCard.returnBetIDs();
        if (mockBetIds == null){
            actual = false;
        }
        //assert
        assertEquals("Return betIDs returns null", expected, actual);

    }

    @Test
    public void getNumberOfBetIds() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        Set<BetID> mockBetIds;
        int expected = 0;
        int actual = -2;

        //act
        actual = playerCard.getNumberOfBetIDs();

        //assert
        assertEquals("Get number of bet Ids does not return actual value", expected, actual);

    }
}