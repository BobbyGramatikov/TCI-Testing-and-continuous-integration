package casino.gamingmachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import casino.Casino;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.Cashier;
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

        //assert
        when(game.acceptBet(bet,sut)).thenReturn(true);
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

        //assert
        when(game.acceptBet(bet,sut)).thenReturn(false);
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

        //assert
        when(sut.currentGame.currentBettingRound.placeBet(bet)).thenReturn(false);
        assertFalse("We expect a false outcome", sut.placeBet(amountInCents));
    }
    @Test
    public void bettingRound_place_bet_returns_a_value() throws NoPlayerCardException, NoCurrentRoundException {

        //arrange
        sut = new GamingMachine();
        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);

        //act
        sut.currentConnectedCard = card;
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.placeBet(amountInCents);

        //assert
        verify(game).currentBettingRound.placeBet(bet);
    }

    @Test
    public void accept_winner_does_not_call_cashier_to_update_when_game_acceptBet_returns_false() throws NoCurrentRoundException {

        //arrange
        sut = new GamingMachine();
        Bet bet = mock(Bet.class);
        BetResult betResult = mock(BetResult.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);
        Cashier cashier = mock(Cashier.class);
        MoneyAmount ma = mock(MoneyAmount.class);

        //act
        sut.currentConnectedCard = card;
        sut.setGame(game);
        sut.setCashier(cashier);
        sut.currentGame.currentBettingRound = round;
        //assert

        sut.acceptWinner(betResult);
        when(game.acceptBet(bet,sut)).thenReturn(false);
        verify(cashier,never()).addAmount(card,ma);
    }

    /*&@Test
    public void when_acceptWinner_is_called_acceptBet_must_be_called() throws NoCurrentRoundException {

        //arrange
        GamingMachine gm = mock(GamingMachine.class);
        sut = new GamingMachine();
        BetResult betResult = mock(BetResult.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        PlayerCard card = mock(PlayerCard.class);
        Cashier cashier = mock(Cashier.class);
        MoneyAmount ma = new MoneyAmount(amountInCents);
        Bet bet = mock(Bet.class);
        bet.setMoneyAmount(ma);

        //act
        sut.currentConnectedCard = card;
        game.gamingMachine = gm;
        sut.setGame(game);
        sut.setCashier(cashier);
        sut.currentGame.currentBettingRound = round;
        //assert

        sut.acceptWinner(betResult);
        when(game.acceptBet(bet,sut)).thenReturn(false);
        verify(game).acceptBet(bet,game.gamingMachine);
    }
    */

}