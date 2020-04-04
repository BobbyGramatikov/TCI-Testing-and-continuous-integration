package casino.idfactory;

import java.util.UUID;

public abstract class GeneralID implements Comparable {
    public UUID uuid = UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66");
    public abstract void CreateID();
}

