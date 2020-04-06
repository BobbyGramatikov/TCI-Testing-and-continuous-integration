package casino.game;

import bettingauthoritiyAPI.BetLoggingAuthority;
import bettingauthoritiyAPI.BetToken;
import casino.Casino;
import casino.bet.Bet;
import casino.idfactory.BettingRoundID;
import casino.idfactory.IDFactory;

import java.util.HashSet;
import java.util.Set;

public class BettingRound implements IBettingRound {

    BettingRoundID id;
    BetToken token;
    Set<Bet> bets;
    int numberOfBetsMade;
    private BettingRound currentBettingRound;

    public BettingRound(BetToken token)
    {
        IDFactory factory = new IDFactory();
        id = (BettingRoundID) factory.CreateID("casino.idfactory.BettingRoundID");
        this.token =token;
        bets = new HashSet<>();
        BettingRoundID bettingRoundID = new BettingRoundID();
        BetToken betToken = new BetToken(bettingRoundID);
    }

    @Override
    public BettingRound getBettingRoundID() {
        BetLoggingAuthority BLA = new BetLoggingAuthority();
        BLA.startBettingRound(currentBettingRound);
        return currentBettingRound;
    }

    @Override
    public boolean placeBet(Bet bet) {
        bets.add(bet);
        numberOfBetsMade++;
        return true;
    }
    @Override
    public Set<Bet> getAllBetsMade() {
        return bets;
    }

    @Override
    public BetToken getBetToken() {
        return null;
    }

    @Override
    public int numberOFBetsMade() {
        return numberOfBetsMade;
    }
}
