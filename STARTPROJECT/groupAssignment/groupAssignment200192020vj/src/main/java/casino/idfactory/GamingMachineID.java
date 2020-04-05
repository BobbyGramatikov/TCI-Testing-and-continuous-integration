package casino.idfactory;

public class GamingMachineID extends GeneralID implements Comparable<GeneralID> {
    public String ID;

    public GamingMachineID()
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

