// Welcome.java

package com.example.pokdex.Model;

import java.util.*;

public class PokemonDetail {

    private List<Ability> abilities;
    private int baseExperience;
    private List<Species> forms;
    private List<GameIndex> gameIndices;
    private double height;
    private List<HeldItem> heldItems;
    private int id;
    private boolean isDefault;
    private String locationAreaEncounters;
    private List<Move> moves;
    private String name;
    private int order;
    private Species species;
    private Sprites sprites;
    private List<Stat> stats;
    private List<Type> types;
    private double weight;

    /**public PokemonDetail(List<Ability> abilities, int baseExperience, List<Species> forms, List<GameIndex> gameIndices, int height, List<HeldItem> heldItems, int id, boolean isDefault, String locationAreaEncounters, List<Move> moves, String name, int order, Species species, Sprites sprites, List<Stat> stats, List<Type> types, int weight){
        this.abilities = abilities;
        this.baseExperience = baseExperience;
        this.forms = forms;
        this.gameIndices = gameIndices;
        this.height = height;
        this.heldItems = heldItems;
        this.id = id;
        this.isDefault = isDefault;
        this.locationAreaEncounters = locationAreaEncounters;
        this.moves = moves;
        this.name = name;
        this.order = order;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
        this.weight = weight;
    }**/

    public List<Ability> getAbilities() { return abilities; }
    public void setAbilities(List<Ability> value) { this.abilities = value; }

    public int getBaseExperience() { return baseExperience; }
    public void setBaseExperience(int value) { this.baseExperience = value; }

    public List<Species> getForms() { return forms; }
    public void setForms(List<Species> value) { this.forms = value; }

    public List<GameIndex> getGameIndices() { return gameIndices; }
    public void setGameIndices(List<GameIndex> value) { this.gameIndices = value; }

    public double getHeight() { return (height / 10); }
    public void setHeight(double value) { this.height = value; }

    public List<HeldItem> getHeldItems() { return heldItems; }
    public void setHeldItems(List<HeldItem> value) { this.heldItems = value; }

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public boolean getIsDefault() { return isDefault; }
    public void setIsDefault(boolean value) { this.isDefault = value; }

    public String getLocationAreaEncounters() { return locationAreaEncounters; }
    public void setLocationAreaEncounters(String value) { this.locationAreaEncounters = value; }

    public List<Move> getMoves() { return moves; }
    public void setMoves(List<Move> value) { this.moves = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public int getOrder() { return order; }
    public void setOrder(int value) { this.order = value; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species value) { this.species = value; }

    public Sprites getSprites() { return sprites; }
    public void setSprites(Sprites value) { this.sprites = value; }

    public List<Stat> getStats() { return stats; }
    public void setStats(List<Stat> value) { this.stats = value; }

    public List<Type> getTypes() { return types; }
    public void setTypes(List<Type> value) { this.types = value; }

    public double getWeight() { return (weight / 10); }
    public void setWeight(double value) { this.weight = value; }
}

// Ability.java

class Ability {
    private Species ability;
    private boolean isHidden;
    private int slot;

    /**public Ability(Species ability, boolean isHidden, int slot){
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }**/

    public Species getAbility() { return ability; }
    public void setAbility(Species value) { this.ability = value; }

    public boolean getIsHidden() { return isHidden; }
    public void setIsHidden(boolean value) { this.isHidden = value; }

    public int getSlot() { return slot; }
    public void setSlot(int value) { this.slot = value; }
}

// Species.java

// GameIndex.java

class GameIndex {
    private int gameIndex;
    private Species version;

    /**public GameIndex(int gameIndex, Species version){
        this.gameIndex = gameIndex;
        this.version = version;
    }**/

    public int getGameIndex() { return gameIndex; }
    public void setGameIndex(int value) { this.gameIndex = value; }

    public Species getVersion() { return version; }
    public void setVersion(Species value) { this.version = value; }
}

// HeldItem.java

class HeldItem {
    private Species item;
    private List<VersionDetail> versionDetails;

    /**public HeldItem(Species item, List<VersionDetail> versionDetails){
        this.item = item;
        this.versionDetails = versionDetails;
    }**/

    public Species getItem() { return item; }
    public void setItem(Species value) { this.item = value; }

    public List<VersionDetail> getVersionDetails() { return versionDetails; }
    public void setVersionDetails(List<VersionDetail> value) { this.versionDetails = value; }
}

// VersionDetail.java

class VersionDetail {
    private int rarity;
    private Species version;

    /**public VersionDetail(int rarity, Species version){
        this.rarity = rarity;
        this.version = version;
    }**/

    public int getRarity() { return rarity; }
    public void setRarity(int value) { this.rarity = value; }

    public Species getVersion() { return version; }
    public void setVersion(Species value) { this.version = value; }
}

// Move.java

class Move {
    private Species move;
    private List<VersionGroupDetail> versionGroupDetails;

    /**public Move(Species move, List<VersionGroupDetail> versionDetails){
        this.move = move;
        this.versionGroupDetails = versionDetails;
    }**/

    public Species getMove() { return move; }
    public void setMove(Species value) { this.move = value; }

    public List<VersionGroupDetail> getVersionGroupDetails() { return versionGroupDetails; }
    public void setVersionGroupDetails(List<VersionGroupDetail> value) { this.versionGroupDetails = value; }
}

// VersionGroupDetail.java

class VersionGroupDetail {
    private int levelLearnedAt;
    private Species moveLearnMethod;
    private Species versionGroup;

    /**public VersionGroupDetail(int levelLearnedAt, Species moveLearnMethod, Species versionGroup){
        this.levelLearnedAt = levelLearnedAt;
        this.moveLearnMethod = moveLearnMethod;
        this.versionGroup = versionGroup;
    }**/

    public int getLevelLearnedAt() { return levelLearnedAt; }
    public void setLevelLearnedAt(int value) { this.levelLearnedAt = value; }

    public Species getMoveLearnMethod() { return moveLearnMethod; }
    public void setMoveLearnMethod(Species value) { this.moveLearnMethod = value; }

    public Species getVersionGroup() { return versionGroup; }
    public void setVersionGroup(Species value) { this.versionGroup = value; }
}

// Sprites.java

class Sprites {
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShinyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;

    /**public Sprites(String backDefault, String backFemale, String backShiny, String backShinyFemale, String frontDefault, String frontFemale, String frontShiny, String frontShinyFemale){
        this.backDefault = backDefault;
        this.backFemale = backFemale;
        this.backShiny = backShiny;
        this.backShinyFemale = backShinyFemale;
        this.frontDefault = frontDefault;
        this.frontFemale = frontFemale;
        this.frontShiny = frontShiny;
        this.frontShinyFemale = frontShinyFemale;
    }**/

    public String getBackDefault() { return backDefault; }
    public void setBackDefault(String value) { this.backDefault = value; }

    public String getBackFemale() { return backFemale; }
    public void setBackFemale(String value) { this.backFemale = value; }

    public String getBackShiny() { return backShiny; }
    public void setBackShiny(String value) { this.backShiny = value; }

    public String getBackShinyFemale() { return backShinyFemale; }
    public void setBackShinyFemale(String value) { this.backShinyFemale = value; }

    public String getFrontDefault() { return frontDefault; }
    public void setFrontDefault(String value) { this.frontDefault = value; }

    public String getFrontFemale() { return frontFemale; }
    public void setFrontFemale(String value) { this.frontFemale = value; }

    public String getFrontShiny() { return frontShiny; }
    public void setFrontShiny(String value) { this.frontShiny = value; }

    public String getFrontShinyFemale() { return frontShinyFemale; }
    public void setFrontShinyFemale(String value) { this.frontShinyFemale = value; }
}

// Stat.java

// Type.java

