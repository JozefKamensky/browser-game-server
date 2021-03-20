package model;

public class VillageParameters {
    private int mainBuildingLevel;
    private int constructionProdLevel;
    private int trainingProdLevel;
    private int barracksLevel;
    private int wallsLevel;

    private int constructionResources;
    private int trainingResources;

    private int offensiveTroopsCount;
    private int defensiveTroopsCount;

    public VillageParameters() {
        this.mainBuildingLevel = 1;
        this.constructionProdLevel = 1;
        this.trainingProdLevel = 1;
        this.barracksLevel = 0;
        this.wallsLevel = 0;

        this.constructionResources = 200;
        this.trainingResources = 200;

        this.offensiveTroopsCount = 0;
        this.defensiveTroopsCount = 0;
    }

    public void setBuildingLevels(int mainBuildingLevel, int constructionProdLevel, int trainingProdLevel, int barracksLevel, int wallsLevel) {
        this.mainBuildingLevel = mainBuildingLevel;
        this.constructionProdLevel = constructionProdLevel;
        this.trainingProdLevel = trainingProdLevel;
        this.barracksLevel = barracksLevel;
        this.wallsLevel = wallsLevel;
    }

    public void setResources(int constructionResources, int trainingResources) {
        this.constructionResources = constructionResources;
        this.trainingResources = trainingResources;
    }

    public void setTroops(int offensiveTroopsCount, int defensiveTroopsCount) {
        this.offensiveTroopsCount = offensiveTroopsCount;
        this.defensiveTroopsCount = defensiveTroopsCount;
    }

    public int getMainBuildingLevel() {
        return mainBuildingLevel;
    }

    public void setMainBuildingLevel(int mainBuildingLevel) {
        this.mainBuildingLevel = mainBuildingLevel;
    }

    public int getConstructionProdLevel() {
        return constructionProdLevel;
    }

    public void setConstructionProdLevel(int constructionProdLevel) {
        this.constructionProdLevel = constructionProdLevel;
    }

    public int getTrainingProdLevel() {
        return trainingProdLevel;
    }

    public void setTrainingProdLevel(int trainingProdLevel) {
        this.trainingProdLevel = trainingProdLevel;
    }

    public int getBarracksLevel() {
        return barracksLevel;
    }

    public void setBarracksLevel(int barracksLevel) {
        this.barracksLevel = barracksLevel;
    }

    public int getWallsLevel() {
        return wallsLevel;
    }

    public void setWallsLevel(int wallsLevel) {
        this.wallsLevel = wallsLevel;
    }

    public int getConstructionResources() {
        return constructionResources;
    }

    public void setConstructionResources(int constructionResources) {
        this.constructionResources = constructionResources;
    }

    public int getTrainingResources() {
        return trainingResources;
    }

    public void setTrainingResources(int trainingResources) {
        this.trainingResources = trainingResources;
    }

    public int getOffensiveTroopsCount() {
        return offensiveTroopsCount;
    }

    public void setOffensiveTroopsCount(int offensiveTroopsCount) {
        this.offensiveTroopsCount = offensiveTroopsCount;
    }

    public int getDefensiveTroopsCount() {
        return defensiveTroopsCount;
    }

    public void setDefensiveTroopsCount(int defensiveTroopsCount) {
        this.defensiveTroopsCount = defensiveTroopsCount;
    }
}
