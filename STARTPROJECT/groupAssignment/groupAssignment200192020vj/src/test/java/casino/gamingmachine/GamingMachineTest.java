package casino.gamingmachine;

import org.junit.Test;
import org.junit.runner.RunWith;

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
    public void acceptWinner_calls_cashierAmount_when_the_current_game_accepts_the_bet(BetResult winResult) throws{
        //arrange

        //assert
    }

    @Test
    public void game_accepts_bet_returns_false_bettingRound_placeBet_returns_false_gameingMachine_placeBet_return_false() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        sut = new GamingMachine();
        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.placeBet(amountInCents);
        when(sut.currentGame.acceptBet(bet,sut)).thenReturn(false);
        when(sut.currentGame.currentBettingRound.placeBet(bet)).thenReturn(false);
        //assert
        assertEquals("We expect a false outcome",false,sut.placeBet(amountInCents));
    }
    @Test
    public void game_accepts_bet_returns_true_bettingRound_should_call_placeBet_once() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        sut = new GamingMachine();
        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);

        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.placeBet(amountInCents);
        when(game.acceptBet(bet,sut)).thenReturn(true);

        //assert
        verify(game,times(1)).currentBettingRound.placeBet(bet);
    }
    @Test
    public void game_accepts_bet_and_returns_false_bettingRound_should_not_call_placeBet() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        sut = new GamingMachine();

        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);

        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;
        sut.placeBet(amountInCents);
        when(game.acceptBet(bet,sut)).thenReturn(false);
        //assert
        verify(game,never()).currentBettingRound.placeBet(bet);
    }

//    public void game_accepts_bet_and_returns_true() throws NoPlayerCardException, NoCurrentRoundException {
//        //arrange
//        GamingMachine gamingMachine = new GamingMachine();
//        IPlayerCard playerCard = new PlayerCard();
//
//        BettingRound bettingRound = mock(BettingRound.class);
//        Game game = mock(Game.class);
//
//        Casino casino = mock(Casino.class);
//        Bet bet = mock(Bet.class);
//
//        GamingMachine sut = new GamingMachine();
//        sut.placeBet(amountInCents);
//        //3.7
//        //68 then() arrage
//        when(game.acceptBet(bet,gamingMachine)).thenThrow(new NoCurrentRoundException);
//        //
//        game.currentBettingRound = gamingMachine.currentGame.currentBettingRound;
//        verify(game.acceptBet(bet,gamingMachine));
//
//        verify(bettingRound.placeBet(bet)).booleanValue();
//
//        //act
//        gamingMachine.connectCard(playerCard);
//        gamingMachine.placeBet(amountInCents);
//        gamingMachine.acceptWinner(winResult);
//
//        when(game.acceptBet(bet,gamingMachine).thenReturn )
//        //gamingMachine.getGamingMachineID();
//
//        //assert
//
//        assertEquals(1,playerCard.getNumberOfBetIDs());
//        assertEquals(1,playerCard.returnBetIDs());
//
//    }


    //checks if the
    @Test
    public void game_accepts_bet_and_returns_a_value() throws NoPlayerCardException, NoCurrentRoundException {
        //arrange
        sut = new GamingMachine();
        GamingMachine gamingMachine = spy(GamingMachine.class);

        Bet bet;
        BetID bi = new BetID();
        MoneyAmount ma = new MoneyAmount(amountInCents);
        bet = new Bet(bi,ma);

        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);

        //act
        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;

        sut.placeBet(amountInCents);
        //assert
        verify(game).acceptBet(bet,game.gamingMachine);
    }

    @Test
    public void bettingRound_placeBet_returns_false_gameingMachine_placeBet_return_false() throws NoPlayerCardException, NoCurrentRoundException{
        //arrange
        GamingMachine sut = new GamingMachine();

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
        GamingMachine sut = new GamingMachine();

        Bet bet = mock(Bet.class);
        Game game = mock(Game.class);
        BettingRound round = mock(BettingRound.class);
       // game.SetBettingRound(round);

        sut.setGame(game);
        sut.currentGame.currentBettingRound = round;

        //act
        sut.placeBet(amountInCents);
        //assert

        verify(game).currentBettingRound.placeBet(bet);
    }




}