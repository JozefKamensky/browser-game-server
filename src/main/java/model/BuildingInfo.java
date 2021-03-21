package model;

import java.util.HashMap;
import java.util.Map;

public class BuildingInfo {

    private static final Map<BuildingType, Integer> maxLevels;
    private static final Map<BuildingType, Map<Integer, Integer>> resourcesNeeded;
    private static final Map<Integer, Integer> troopsLimit;

    static {
        maxLevels = new HashMap<>();
        maxLevels.put(BuildingType.MAIN_BUILDING, 3);
        maxLevels.put(BuildingType.CONSTRUCTION_RESOURCE_PROD, 10);
        maxLevels.put(BuildingType.TRAINING_RESOURCE_PROD, 10);
        maxLevels.put(BuildingType.SUPPLY_CENTER, 10);
        maxLevels.put(BuildingType.BARRACKS, 3);
        maxLevels.put(BuildingType.WALLS, 5);

        resourcesNeeded = new HashMap<>();
        Map<Integer, Integer> mainBuildingResourcesNeeded = new HashMap<>();
        mainBuildingResourcesNeeded.put(2, 100);
        mainBuildingResourcesNeeded.put(3, 300);

        Map<Integer, Integer> buildingResourcesProdResourcesNeeded = new HashMap<>();
        buildingResourcesProdResourcesNeeded.put(2,   10);
        buildingResourcesProdResourcesNeeded.put(3,   20);
        buildingResourcesProdResourcesNeeded.put(4,   30);
        buildingResourcesProdResourcesNeeded.put(5,   50);
        buildingResourcesProdResourcesNeeded.put(6,   60);
        buildingResourcesProdResourcesNeeded.put(7,   80);
        buildingResourcesProdResourcesNeeded.put(8,   90);
        buildingResourcesProdResourcesNeeded.put(9,  150);
        buildingResourcesProdResourcesNeeded.put(10, 200);

        Map<Integer, Integer> trainingResourcesProdResourcesNeeded = new HashMap<>();
        trainingResourcesProdResourcesNeeded.put(2,   10);
        trainingResourcesProdResourcesNeeded.put(3,   20);
        trainingResourcesProdResourcesNeeded.put(4,   30);
        trainingResourcesProdResourcesNeeded.put(5,   50);
        trainingResourcesProdResourcesNeeded.put(6,   60);
        trainingResourcesProdResourcesNeeded.put(7,   80);
        trainingResourcesProdResourcesNeeded.put(8,   90);
        trainingResourcesProdResourcesNeeded.put(9,  150);
        trainingResourcesProdResourcesNeeded.put(10, 200);

        Map<Integer, Integer> supplyCenterResourcesNeeded = new HashMap<>();
        supplyCenterResourcesNeeded.put(2 , 100);
        supplyCenterResourcesNeeded.put(3 , 150);
        supplyCenterResourcesNeeded.put(4 , 200);
        supplyCenterResourcesNeeded.put(5 , 250);
        supplyCenterResourcesNeeded.put(6 , 300);
        supplyCenterResourcesNeeded.put(7 , 350);
        supplyCenterResourcesNeeded.put(8 , 400);
        supplyCenterResourcesNeeded.put(9 , 450);
        supplyCenterResourcesNeeded.put(10, 500);

        Map<Integer, Integer> barracksResourcesNeeded = new HashMap<>();
        barracksResourcesNeeded.put(2, 200);
        barracksResourcesNeeded.put(3, 400);

        Map<Integer, Integer> wallsResourcesNeeded = new HashMap<>();
        wallsResourcesNeeded.put(2, 200);
        wallsResourcesNeeded.put(3, 400);
        wallsResourcesNeeded.put(4, 600);
        wallsResourcesNeeded.put(5, 800);

        resourcesNeeded.put(BuildingType.MAIN_BUILDING, mainBuildingResourcesNeeded);
        resourcesNeeded.put(BuildingType.CONSTRUCTION_RESOURCE_PROD, buildingResourcesProdResourcesNeeded);
        resourcesNeeded.put(BuildingType.TRAINING_RESOURCE_PROD, trainingResourcesProdResourcesNeeded);
        resourcesNeeded.put(BuildingType.SUPPLY_CENTER, supplyCenterResourcesNeeded);
        resourcesNeeded.put(BuildingType.BARRACKS, barracksResourcesNeeded);
        resourcesNeeded.put(BuildingType.WALLS, wallsResourcesNeeded);

        troopsLimit = new HashMap<>();
        troopsLimit.put(1 ,   100);
        troopsLimit.put(2 ,   300);
        troopsLimit.put(3 ,   500);
        troopsLimit.put(4 ,  1000);
        troopsLimit.put(5 ,  2000);
        troopsLimit.put(6 ,  4000);
        troopsLimit.put(7 ,  7500);
        troopsLimit.put(8 , 10000);
        troopsLimit.put(9 , 15000);
        troopsLimit.put(10, 20000);
    }

    public static Integer getMaxLevel(BuildingType buildingType) {
        return maxLevels.get(buildingType);
    }

    public static Integer getResourcesNeeded(BuildingType buildingType, Integer level) {
        return resourcesNeeded.get(buildingType).get(level);
    }

    public static Integer getTroopsLimit(Integer level) {
        return troopsLimit.get(level);
    }

}
