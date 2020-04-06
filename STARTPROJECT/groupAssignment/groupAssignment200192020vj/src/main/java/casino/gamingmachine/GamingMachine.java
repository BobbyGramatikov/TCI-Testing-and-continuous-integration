package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.BettingRound;
import casino.game.Game;

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

    public void setGame(Game game){
        currentGame = game;
    }
    //setters

    @Override
    public boolean placeBet(long amountInCents) throws NoPlayerCardException {
        // place bet

        MoneyAmount ma = new MoneyAmount(amountInCents);

        Bet bet = new Bet(currentConnectedCard.generateNewBetID(),ma);

//        BettingRound br = new BettingRound();
//        currentGame.SetBettingRound(br);

    boolean result = currentGame.currentBettingRound.placeBet(bet);
        return  result;


    }

    @Override
    public void acceptWinner(BetResult winResult) {
//call method game
    }

    @Override
    public GamingMachine getGamingMachineID() {
        return null;
    }

    //setter don't check
    @Override
    public void connectCard(IPlayerCard card) {

    }
}
