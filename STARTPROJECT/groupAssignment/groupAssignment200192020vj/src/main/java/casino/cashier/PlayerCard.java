package casino.cashier;
import casino.bet.Bet;
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
    public boolean equals(Object anObject) {
        if (anObject instanceof PlayerCard) {
            PlayerCard playerCard = (PlayerCard) anObject;
            return playerCard.getCardID().equals(getCardID())
                    && getCardID().GetID() == playerCard.getCardID().GetID();
        }
        return false;
    }

    public PlayerCard(){
        IDFactory factory = new IDFactory();
        this.cardID = (CardID) factory.CreateID("card");
        this.moneyAmount = new MoneyAmount(0);

    }

    public PlayerCard(MoneyAmount moneyAmount){
        IDFactory factory = new IDFactory();
        cardID = (CardID) factory.CreateID("card");

        this.moneyAmount = moneyAmount;
    }

    @Override
    public Set<BetID> returnBetIDs() {
        Set<BetID> copyBetIDs = new HashSet<>();
        copyBetIDs.addAll(betIDs);

        return copyBetIDs;
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        Set<BetID> copyBetIDs = new HashSet<>();
        copyBetIDs.addAll(betIDs);

        betIDs.clear();

        moneyAmount = new MoneyAmount(0);

        return copyBetIDs;
    }

    @Override
    public BetID generateNewBetID() {
        IDFactory factory = new IDFactory();
        betId = (BetID) factory.CreateID("casino.game.CardID");

        betIDs.add(betId);

        return betId;
    }

    @Override
    public int getNumberOfBetIDs() {
        return betIDs.size();
    }

    @Override
    public CardID getCardID() {
        return cardID;
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
