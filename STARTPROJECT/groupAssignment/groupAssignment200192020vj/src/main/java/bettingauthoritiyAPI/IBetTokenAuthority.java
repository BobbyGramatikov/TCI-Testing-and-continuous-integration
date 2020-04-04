package bettingauthoritiyAPI;

import casino.idfactory.BettingRoundID;

public interface IBetTokenAuthority {
    BetToken getBetToken(BettingRoundID bettingRoundID);

    Integer getRandomInteger(BetToken betToken);
}
