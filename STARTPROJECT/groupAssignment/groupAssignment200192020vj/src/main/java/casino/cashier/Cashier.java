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
    private Set<PlayerCard> distributedCards;
    private BetLoggingAuthority betLoggingAuthority;

    /*public Cashier(Set<PlayerCard> distributedCards, BetLoggingAuthority betLoggingAuthority){
        this.distributedCards = distributedCards;
        this.betLoggingAuthority = betLoggingAuthority;
    }*/

    @Override
    public IPlayerCard distributeGamblerCard() {
        PlayerCard playerCard = new PlayerCard();
        distributedCards.add(playerCard);
        betLoggingAuthority.handOutGamblingCard(playerCard.getCardID());

        return playerCard;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {
        distributedCards.remove(card);

        betLoggingAuthority.handInGamblingCard(card.getCardID(), card.returnBetIDs());

        card.returnBetIDsAndClearCard();
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {

        return false;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {
        long cardCents = card.getMoneyAmount().getAmountInCents();
        long amountCents = amount.getAmountInCents();
        amount.setAmountInCents(cardCents + amountCents);

        card.setMoneyAmount(amount);
    }

    public int getNumberOfDistributedCards(){
        return distributedCards.size();
    }

    public Set<PlayerCard> getDistributedCards(){
        return distributedCards;
    }

    public void setDistributedCards(Set<PlayerCard> distributedCards) {
        this.distributedCards = distributedCards;
    }

    public void setBetLoggingAuthority(BetLoggingAuthority betLoggingAuthority) {
        this.betLoggingAuthority = betLoggingAuthority;
    }
}
