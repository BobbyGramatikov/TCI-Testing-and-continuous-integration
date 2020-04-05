package casino.cashier;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.CardID;

import java.util.Set;


public class PlayerCard implements IPlayerCard {

    public long Id;
    private MoneyAmount moneyAmount;
    private Set<BetID> betIDs;
    BetID betId;

    @Override
    public Set<BetID> returnBetIDs() {
        return null;
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        return null;
    }

    @Override
    public BetID generateNewBetID() {
        betId = new BetID();

        return null;
    }

    @Override
    public int getNumberOfBetIDs() {
        return 0;
    }

    @Override
    public CardID getCardID() {
        return null;
    }

    @Override
    public MoneyAmount getMoneyAmount() {
        return moneyAmount;
    }

    @Override
    public void setMoneyAmount(MoneyAmount moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
