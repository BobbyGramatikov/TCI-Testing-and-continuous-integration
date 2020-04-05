package casino.cashier;

import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerCardTest {

    @Test
    public void generateNewBetIdCallsIdFactory() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId = mock(BetID.class);

        //act
        playerCard.generateNewBetID();

        //assert
        verify(mockBetId).CreateID();

    }
}