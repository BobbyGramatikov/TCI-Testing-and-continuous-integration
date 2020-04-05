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

    }


    @Test
    public void Accept_Bet_True_When_4_Current_Bets_Placed() throws NoCurrentRoundException
    {
        Bet dummyBet = Mockito.mock(Bet.class); // dummy
        BettingRound currentBettingRound = Mockito.mock(BettingRound.class);
        GamingMachine gamingMachine = Mockito.mock(GamingMachine.class);
        Game sut = new Game(currentBettingRound);
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
        Game sut = new Game(null);
        sut.acceptBet(dummyBet, gamingMachine );
    }

// A bet on a game is submitted through betting machines (to which Players have connected their gambling card).
// Max 1 bet per machine can be submitted for the current betting round in a game.
// When a submitted Bet is added to the Game, that excepted Bet is stored by the Betting Round,
// and is also sent to the Gambling Authority.

    @Test
    public void determineWinner()
    {

    }

    @Test
    public void isBettingRoundFinished()
    {

    }
}