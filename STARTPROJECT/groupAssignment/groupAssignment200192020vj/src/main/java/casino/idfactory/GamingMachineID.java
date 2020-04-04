package casino.idfactory;

public class GamingMachineID extends GeneralID {
    public long ID;

    public GamingMachineID()
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
