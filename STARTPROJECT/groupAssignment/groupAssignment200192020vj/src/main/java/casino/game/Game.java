package casino.game;

import casino.bet.Bet;
import casino.gamingmachine.IGamingMachine;


public class Game implements IGame {

    public BettingRound currentBettingRound;
    public GameRules gameRules;
    @Override
    public void startBettingRound() {
        currentBettingRound = new BettingRound();
    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
        if (currentBettingRound == null)
        {
            throw new NoCurrentRoundException("Please add a round first.");
        }
        if(currentBettingRound.numberOFBetsMade()<5){
        return true;
        }
        else
            {
            return false;
        }
    }

    @Override
    public void determineWinner() {

    }

    @Override
    public boolean isBettingRoundFinished()
    {
        if(currentBettingRound.numberOFBetsMade() < gameRules.getMaxBetsPerRound())
        {
            return false;
        }
        else
            return true;

    }

    @Override
    public void SetBettingRound(BettingRound round) {
        this.currentBettingRound = round;
    }

    @Override
    public void SetGameRules(GameRules rules) {
        this.gameRules = rules;
    }
}
