package casino.idfactory;

public class BetID extends GeneralID implements Comparable<GeneralID> {

    public String ID;

    public BetID()
    {
        CreateID();
    }
    @Override
    public void CreateID() {
        ID = uuid.toString();
    }


    @Override
    public int compareTo(GeneralID o) {
        return this.GetID().compareTo(o.GetID());
    }

    @Override
    public String GetID() {
        return ID;
    }
}