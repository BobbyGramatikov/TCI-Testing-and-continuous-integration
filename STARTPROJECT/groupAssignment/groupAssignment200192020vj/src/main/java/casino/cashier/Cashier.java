package casino.cashier;

import casino.ICasino;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.game.IGame;

class BetNotExceptedException extends Exception {
    public BetNotExceptedException(String errorMessage) {
        super(errorMessage);
    }
}


public class Cashier implements ICashier {

    @Override
    public IPlayerCard distributeGamblerCard() {
        PlayerCard playerCard = new PlayerCard();
        return playerCard;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {
        card.returnBetIDsAndClearCard();
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {

        return false;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {
        long newMoney = card.getMoneyAmount().getAmountInCents() + amount.getAmountInCents();
        MoneyAmount newMoneyAmount = new MoneyAmount(newMoney);

        card.setMoneyAmount(newMoneyAmount);
    }
}
