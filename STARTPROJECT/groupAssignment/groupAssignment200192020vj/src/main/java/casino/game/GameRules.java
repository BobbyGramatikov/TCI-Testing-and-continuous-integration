package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;

import java.util.Set;

public class GameRules implements IGameRule {

    private int m_MaxBetsPerRound=5;

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        return null;
    }

    @Override
    public int getMaxBetsPerRound() {
        return m_MaxBetsPerRound;
    }
}
