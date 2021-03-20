public class Building {
    private BuildingType type;
    private int level;

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Building(BuildingType type, int level) {
        this.type = type;
        this.level = level;
    }
}
