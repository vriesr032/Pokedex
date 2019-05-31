package com.example.pokdex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlavorTextEntry {

    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("language")
    @Expose
    private Language language;
    @SerializedName("version")
    @Expose
    private Version version;

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}
