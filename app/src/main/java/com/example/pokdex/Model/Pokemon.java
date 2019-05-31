package com.example.pokdex.Model;

public class Pokemon {

    private int id;
    private String name;
    private String url;

    public Pokemon(int id, String name, String url){
        this.setId(id);
        this.setName(name);
        this.setUrl(url);
    }

    public int getId() {
        String[] splitUrl = url.split("/");
        return Integer.parseInt(splitUrl[splitUrl.length - 1]);
    }

    public void setId(int id) {
        this.id = id;
    }

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
