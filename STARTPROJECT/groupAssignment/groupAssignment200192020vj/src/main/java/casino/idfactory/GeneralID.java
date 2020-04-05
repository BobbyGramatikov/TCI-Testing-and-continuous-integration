package casino.idfactory;

import java.util.UUID;


public abstract class GeneralID implements Comparable<GeneralID> {
    public UUID uuid = UUID.randomUUID();
    public abstract void CreateID();
    public abstract String GetID();
}

