package casino.game;

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

    public BettingRound(BetToken token)
    {
        IDFactory factory = new IDFactory();
        id = (BettingRoundID) factory.CreateID("round");
        this.token =token;
        bets = new HashSet<>();
    }
    @Override
    public BettingRound getBettingRoundID() {
        return null;
    }


    @Override
    public boolean placeBet(Bet bet) {
        return false;
    }


    @Override
    public Set<Bet> getAllBetsMade() {
        return null;
    }

    @Override
    public BetToken getBetToken() {
        return null;
    }

    @Override
    public int numberOFBetsMade() {
        return 0;
    }
}
