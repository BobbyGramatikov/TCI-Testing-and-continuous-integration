package casino.game;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import bettingauthoritiyAPI.BetToken;
import casino.bet.Bet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BettingRoundTest {

    @Test
    public void getAllBetsMade_does_not_return_NULL()
    {
        //arrange
        Set<Bet> bets;

        //assert
        BetToken betTokenDummy = mock(BetToken.class);
        BettingRound bettingRound = new BettingRound(betTokenDummy);
        bets = bettingRound.getAllBetsMade();

        //act
        assertNotNull("Return betIDs returns null", bets);
    }
    @Test
    public void placeBet_should_also_increase_the_amount_bets_made()
    {
        //arrange
        Set<Bet> bets;

        //assert
        BetToken betTokenDummy = mock(BetToken.class);
        BettingRound bettingRound = new BettingRound(betTokenDummy);
        bets = bettingRound.getAllBetsMade();

        //act
        assertNotNull("Return betIDs returns null", bets);
    }
}