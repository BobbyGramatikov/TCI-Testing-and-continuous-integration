package casino.gamingmachine;

import casino.bet.BetResult;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;

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
    PlayerCard currentConnectedCard =new PlayerCard();


    @Override
    public boolean placeBet(long amountInCents) throws NoPlayerCardException {
        return false;
        // place bet
    }

    @Override
    public void acceptWinner(BetResult winResult) {

    }

    @Override
    public GamingMachine getGamingMachineID() {
        return null;
    }

    @Override
    public void connectCard(IPlayerCard card) {

    }
}
