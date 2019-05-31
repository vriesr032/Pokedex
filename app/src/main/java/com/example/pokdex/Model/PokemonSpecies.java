package com.example.pokdex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonSpecies {

    @SerializedName("base_happiness")
    @Expose
    private Integer baseHappiness;
    @SerializedName("capture_rate")
    @Expose
    private Integer captureRate;
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("egg_groups")
    @Expose
    private List<EggGroup> eggGroups = null;
    @SerializedName("evolution_chain")
    @Expose
    private EvolutionChain evolutionChain;
    @SerializedName("evolves_from_species")
    @Expose
    private EvolvesFromSpecies evolvesFromSpecies;
    @SerializedName("flavor_text_entries")
    @Expose
    private List<FlavorTextEntry> flavorTextEntries = null;
    @SerializedName("form_descriptions")
    @Expose
    private List<Object> formDescriptions = null;
    @SerializedName("forms_switchable")
    @Expose
    private Boolean formsSwitchable;
    @SerializedName("gender_rate")
    @Expose
    private Integer genderRate;
    @SerializedName("genera")
    @Expose
    private List<Genera> genera = null;
    @SerializedName("generation")
    @Expose
    private Generation generation;
    @SerializedName("growth_rate")
    @Expose
    private GrowthRate growthRate;
    @SerializedName("habitat")
    @Expose
    private Habitat habitat;
    @SerializedName("has_gender_differences")
    @Expose
    private Boolean hasGenderDifferences;
    @SerializedName("hatch_counter")
    @Expose
    private Integer hatchCounter;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("pal_park_encounters")
    @Expose
    private List<PalParkEncounter> palParkEncounters = null;
    @SerializedName("pokedex_numbers")
    @Expose
    private List<PokedexNumber> pokedexNumbers = null;
    @SerializedName("shape")
    @Expose
    private Shape shape;
    @SerializedName("varieties")
    @Expose
    private List<Variety> varieties = null;

    public Integer getBaseHappiness() {
        return baseHappiness;
    }

    public void setBaseHappiness(Integer baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    public Integer getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(Integer captureRate) {
        this.captureRate = captureRate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<EggGroup> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(List<EggGroup> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public EvolutionChain getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(EvolutionChain evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    public EvolvesFromSpecies getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }

    public void setEvolvesFromSpecies(EvolvesFromSpecies evolvesFromSpecies) {
        this.evolvesFromSpecies = evolvesFromSpecies;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<Object> getFormDescriptions() {
        return formDescriptions;
    }

    public void setFormDescriptions(List<Object> formDescriptions) {
        this.formDescriptions = formDescriptions;
    }

    public Boolean getFormsSwitchable() {
        return formsSwitchable;
    }

    public void setFormsSwitchable(Boolean formsSwitchable) {
        this.formsSwitchable = formsSwitchable;
    }

    public Integer getGenderRate() {
        return genderRate;
    }

    public void setGenderRate(Integer genderRate) {
        this.genderRate = genderRate;
    }

    public List<Genera> getGenera() {
        return genera;
    }

    public void setGenera(List<Genera> genera) {
        this.genera = genera;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public GrowthRate getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(GrowthRate growthRate) {
        this.growthRate = growthRate;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Boolean getHasGenderDifferences() {
        return hasGenderDifferences;
    }

    public void setHasGenderDifferences(Boolean hasGenderDifferences) {
        this.hasGenderDifferences = hasGenderDifferences;
    }

    public Integer getHatchCounter() {
        return hatchCounter;
    }

    public void setHatchCounter(Integer hatchCounter) {
        this.hatchCounter = hatchCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsBaby() {
        return isBaby;
    }

    public void setIsBaby(Boolean isBaby) {
        this.isBaby = isBaby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<PalParkEncounter> getPalParkEncounters() {
        return palParkEncounters;
    }

    public void setPalParkEncounters(List<PalParkEncounter> palParkEncounters) {
        this.palParkEncounters = palParkEncounters;
    }

    public List<PokedexNumber> getPokedexNumbers() {
        return pokedexNumbers;
    }

    public void setPokedexNumbers(List<PokedexNumber> pokedexNumbers) {
        this.pokedexNumbers = pokedexNumbers;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public List<Variety> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<Variety> varieties) {
        this.varieties = varieties;
    }

}

class Area {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

class EggGroup {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class EvolutionChain {

        @SerializedName("url")
        @Expose
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class EvolvesFromSpecies {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

class Genera {

        @SerializedName("genus")
        @Expose
        private String genus;
        @SerializedName("language")
        @Expose
        private Language_ language;

        public String getGenus() {
            return genus;
        }

        public void setGenus(String genus) {
            this.genus = genus;
        }

        public Language_ getLanguage() {
            return language;
        }

        public void setLanguage(Language_ language) {
            this.language = language;
        }

    }

    class Generation {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class GrowthRate {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Habitat {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Language {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Language_ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Language__ {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Name {

        @SerializedName("language")
        @Expose
        private Language__ language;
        @SerializedName("name")
        @Expose
        private String name;

        public Language__ getLanguage() {
            return language;
        }

        public void setLanguage(Language__ language) {
            this.language = language;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    class PalParkEncounter {

        @SerializedName("area")
        @Expose
        private Area area;
        @SerializedName("base_score")
        @Expose
        private Integer baseScore;
        @SerializedName("rate")
        @Expose
        private Integer rate;

        public Area getArea() {
            return area;
        }

        public void setArea(Area area) {
            this.area = area;
        }

        public Integer getBaseScore() {
            return baseScore;
        }

        public void setBaseScore(Integer baseScore) {
            this.baseScore = baseScore;
        }

        public Integer getRate() {
            return rate;
        }

        public void setRate(Integer rate) {
            this.rate = rate;
        }

    }

    class Pokedex {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class PokedexNumber {

        @SerializedName("entry_number")
        @Expose
        private Integer entryNumber;
        @SerializedName("pokedex")
        @Expose
        private Pokedex pokedex;

        public Integer getEntryNumber() {
            return entryNumber;
        }

        public void setEntryNumber(Integer entryNumber) {
            this.entryNumber = entryNumber;
        }

        public Pokedex getPokedex() {
            return pokedex;
        }

        public void setPokedex(Pokedex pokedex) {
            this.pokedex = pokedex;
        }

    }

    class Shape {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    class Variety {

        @SerializedName("is_default")
        @Expose
        private Boolean isDefault;
        @SerializedName("pokemon")
        @Expose
        private Pokemon pokemon;

        public Boolean getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Boolean isDefault) {
            this.isDefault = isDefault;
        }

        public Pokemon getPokemon() {
            return pokemon;
        }

        public void setPokemon(Pokemon pokemon) {
            this.pokemon = pokemon;
        }

    }

    class Version {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }
