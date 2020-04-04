package casino.idfactory;


public class CardID extends GeneralID implements Comparable{
    public long ID;

    public CardID()
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