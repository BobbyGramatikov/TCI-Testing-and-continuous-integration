package casino.game;

import casino.bet.Bet;
import casino.gamingmachine.IGamingMachine;


class NoCurrentRoundException extends Exception {
    public NoCurrentRoundException(String errorMessage) {
        super(errorMessage);
    }
}

public class Game implements IGame {

    public BettingRound currentBettingRound= new BettingRound();

    @Override
    public void startBettingRound() {

    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
        if(currentBettingRound.numberOFBetsMade()<5){
        return true;
        }
        else
            return false;
    }

    @Override
    public void determineWinner() {

    }

    @Override
    public boolean isBettingRoundFinished() {
        return false;
    }
}
