package casino.gamingmachine;

import org.junit.Test;
import org.junit.runner.RunWith;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.BettingRound;
import casino.game.Game;
import junitparams.JUnitParamsRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class GamingMachineTest {

   //             - Passed_Amount_Is_More_Than_Zero
     //           -	amount_on_card_is_0_cents_PASS *
       //         -	amount_is_negative_should_return_false_PASS
         //       -	amount_is_positive_should_return_true_PASS
           //     -	amount_on_card_is_64_cents_PASS *

//    private static final Object[] FactoryGeneralIdTypes() {
//        return new Object[] {
//                new Object[] {
//                        "moneyAmount",new MoneyAmount(1),
//                        "bet",new Bet(1,Object instanceOf(Object.getClass()),
//                        "betResult",new BetResult(1,1)}
//        };
//    }
//    long amountInCents = 1;
//
//
//
////checks if the
//    @Test
//    public void Passed_Amount_Is_More_Than_Zero() throws NoPlayerCardException {
//        //arrange
//        GamingMachine gamingMachine = new GamingMachine();
//        IPlayerCard playerCard = new PlayerCard();
//
//        BettingRound bettingRound = mock(BettingRound.class);
//        Game game = mock(Game.class);
//
//        Bet bet = mock(Bet.class);
//
//        GamingMachine sut = new GamingMachine();
//        sut.placeBet(amountInCents);
//        //3.7
//        //68 then() arrage
//        //
//        verify(game.acceptBet(bet,gamingMachine)).booleanValue();
//
//        if(verify(bettingRound.placeBet(bet)).booleanValue();
//
//        //act
//        gamingMachine.connectCard(playerCard);
//        gamingMachine.placeBet(amountInCents);
//        gamingMachine.acceptWinner(winResult);
//
//        //gamingMachine.getGamingMachineID();
//
//        //assert
//
//        assertEquals(1,playerCard.getNumberOfBetIDs());
//        assertEquals(1,playerCard.returnBetIDs());
//
//    }
//
//    @Test
//    public void bettingRound_place_bet_returns_a_value() throws NoPlayerCardException {
//        //arrange
//        PlayerCard playerCard = mock(PlayerCard.class);
//        //BettingRound bettingRound = mock(BettingRound.class);
//        Bet bet = mock(Bet.class);
//
//        GamingMachine sut = new GamingMachine();
//
//        //act
//        sut.placeBet(amountInCents);
//
//        //gamingMachine.getGamingMachineID();
//
//        //assert
//        verify(sut.currentGame.currentBettingRound.placeBet(bet));
//    }

    @Test
    public void amount_is_negative_should_return_false_PASS() {

    }
    @Test
    public void amount_is_positive_should_return_true_PASS() {

    }
    @Test
    public void amount_on_card_is_64_cents_PASS() {

    }
    //accept winner
    @Test
    public void bet_placed_by_winner_should_be_accepted_PASS() {

    }
    @Test
    public void bet_placed_by_nonWinner_should_not_be_accepted_PASS() {

    }
    @Test
    public void amount_of_bets_on_machine_should_be_0_PASS() {

    }
    @Test
    public void winner_has_made_bet_amountOfBets_should_be_1_PASS() {

    }
    //connected card
    @Test
    public void should_return_card_id_PASS() {

    }


}