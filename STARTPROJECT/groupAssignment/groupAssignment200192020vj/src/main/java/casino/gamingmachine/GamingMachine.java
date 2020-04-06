package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.BettingRound;
import casino.game.Game;
import casino.game.NoCurrentRoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class NoPlayerCardException extends Exception {
    public NoPlayerCardException(String errorMessage) {
        super(errorMessage);
    }
}

public class GamingMachine implements IGamingMachine
{
    PlayerCard currentConnectedCard = new PlayerCard();
    BettingRound br;
    Game currentGame;
    public GamingMachine(){

    }

    public void setGame(Game game){
        currentGame = game;
    }
    //setters

    @Override
    public boolean placeBet(long amountInCents) throws NoPlayerCardException, NoCurrentRoundException {
        // place bet
        boolean result;
        MoneyAmount ma = new MoneyAmount(amountInCents);

        Bet bet = new Bet(currentConnectedCard.generateNewBetID(),ma);

//        BettingRound br = new BettingRound();
//        currentGame.SetBettingRound(br);

        if(currentGame.acceptBet(bet,this)){
            result = currentGame.currentBettingRound.placeBet(bet);
            return result;
        }

        return false;

    }

    @Override
    public void acceptWinner(BetResult winResult) {
//call method game
     /* Accept the BetResult from the winner.
     * clear all open bets on this machine.
     * when the winner has made his bet in this machine: let the Cashier update the amount.
     */

    }

    @Override
    public GamingMachine getGamingMachineID() {
        return casino.gamingmachine.GamingMachine.this;
    }

    //setter don't check
    @Override
    public void connectCard(IPlayerCard card) {

    }
}
