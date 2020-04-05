package casino.cashier;

import casino.bet.MoneyAmount;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CashierTest {

    @Test
    public void addAmountCallsSetMoneyAmount() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        MoneyAmount mockMoneyAmount = mock(MoneyAmount.class);

        //act
        cashier.addAmount(mockPlayerCard, mockMoneyAmount);

        //assert
        verify(mockPlayerCard).setMoneyAmount(mockMoneyAmount);
    }

    @Test
    public void returnGamblerCardCallsReturnBetIDsAndClearCard() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);

        //act
        cashier.returnGamblerCard(mockPlayerCard);

        //assert
        verify(mockPlayerCard).returnBetIDsAndClearCard();
    }
}