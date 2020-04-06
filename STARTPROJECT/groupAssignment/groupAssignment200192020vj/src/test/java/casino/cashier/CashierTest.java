package casino.cashier;

import bettingauthoritiyAPI.BetLoggingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.CardID;
import org.junit.Test;

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

    @Test //Doesnt work
    public void distributeGamblerCardCallsBLAHandOutGamblingCard() {
        //arrange
        Cashier cashier = new Cashier();
        Cashier spyCashier = spy(Cashier.class);
        BetLoggingAuthority mockBetLoggingAuthority = mock(BetLoggingAuthority.class);
        IPlayerCard mockIPlayerCard = mock(IPlayerCard.class);

        //act
        //doReturn(mockIPlayerCard).when(spyCashier).distributeGamblerCard();
        spyCashier.distributeGamblerCard();

        //assert
        verify(mockBetLoggingAuthority).handOutGamblingCard(mockIPlayerCard.getCardID());
    }

    @Test//Doesnt work
    public void addAmountCallsSetMoneyAmount() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        MoneyAmount mockMoneyAmount = spy(MoneyAmount.class);

        //act
        //when(mockPlayerCard.getMoneyAmount().getAmountInCents()).thenReturn((long)100);
        doReturn(mockMoneyAmount).when(mockMoneyAmount).setAmountInCents(5);
        //when(mockMoneyAmount.getAmountInCents()).thenReturn((long)20);

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

    @Test//doesnt work
    public void returnGamblerCardCallsBLAHandInGamblingCard() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        BetLoggingAuthority mockBetLoggingAuthority = mock(BetLoggingAuthority.class);
        CardID mockCardId = mock(CardID.class);
        Set<BetID> emptySet = new HashSet<>();

        //act
        when(mockPlayerCard.getCardID()).thenReturn(mockCardId);
        when(mockPlayerCard.returnBetIDs()).thenReturn(emptySet);
        //doReturn(mockCardId).when(mockPlayerCard.getCardID());
        //doReturn(emptySet).when(mockPlayerCard.returnBetIDs());
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
    public void checkIfBetIsValid() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Bet mockBet = mock(Bet.class);
        //act
        //cashier.checkIfBetIsValid(mockPlayerCard, mockBet);

        //assert
        //verify(mockPlayerCard).returnBetIDsAndClearCard();
    }
}