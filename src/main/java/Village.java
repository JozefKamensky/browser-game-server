import java.util.Arrays;
import java.util.List;

public class Village {
    private int playerId;
    private String name;
    private List<Building> buildings;
    private List<Resource> resources;
    private List<Troop> troops;

    public Village(int playerId) {
        this.playerId = playerId;
        this.name = "Village 01";
        this.buildings = Arrays.asList(
                new Building(BuildingType.MAIN_BUILDING, 1),
                new Building(BuildingType.BUILDING_RESOURCE_PROD, 1),
                new Building(BuildingType.TRAINING_RESOURCE_PROD, 1),
                new Building(BuildingType.BARRACKS, 0),
                new Building(BuildingType.WALLS, 0)
        );

        this.resources = Arrays.asList(
                new Resource(ResourceType.FOR_BUILDING, 200),
                new Resource(ResourceType.FOR_TRAINING, 200)
        );

        this.troops = Arrays.asList(
                new Troop(TroopType.DEFENSIVE, 0, playerId),
                new Troop(TroopType.OFFENSIVE, 0, playerId)
        );
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
