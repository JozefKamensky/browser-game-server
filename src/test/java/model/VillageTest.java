package model;

import exceptions.MaximumLevelOfBuildingReached;
import exceptions.MaximumNumberOfTroopsReached;
import exceptions.NotEnoughResourcesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VillageTest {

    private final int PLAYER_ID = 1;

    @Test
    void upgradeBuilding_shouldPass() {
        Village village = new Village(PLAYER_ID);
        int beforeUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
        try {
            village.upgradeBuilding(BuildingType.MAIN_BUILDING);
            int afterUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
            assertEquals(beforeUpgrade + 1, afterUpgrade);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void upgradeBuilding_shouldFail_forNotEnoughResources() {
        VillageParameters params = new VillageParameters();
        params.setResources(0, 0);
        Village village = new Village(PLAYER_ID, params);
        int beforeUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
        assertThrows(NotEnoughResourcesException.class, () ->  {
            village.upgradeBuilding(BuildingType.MAIN_BUILDING);
        });
        int afterUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
        assertEquals(beforeUpgrade, afterUpgrade);
    }

    @Test
    void upgradeBuilding_shouldFail_forMaxLevelReached() {
        VillageParameters params = new VillageParameters();
        params.setBuildingLevels(3,1,1, 1,0,0);
        Village village = new Village(PLAYER_ID, params);
        int beforeUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
        assertThrows(MaximumLevelOfBuildingReached.class, () ->  {
            village.upgradeBuilding(BuildingType.MAIN_BUILDING);
        });
        int afterUpgrade = village.getBuildingLevels().get(BuildingType.MAIN_BUILDING);
        assertEquals(beforeUpgrade, afterUpgrade);
    }

    @Test
    void trainTroops_shouldPass() {
        VillageParameters params = new VillageParameters();
        params.setTroops(0, 0);
        params.setResources(0, 100);
        Village village = new Village(PLAYER_ID, params);
        int beforeTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        try {
            village.trainTroops(TroopType.OFFENSIVE, 3);
        } catch (MaximumNumberOfTroopsReached | NotEnoughResourcesException e) {
            fail(e);
        }
        int afterTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        assertEquals(beforeTraining + 3, afterTraining);
    }

    @Test
    void trainTroops_shouldFail_forMaxLimitReached() {
        VillageParameters params = new VillageParameters();
        params.setTroops(100, 0);
        params.setBuildingLevels(0,0,0,1,0,0);
        Village village = new Village(PLAYER_ID, params);
        int beforeTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        assertThrows(MaximumNumberOfTroopsReached.class, () -> {
           village.trainTroops(TroopType.OFFENSIVE, 1);
        });
        int afterTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        assertEquals(beforeTraining, afterTraining);
    }

    @Test
    void trainTroops_shouldFail_forNotEnoughResources() {
        VillageParameters params = new VillageParameters();
        params.setTroops(10, 0);
        params.setResources(0,0);
        Village village = new Village(PLAYER_ID, params);
        int beforeTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        assertThrows(NotEnoughResourcesException.class, () -> {
            village.trainTroops(TroopType.OFFENSIVE, 1);
        });
        int afterTraining = village.getTroopCounts().get(TroopType.OFFENSIVE);
        assertEquals(beforeTraining, afterTraining);
    }
}