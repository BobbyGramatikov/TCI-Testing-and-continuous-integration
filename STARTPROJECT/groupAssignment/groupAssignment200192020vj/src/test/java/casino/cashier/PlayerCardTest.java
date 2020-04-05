package casino.cashier;

import casino.bet.MoneyAmount;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PlayerCardTest {

    @Test
    public void setMoneyAmount() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        MoneyAmount mockMoneyAmount = mock(MoneyAmount.class);
        boolean expectedResult = true;
        boolean actualResult;
        //act
        playerCard.setMoneyAmount(mockMoneyAmount);
        if (playerCard.getMoneyAmount() == mockMoneyAmount)
            actualResult = true;
        else
            actualResult = false;

        //assert
        assertEquals("Money amount is the same", expectedResult, actualResult);
    }
}