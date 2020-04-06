package casino.bet;

import casino.idfactory.BetID;

/**
 * immutable class.
 * keeps unique betID and moneyamount in the bet.
 */
public class Bet extends BetID {
    private BetID betID;
    private MoneyAmount moneyAmount;

    public Bet(BetID betID, MoneyAmount moneyAmount) {
        this.betID = betID;
        this.moneyAmount = moneyAmount;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject)
        return  true;
    if(anObject == null || getClass() != anObject.getClass())
        return  false;
    Bet bet = (Bet) anObject;
    return betID == (bet.getBetID());
    }

    public BetID getBetID() {
        return betID;
    }

    public MoneyAmount getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(MoneyAmount moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
