package casino.idfactory;

public class BettingRoundID extends GeneralID implements Comparable {
    public long ID;

    public BettingRoundID()
    {
        CreateID();
    }

    @Override
    public void CreateID() {
        ID = uuid.timestamp();
    }

    @Override
    public int compareTo(Object o) {
         return 0;
    }
}