package model;

public class Troop {
    private TroopType type;
    private int size;
    private int owningPlayerId;

    public Troop(TroopType type, int size, int owningPlayerId) {
        this.type = type;
        this.size = size;
        this.owningPlayerId = owningPlayerId;
    }

    public TroopType getType() {
        return type;
    }

    public void setType(TroopType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOwningPlayerId() {
        return owningPlayerId;
    }

    public void setOwningPlayerId(int owningPlayerId) {
        this.owningPlayerId = owningPlayerId;
    }
}
