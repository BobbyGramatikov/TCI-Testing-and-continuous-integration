package casino.idfactory;

public class BetID extends GeneralID implements Comparable {

    public long ID;

    public BetID()
    {
        CreateID();
    }
    @Override
    public void CreateID() {
        ID = Id.timestamp();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}