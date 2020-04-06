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
import org.mockito.internal.configuration.injection.MockInjection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class GameRulesTest {

   @Test
    public void Bet_Result_Is_Found_From_Current_Bets_And_Returned_Successfully() {
       GameRules sut = Mockito.spy(new GameRules());
       Bet mockBet1 = Mockito.mock(Bet.class);
       Bet mockBet2 = Mockito.mock(Bet.class);
       Bet mockBet3 = Mockito.mock(Bet.class);
       Set<Bet> betSet = new HashSet<Bet>(Arrays.asList(mockBet1,mockBet2,mockBet3));
       BetResult result = sut.determineWinner(1,betSet);
       assertThat("if random value is '1' returns the Bet with index '1' from the set of Bets. If index is changes, another mockBet will be returned",result.getWinningBet(),equalTo(mockBet2));
   }

    @Test
    public void Get_Max_Bets_per_Round_Returns_Correct_Value() {
        GameRules sut = Mockito.spy(new GameRules());
        Mockito.when(sut.getMaxBetsPerRound()).thenReturn(5);
        assertThat("if max bets per round is 5, then getMaxBetsPerRound returns 5",sut.getMaxBetsPerRound(),is(5));
    }
}