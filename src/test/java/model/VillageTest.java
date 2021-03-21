package model;

import exceptions.MaximumLevelOfBuildingReached;
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
}