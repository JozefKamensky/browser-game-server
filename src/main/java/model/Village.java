package model;

import exceptions.BarracksNotBuiltException;
import exceptions.MaximumLevelOfBuildingReached;
import exceptions.MaximumNumberOfTroopsReached;
import exceptions.NotEnoughResourcesException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Village {
    private final int playerId;
    private String name;
    private final List<Building> buildings;
    private final List<Resource> resources;
    private List<Troop> troops;

    public Village(int playerId) {
        this(playerId, new VillageParameters());
    }

    public Village(int playerId, VillageParameters parameters) {
        this.playerId = playerId;
        this.name = "Village 01";
        this.buildings = Arrays.asList(
                new Building(BuildingType.MAIN_BUILDING, parameters.getMainBuildingLevel()),
                new Building(BuildingType.CONSTRUCTION_RESOURCE_PROD, parameters.getConstructionProdLevel()),
                new Building(BuildingType.TRAINING_RESOURCE_PROD, parameters.getTrainingProdLevel()),
                new Building(BuildingType.SUPPLY_CENTER, parameters.getSupplyCenterLevel()),
                new Building(BuildingType.BARRACKS, parameters.getBarracksLevel()),
                new Building(BuildingType.WALLS, parameters.getWallsLevel())
        );

        this.resources = Arrays.asList(
                new Resource(ResourceType.FOR_BUILDING, parameters.getConstructionResources()),
                new Resource(ResourceType.FOR_TRAINING, parameters.getTrainingResources())
        );

        this.troops = Arrays.asList(
                new Troop(TroopType.DEFENSIVE, parameters.getDefensiveTroopsCount(), playerId),
                new Troop(TroopType.OFFENSIVE, parameters.getOffensiveTroopsCount(), playerId)
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

    public Map<BuildingType, Integer> getBuildingLevels() {
        return this.buildings.stream().collect(Collectors.toMap(Building::getType, Building::getLevel));
    }

    public void upgradeBuilding(BuildingType buildingType) throws MaximumLevelOfBuildingReached, NotEnoughResourcesException {
        int currentLevel = this.buildings.stream().filter(b -> b.getType().equals(buildingType)).findFirst().orElseThrow().getLevel();
        int maxLevel = BuildingInfo.getMaxLevel(buildingType);

        if (currentLevel == maxLevel) {
            throw new MaximumLevelOfBuildingReached();
        }

        int resourcesNeeded = BuildingInfo.getResourcesNeeded(buildingType, currentLevel + 1);
        int resourcesPresent = this.resources.stream().filter(r -> r.getType().equals(ResourceType.FOR_BUILDING)).findFirst().orElseThrow().getAmount();

        if (resourcesPresent < resourcesNeeded) {
            throw new NotEnoughResourcesException();
        }

        Building buildingToUpgrade = this.buildings.stream().filter(b -> b.getType().equals(buildingType)).findFirst().orElseThrow();
        buildingToUpgrade.setLevel(buildingToUpgrade.getLevel() + 1);
        Resource resource = this.resources.stream().filter(r -> r.getType().equals(ResourceType.FOR_BUILDING)).findFirst().orElseThrow();
        resource.setAmount(resource.getAmount() - resourcesNeeded);
    }

    public Map<TroopType, Integer> getTroopCounts() {
        return this.troops.stream().collect(Collectors.toMap(Troop::getType, Troop::getSize));
    }

    public void trainTroops(TroopType type, Integer amount) throws MaximumNumberOfTroopsReached, NotEnoughResourcesException, BarracksNotBuiltException {

        int barracksLevel = this.buildings.stream().filter(b -> b.getType().equals(BuildingType.BARRACKS)).findFirst().orElseThrow().getLevel();
        if (barracksLevel == 0) {
            throw new BarracksNotBuiltException();
        }

        int currentNumberOfTroops = this.troops.stream().map(Troop::getSize).reduce(Integer::sum).orElseThrow();
        int supplyCenterLevel = this.buildings.stream().filter(b -> b.getType().equals(BuildingType.SUPPLY_CENTER)).findFirst().orElseThrow().getLevel();
        int maxAllowedTroops = BuildingInfo.getTroopsLimit(supplyCenterLevel);

        if (currentNumberOfTroops + amount > maxAllowedTroops) {
            throw new MaximumNumberOfTroopsReached();
        }

        int resourcesPresent = this.resources.stream().filter(r -> r.getType().equals(ResourceType.FOR_TRAINING)).findFirst().orElseThrow().getAmount();
        int resourcesNeeded = amount * TroopInfo.getTroopCost(type);

        if (resourcesPresent < resourcesNeeded) {
            throw new NotEnoughResourcesException();
        }

        Troop troopsToAdd = this.troops.stream().filter(t -> t.getType().equals(type)).findFirst().orElseThrow();
        troopsToAdd.setSize(troopsToAdd.getSize() + amount);
        Resource resource = this.resources.stream().filter(r -> r.getType().equals(ResourceType.FOR_TRAINING)).findFirst().orElseThrow();
        resource.setAmount(resource.getAmount() - resourcesNeeded);
    }
}
