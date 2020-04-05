package casino.game;
import bettingauthoritiyAPI.BetTokenAuthority;
import casino.bet.Bet;
import casino.gamingmachine.GamingMachine;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
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

    Game sut;

    @Before
    public void setUp()
    {
        BetTokenAuthority dummyAuth = Mockito.mock(BetTokenAuthority.class);
        GameRules dummyRules= Mockito.mock(GameRules.class);
        GamingMachine dummyMachine = Mockito.mock(GamingMachine.class);
        BettingRound dummyRound = Mockito.mock(BettingRound.class);
        sut = new Game(dummyAuth,dummyRound,dummyRules,dummyMachine);
    }

    @Test
    public void Start_Betting_Round_Creates_New_Betting_Round_With_New_Id()
    {

        sut.startBettingRound();
        BettingRound oldRound = sut.currentBettingRound;
        assertThat(oldRound.id,not(nullValue()));
        sut.startBettingRound();
        BettingRound newRound = sut.currentBettingRound;
        assertThat(newRound.id,not(nullValue()));
        assertThat(oldRound.id.compareTo(newRound.id),not(0));
    }

    @Test
    public void Accept_Bet_True_When_4_Current_Bets_Placed() throws NoCurrentRoundException
    {
        Bet dummyBet = Mockito.mock(Bet.class); // dummy
        BettingRound currentBettingRound = Mockito.mock(BettingRound.class);
        GamingMachine gamingMachine = Mockito.mock(GamingMachine.class);
        sut.SetBettingRound(currentBettingRound);
        Mockito.when(currentBettingRound.numberOFBetsMade()).thenReturn(4);
        assertThat(sut.acceptBet(dummyBet, gamingMachine), is(true));
        Mockito.when(currentBettingRound.numberOFBetsMade()).thenReturn(5);
        assertThat(sut.acceptBet(dummyBet, gamingMachine ), is(false));

    }


    @Test(expected = NoCurrentRoundException.class)
    public void Accept_Bet_Throw_No_Current_Round_Exception() throws NoCurrentRoundException
    {
        Bet dummyBet = Mockito.mock(Bet.class);
        GamingMachine gamingMachine = Mockito.mock(GamingMachine.class);
        sut.SetBettingRound(null);
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



    /**
     * determine if the right number of bets are done (determined by gamerules) to be able to
     * calculate a winner.
     * @return true if all necessary bets are made in the betting round, otherwise false
     */
    @Test
    public void isBettingRoundFinished()
    {
        BettingRound bettingRound= Mockito.mock(BettingRound.class);
        GameRules gameRules = Mockito.mock(GameRules.class);
        sut.SetBettingRound(bettingRound);
        sut.SetGameRules(gameRules);
        Mockito.when(gameRules.getMaxBetsPerRound()).thenReturn(5);
        Mockito.when(bettingRound.numberOFBetsMade()).thenReturn(4);
        assertFalse(sut.isBettingRoundFinished());
        Mockito.when(sut.currentBettingRound.numberOFBetsMade()).thenReturn(5);
        assertTrue(sut.isBettingRoundFinished());
    }
}