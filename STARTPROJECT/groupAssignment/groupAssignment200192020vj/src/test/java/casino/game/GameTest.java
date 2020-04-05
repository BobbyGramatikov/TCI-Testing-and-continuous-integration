package casino.game;
import casino.bet.Bet;
import casino.gamingmachine.GamingMachine;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@RunWith(JUnitParamsRunner.class)

public class GameTest {


    @Test
    public void startBettingRound()
    {
        Game sut = new Game();
        BettingRound oldRound = sut.currentBettingRound;
        sut.startBettingRound();
        BettingRound newRound = sut.currentBettingRound;
        assertThat(oldRound.id.compareTo(newRound.id),not(0));
    }


    @Test
    public void Accept_Bet_True_When_4_Current_Bets_Placed() throws NoCurrentRoundException
    {
        Bet dummyBet = Mockito.mock(Bet.class); // dummy
        BettingRound currentBettingRound = Mockito.mock(BettingRound.class);
        GamingMachine gamingMachine = Mockito.mock(GamingMachine.class);
        Game sut = new Game();
        sut.SetBettingRound(currentBettingRound);
        Mockito.when(currentBettingRound.numberOFBetsMade()).thenReturn(4);
        assertThat(sut.acceptBet(dummyBet, gamingMachine), is(true));
        Mockito.when(currentBettingRound.numberOFBetsMade()).thenReturn(5);
        assertThat(sut.acceptBet(dummyBet, gamingMachine ), is(false));

    }


    @Test(expected = NoCurrentRoundException.class)
    public void Accept_Bet_Throw_No_Current_Round_Exception() throws NoCurrentRoundException
    {
        Bet dummyBet = Mockito.mock(Bet.class); // dummy
        BettingRound currentBettingRound = Mockito.mock(BettingRound.class);
        GamingMachine gamingMachine = Mockito.mock(GamingMachine.class);
        Game sut = new Game();
        sut.acceptBet(dummyBet, gamingMachine );
    }


    /**
     * Calculate the winner using the gamerules.
     * Let the gamingMachine update the winner's amount at the bank teller
     *
     * log relevant information for the betloggingauthority.
     */
    @Test
    public void determineWinner()
    {

    }

    @Test
    public void isBettingRoundFinished()
    {

    }
}