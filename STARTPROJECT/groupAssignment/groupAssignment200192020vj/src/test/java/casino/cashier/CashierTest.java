package casino.cashier;

import bettingauthoritiyAPI.BetLoggingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.CardID;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.GreaterThan;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CashierTest {

    @Test
    public void distributeGamblerCardAddsTheCardToASet() {
        //arrange
        Cashier cashier = new Cashier();
        int expectedNrOfCards = 1;
        int actualNrOfCards;

        //act
        cashier.distributeGamblerCard();
        actualNrOfCards = cashier.getNumberOfDistributedCards();

        //assert
        assertEquals("Does not add new Card to set", expectedNrOfCards, actualNrOfCards);
    }

    @Test //Doesnt work because we dont have access to the inner player card
    public void distributeGamblerCardCallsBLAHandOutGamblingCard() {
        //arrange
        Cashier cashier = new Cashier();
        //Cashier cashier = spy(Cashier.class);
        BetLoggingAuthority mockBetLoggingAuthority = mock(BetLoggingAuthority.class);
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Set<PlayerCard> setOfCards= Mockito.mock(Set.class);
        CardID mockId = mock(CardID.class);
        //mockId.CreateID();
        when(mockPlayerCard.getCardID()).thenReturn(mockId);

        //act
        cashier.setBetLoggingAuthority(mockBetLoggingAuthority);
        cashier.setDistributedCards(setOfCards);
        cashier.distributeGamblerCard();

        //assert
        verify(mockBetLoggingAuthority).handOutGamblingCard(mockPlayerCard.getCardID());
    }

    @Test
    public void addAmountCallsSetMoneyAmount() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        MoneyAmount mockMoneyAmount = mock(MoneyAmount.class);
        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);
        when(mockPlayerCard.getMoneyAmount()).thenReturn(mockPCMoneyAmount);

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

    @Test
    public void returnGamblerCardCallsBLAHandInGamblingCard() {
        //arrange
        Cashier cashier = new Cashier();
        IPlayerCard mockPlayerCard = mock(IPlayerCard.class);
        BetLoggingAuthority mockBetLoggingAuthority = mock(BetLoggingAuthority.class);
        cashier.setBetLoggingAuthority(mockBetLoggingAuthority);
        Set<PlayerCard> setOfCards = Mockito.mock(Set.class);
        cashier.setDistributedCards(setOfCards);

        //act
        cashier.returnGamblerCard(mockPlayerCard);

        //assert
        verify(mockBetLoggingAuthority).handInGamblingCard(mockPlayerCard.getCardID(), mockPlayerCard.returnBetIDs());
    }

    @Test
    public void returnGamblerCardRemovesCardFromSetOfDistributedCards() {
        //arrange
        Cashier cashier = new Cashier();
        IPlayerCard playerCard = cashier.distributeGamblerCard();
        Set<PlayerCard> distributedCards = cashier.getDistributedCards();

        //act
        cashier.returnGamblerCard(playerCard);
        boolean contains = distributedCards.contains(playerCard);

        //assert
        assertEquals("Set of cards still contain the card ID", contains, false);
    }

    @Test //Need help
    public void checkIfBetIsValid() throws BetNotExceptedException {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Bet mockBet = mock(Bet.class);

        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);
        mockPlayerCard.setMoneyAmount(mockPCMoneyAmount);
        mockPlayerCard.getMoneyAmount().setAmountInCents(100);

        MoneyAmount mockBetMoneyAmount = mock(MoneyAmount.class);
        mockBet.setMoneyAmount(mockBetMoneyAmount);
        mockBet.getMoneyAmount().setAmountInCents(50);

        //when(mockBet.getMoneyAmount().getAmountInCents()).thenReturn(100l);
        //when(mockPlayerCard.getMoneyAmount().getAmountInCents()).thenReturn(50l);


        //act
        cashier.checkIfBetIsValid(mockPlayerCard, mockBet);
        long betMoney = mockBet.getMoneyAmount().getAmountInCents();
        long playerMoney = mockPlayerCard.getMoneyAmount().getAmountInCents();

        //assert
        assertTrue(betMoney <= playerMoney);
        // assertThat("Bet is not valid because bet amount exceeds card amount", betMoney,
                //new GreaterThan(playerMoney));
    }
}