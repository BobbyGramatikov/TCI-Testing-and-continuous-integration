package casino.cashier;

import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerCardTest {
    //Change IF's to Asserts

    @Test
    public void generateNewBetIdReturnsNull() {
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

        if (playerCard.getNumberOfBetIDs() == 1){
            actual = true;
        }
        //assert
        assertEquals("Does not add new BetId to set", expected, actual);

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
    public void returnBetIdsAndClearCard() {
        //arrange
        PlayerCard playerCard = new PlayerCard();
        boolean expected = true;
        boolean actual = true;

        //act
        playerCard.generateNewBetID();
        int betCountBefore = 1;
        playerCard.returnBetIDsAndClearCard();
        int betCountAfter = playerCard.getNumberOfBetIDs();
        if (betCountBefore == betCountAfter){
            actual = false;
        }
        //assert
        assertEquals("returnBetIdsAndClearCard does not clear the card", expected, actual);

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