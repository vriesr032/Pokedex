package com.example.pokdex.Model;

public class Species {
    private String name;
    private String url;

    /**public Species(String name, String url){
        this.name = name;
        this.url = url;
    }**/

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}
