package model;

import java.util.HashMap;
import java.util.Map;

public class TroopInfo {
    private static Map<TroopType, Integer> troopCosts;

    static {
        troopCosts = new HashMap<>();
        troopCosts.put(TroopType.OFFENSIVE, 20);
        troopCosts.put(TroopType.DEFENSIVE, 15);
    }

    public static Integer getTroopCost(TroopType type) {
        return troopCosts.get(type);
    }
}
