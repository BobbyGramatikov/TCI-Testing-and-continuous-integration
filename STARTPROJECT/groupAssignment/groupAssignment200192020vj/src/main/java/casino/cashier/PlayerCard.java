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

    public PlayerCard(){
        IDFactory factory = new IDFactory();
        cardID = (CardID) factory.CreateID("card");
        MoneyAmount moneyAmount = new MoneyAmount(0);

    }

    public PlayerCard(MoneyAmount moneyAmount){
        IDFactory factory = new IDFactory();
        cardID = (CardID) factory.CreateID("card");

        this.moneyAmount = moneyAmount;
    }

    @Override
    public Set<BetID> returnBetIDs() {
        return betIDs;
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        Set<BetID> returnBets = betIDs;
        betIDs.clear();



        return returnBets;
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
