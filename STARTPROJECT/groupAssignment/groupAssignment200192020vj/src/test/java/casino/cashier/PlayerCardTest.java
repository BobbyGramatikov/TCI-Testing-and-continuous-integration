package casino.cashier;

import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerCardTest {
    @Test
    public void generateNewBetIdReturnsNull() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId;

        //act
        mockBetId = playerCard.generateNewBetID();

        //assert
        assertNotNull("Generating an ID returns Null", mockBetId);

    }

    @Test
    public void generateNewBetIdReturnsBetId() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId;

        //act
        mockBetId = playerCard.generateNewBetID();

        //assert
        assertEquals("Does not return BetID", mockBetId.getClass(), BetID.class);
    }

    @Test
    public void generateNewBetIDAddsBetIdToTheSet() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        BetID mockBetId;
        int expectedNrOfBets = 1;
        int actualNrOfBets;

        //act
        mockBetId = playerCard.generateNewBetID();
        actualNrOfBets = playerCard.getNumberOfBetIDs();

        //assert
        assertEquals("Does not add new BetId to set", expectedNrOfBets, actualNrOfBets);

    }

    @Test
    public void returnBetIdsReturnNull() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        Set<BetID> mockBetIds;

        //act
        mockBetIds = playerCard.returnBetIDs();

        //assert
        assertNotNull("Return betIDs returns null", mockBetIds);

    }

    @Test
    public void returnBetIdsAndClearCard() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        int betCountExpected = 0;

        //act
        playerCard.generateNewBetID();
        playerCard.returnBetIDsAndClearCard();
        int betCountAfter = playerCard.getNumberOfBetIDs();

        //assert
        assertEquals("returnBetIdsAndClearCard does not clear the card", betCountExpected, betCountAfter);

    }

    @Test
    public void returnBetIdsAndClearCardSetMoneyToZero() {
        //arrange
        MoneyAmount moneyAmount = new MoneyAmount(100);
        PlayerCard playerCard = new PlayerCard(moneyAmount);
        long expectedMoney = 0;

        //act

        playerCard.generateNewBetID();
        playerCard.returnBetIDsAndClearCard();
        long actualMoney = playerCard.getMoneyAmount().getAmountInCents();
        //assert
        assertEquals("returnBetIdsAndClearCard does not clear the card", expectedMoney, actualMoney);

    }
}