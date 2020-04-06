package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.Cashier;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.BettingRound;
import casino.game.Game;
import casino.game.NoCurrentRoundException;
import casino.idfactory.GamingMachineID;

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
    PlayerCard currentConnectedCard;
    BettingRound br;
    Game currentGame;
    private Cashier cashier;

    private GamingMachineID gameingMachineID;

    public GamingMachine(){
        gameingMachineID = new GamingMachineID();
    }
    public void setCashier(Cashier cashier){
        this.cashier = cashier;
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

       // BettingRound br = new BettingRound();
       //currentGame.SetBettingRound(br);

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
        try {
            if(currentGame.acceptBet(winResult.getWinningBet(),this)){

                currentGame.determineWinner();

                MoneyAmount ma = new MoneyAmount(winResult.getAmountWon().getAmountInCents());
                cashier.addAmount(currentConnectedCard,ma);
            }
        } catch (NoCurrentRoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public GamingMachineID getGamingMachineID() {
        return this.gameingMachineID;
    }
    //mutable


    @Override
    public void connectCard(IPlayerCard card) {
           currentConnectedCard = (PlayerCard) card;
    }
}
