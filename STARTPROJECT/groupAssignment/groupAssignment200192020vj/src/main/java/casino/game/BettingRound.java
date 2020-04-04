package casino.game;

import bettingauthoritiyAPI.BetToken;
import casino.bet.Bet;

import java.util.Set;

public class BettingRound implements IBettingRound {
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
