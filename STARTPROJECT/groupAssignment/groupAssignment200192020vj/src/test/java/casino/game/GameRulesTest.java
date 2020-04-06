package casino.game;
import java.lang.Object;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.IDFactory;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class GameRulesTest {

    @Test
    public void Bet_Result_Is_Found_From_Current_Bets_And_Returned_Successfully() {
        IDFactory factory = Mockito.mock(IDFactory.class);
        GameRules sut = new GameRules();
        MoneyAmount dummyAmount = Mockito.mock(MoneyAmount.class);
        Bet mockBet1 = new Bet((BetID) factory.CreateID("bet"), dummyAmount);
        Bet mockBet2 = new Bet((BetID) factory.CreateID("bet"), dummyAmount);
        Bet mockBet3 = new Bet((BetID) factory.CreateID("bet"), dummyAmount);
        Set<Bet> betSet = new HashSet<Bet>(Arrays.asList(mockBet1, mockBet2, mockBet3));
        int randomWinValue = 3;
        BetResult winner = Mockito.mock(BetResult.class);
        Mockito.when(sut.determineWinner(randomWinValue, betSet)).thenReturn(winner);
        assertThat(winner.getWinningBet().getBetID(), anyOf(is(mockBet1), is(mockBet2), is(mockBet3)));
    }

    @Test
    public void getMaxBetsPerRound() {
    }
}