package casino.cashier;

import bettingauthoritiyAPI.BetLoggingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.CardID;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.GreaterThan;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.greaterThan;
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

    @Test //Doesnt work (uses equals from playerCard)
    public void distributeGamblerCardCallsBLAHandOutGamblingCard() {
        //arrange
        Cashier cashier = new Cashier();

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
        //when(mockPlayerCard.equals(cashier.distributeGamblerCard())).thenReturn(true);

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
    public void addAmountIncreasesMoneyAmount() {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        MoneyAmount mockMoneyAmount = mock(MoneyAmount.class);
        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);

        when(mockPlayerCard.getMoneyAmount()).thenReturn(mockPCMoneyAmount);

        //act
        cashier.addAmount(mockPlayerCard, mockMoneyAmount);
        long cardCents = mockPCMoneyAmount.getAmountInCents();
        long amountCents = mockMoneyAmount.getAmountInCents();

        //assert
        verify(mockMoneyAmount).setAmountInCents(cardCents + amountCents);

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

    @Test //need to put actual values instead of setting them here
    public void checkIfBetIsValid() throws BetNotExceptedException {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Bet mockBet = mock(Bet.class);

        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);
        when(mockPlayerCard.getMoneyAmount()).thenReturn(mockPCMoneyAmount);
        //when(mockPCMoneyAmount.getAmountInCents()).thenReturn((long)100);

        MoneyAmount mockBetMoneyAmount = mock(MoneyAmount.class);
        when(mockBet.getMoneyAmount()).thenReturn(mockBetMoneyAmount);
        //when(mockBetMoneyAmount.getAmountInCents()).thenReturn((long)150);

        //act
        long betMoney = mockBet.getMoneyAmount().getAmountInCents();
        long playerMoney = mockPlayerCard.getMoneyAmount().getAmountInCents();
        cashier.checkIfBetIsValid(mockPlayerCard, mockBet);

        //assert
        assertTrue("Bet is higher than money in the card",betMoney <= playerMoney);

    }

    @Test
    public void checkIfBetIsValidLowersCardMoneyAmount() throws BetNotExceptedException {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Bet mockBet = mock(Bet.class);

        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);

        MoneyAmount mockBetMoneyAmount = mock(MoneyAmount.class);

        when(mockPlayerCard.getMoneyAmount()).thenReturn(mockPCMoneyAmount);
        when(mockBet.getMoneyAmount()).thenReturn(mockBetMoneyAmount);

        //act
        cashier.checkIfBetIsValid(mockPlayerCard, mockBet);
        long mockCardCents = mockPlayerCard.getMoneyAmount().getAmountInCents();
        long mockBetCents = mockBet.getMoneyAmount().getAmountInCents();

        //assert
        verify(mockPlayerCard.getMoneyAmount()).setAmountInCents(mockCardCents - mockBetCents);

    }

    @Test //Need help
    public void checkIfBetIsValidThrowsException() throws BetNotExceptedException {
        //arrange
        Cashier cashier = new Cashier();
        PlayerCard mockPlayerCard = mock(PlayerCard.class);
        Bet mockBet = mock(Bet.class);

        MoneyAmount mockPCMoneyAmount = mock(MoneyAmount.class);
        mockPlayerCard.setMoneyAmount(mockPCMoneyAmount);
        //mockPlayerCard.getMoneyAmount().setAmountInCents(100);

        MoneyAmount mockBetMoneyAmount = mock(MoneyAmount.class);
        mockBet.setMoneyAmount(mockBetMoneyAmount);
        //mockBet.getMoneyAmount().setAmountInCents(50);

        when(mockPlayerCard.getMoneyAmount().getAmountInCents()).thenReturn((long)100);
        when(mockBet.getMoneyAmount().getAmountInCents()).thenReturn((long)50);

        //act

        //assert

    }
}