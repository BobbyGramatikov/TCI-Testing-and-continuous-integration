package casino.cashier;

import casino.ICasino;
import casino.bet.Bet;
import casino.game.IGame;

class BetNotExceptedException extends Exception {
    public BetNotExceptedException(String errorMessage) {
        super(errorMessage);
    }
}

public class Cashier implements ICasino {
    @Override
    public void addGame(String gameName, IGame gameToAdd) {

    }

    @Override
    public IGame getGame(String name) {
        return null;
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return false;
    }

}
