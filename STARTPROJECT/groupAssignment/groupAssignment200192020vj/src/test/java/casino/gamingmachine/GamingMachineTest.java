package casino.gamingmachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import casino.Casino;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.BettingRound;
import casino.game.Game;
import casino.game.NoCurrentRoundException;
import casino.idfactory.BetID;
import junitparams.JUnitParamsRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class GamingMachineTest {

   //             - Passed_Amount_Is_More_Than_Zero
     //           -	amount_on_card_is_0_cents_PASS *
       //         -	amount_is_negative_should_return_false_PASS
         //       -	amount_is_positive_should_return_true_PASS
           //     -	amount_on_card_is_64_cents_PASS *


    long amountInCents = 1;
    GamingMachine sut;

    @Test
    public void game_accepts_bet_returns_true_bettingRound_should_call_placeBet_once() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        sut = new GamingMachine();
        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);

        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.currentConnectedCard = card;
        sut.placeBet(amountInCents);

        when(game.acceptBet(bet,sut)).thenReturn(true);

        //assert
        verify(game,times(1)).currentBettingRound.placeBet(bet);
    }
    @Test
    public void game_accepts_bet_and_returns_false_placeBet_should_not_be_called() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        sut = new GamingMachine();

        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);

        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.currentConnectedCard = card;
        sut.placeBet(amountInCents);

        when(game.acceptBet(bet,sut)).thenReturn(false);
        //assert
        verify(game,never()).currentBettingRound.placeBet(bet);
    }

    @Test
    public void bettingRound_placeBet_returns_false_gameingMachine_placeBet_return_false() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
         sut = new GamingMachine();

        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);
        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.currentConnectedCard = card;

        sut.placeBet(amountInCents);
        when(sut.currentGame.currentBettingRound.placeBet(bet)).thenReturn(false);

        //assert
        assertFalse("We expect a false outcome", sut.placeBet(amountInCents));
    }
    @Test
    public void bettingRound_place_bet_returns_a_value() throws NoPlayerCardException, NoCurrentRoundException {
        //arrange
        //GamingMachine sut = mock(GamingMachine.class);
         sut = new GamingMachine();

        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);
        sut.currentConnectedCard = card;

        // game.SetBettingRound(round);

        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;

        //act
        sut.placeBet(amountInCents);
        //assert

        verify(game).currentBettingRound.placeBet(bet);
    }




}