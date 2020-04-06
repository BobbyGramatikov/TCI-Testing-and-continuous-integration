package casino.idfactory;


import casino.cashier.PlayerCard;

public class CardID extends GeneralID implements Comparable<GeneralID> {
    public String ID;

    public CardID()
    {
        CreateID();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject)
            return  true;
        if(anObject == null || getClass() != anObject.getClass())
            return  false;
        CardID cardID = (CardID) anObject;
        return ID == (cardID.ID);
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