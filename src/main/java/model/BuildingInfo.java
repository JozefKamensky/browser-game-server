package model;

import java.util.HashMap;
import java.util.Map;

public class BuildingInfo {

    private static Map<BuildingType, Integer> maxLevels;
    private static Map<BuildingType, Map<Integer, Integer>> resourcesNeeded;

    static {
        maxLevels = new HashMap<>();
        maxLevels.put(BuildingType.MAIN_BUILDING, 3);
        maxLevels.put(BuildingType.CONSTRUCTION_RESOURCE_PROD, 10);
        maxLevels.put(BuildingType.TRAINING_RESOURCE_PROD, 10);
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
        resourcesNeeded.put(BuildingType.BARRACKS, barracksResourcesNeeded);
        resourcesNeeded.put(BuildingType.WALLS, wallsResourcesNeeded);

    }

    public static Integer getMaxLevel(BuildingType buildingType) {
        return maxLevels.get(buildingType);
    }

    public static Integer getResourcesNeeded(BuildingType buildingType, Integer level) {
        return resourcesNeeded.get(buildingType).get(level);
    }

}
