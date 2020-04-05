package casino.cashier;
import casino.bet.MoneyAmount;
import casino.idfactory.BetID;
import casino.idfactory.BettingRoundID;
import casino.idfactory.CardID;
import casino.idfactory.IDFactory;

import java.util.HashSet;
import java.util.Set;


public class PlayerCard implements IPlayerCard {

    public CardID cardID;
    private MoneyAmount moneyAmount;
    private Set<BetID> betIDs = new HashSet<>();
    BetID betId;



    @Override
    public Set<BetID> returnBetIDs() {

        return betIDs;
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        return null;
    }

    @Override
    public BetID generateNewBetID() {
        IDFactory factory = new IDFactory();
        betId = (BetID) factory.CreateID("bet");

        betIDs.add(betId);

        return betId;
    }

    @Override
    public int getNumberOfBetIDs() {
        return betIDs.size();
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
