package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;

import java.lang.reflect.Array;
import java.util.Set;

public class GameRules implements IGameRule {

    private int m_MaxBetsPerRound=5;

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        Bet[] bets1 = new Bet[bets.size()];
        System.out.print("length: "+ bets1.length);
        BetResult winner = CreateBetResult(bets.toArray(bets1)[randomWinValue],bets.toArray(bets1)[randomWinValue].getMoneyAmount());
        return winner;
    }

    @Override
    public int getMaxBetsPerRound() {
        return m_MaxBetsPerRound;
    }

    BetResult CreateBetResult(Bet winningBet, MoneyAmount amount)
    {
        return  new BetResult(winningBet,amount);
    }
}
