package casino.game;

import bettingauthoritiyAPI.BetTokenAuthority;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetTokenAuthority;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;

import java.util.Set;


public class Game implements IGame {

    public BetTokenAuthority auth;
    public BettingRound currentBettingRound;
    public GameRules gameRules;
    public GamingMachine gamingMachine;

    public Game(BetTokenAuthority auth,BettingRound round,GameRules rules,GamingMachine machine)
    {
        this.auth= auth;
        this.currentBettingRound=round;
        this.gameRules = rules;
        this.gamingMachine = machine;
    }

    @Override
    public void startBettingRound() {
        currentBettingRound = new BettingRound(auth.getBetToken(currentBettingRound.id));
    }

    @Override
    public boolean acceptBet(Bet bet, GamingMachine gamingMachine) throws NoCurrentRoundException {
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
    public void determineWinner()
    {
        Set<Bet> myBets = currentBettingRound.getAllBetsMade();
        BetResult betResultWinner = gameRules.determineWinner(auth.getRandomInteger(currentBettingRound.token) ,myBets);
        gamingMachine.acceptWinner(betResultWinner);
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

    @Override
    public void SetGamingMachine(GamingMachine machine) {
        this.gamingMachine = machine;
    }

    @Override
    public void SetBettingAuthority(BetTokenAuthority auth) {
        this.auth =auth;
    }


}
