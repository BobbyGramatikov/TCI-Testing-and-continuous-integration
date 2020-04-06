package casino.cashier;

import bettingauthoritiyAPI.BetLoggingAuthority;
import casino.ICasino;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.game.IGame;

import java.util.HashSet;
import java.util.Set;

class BetNotExceptedException extends Exception {
    public BetNotExceptedException(String errorMessage) {
        super(errorMessage);
    }
}


public class Cashier implements ICashier {
    Set<PlayerCard> distributedCards = new HashSet<>();
    BetLoggingAuthority betLoggingAuthority = new BetLoggingAuthority();;

    @Override
    public IPlayerCard distributeGamblerCard() {
        PlayerCard playerCard = new PlayerCard();

        //betLoggingAuthority.handOutGamblingCard(playerCard.getCardID());

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
        //long newMoney = card.getMoneyAmount().getAmountInCents() + amount.getAmountInCents();
        //MoneyAmount newMoneyAmount = new MoneyAmount(newMoney);
        amount.setAmountInCents(card.getMoneyAmount().getAmountInCents() + amount.getAmountInCents());

        card.setMoneyAmount(amount);
    }

    public int getNumberOfDistributedCards(){
        return distributedCards.size();
    }
}
