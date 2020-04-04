package casino.idfactory;

public class BetID extends GeneralID implements Comparable {

    public long ID=0;

    public BetID()
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