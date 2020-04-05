package casino.idfactory;

import casino.game.BettingRound;
import org.jetbrains.annotations.NotNull;

public class BettingRoundID extends GeneralID implements Comparable<GeneralID> {
    private String ID;

    public BettingRoundID()
    {
        CreateID();
    }

    @Override
    public void CreateID() {
        ID = uuid.toString();
    }

    @Override
    public String GetID() {
        return ID;
    }

    @Override
    public int compareTo(GeneralID o) {
        return this.GetID().compareTo(o.GetID());
    }
}