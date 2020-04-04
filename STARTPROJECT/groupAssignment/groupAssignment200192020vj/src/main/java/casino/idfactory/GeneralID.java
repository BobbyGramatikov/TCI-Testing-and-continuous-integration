package casino.idfactory;

import java.util.UUID;

public abstract class GeneralID implements Comparable {
    public UUID Id;
    public abstract void CreateID();
}

