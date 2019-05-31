package com.example.pokdex.Model;

import java.util.ArrayList;

public class PokemonResponse {

    private int count;

    private String next;

    private String previous;

    private ArrayList<Pokemon> results;

    public PokemonResponse(int count, String next, String previous, ArrayList<Pokemon> results){
        this.setCount(count);
        this.setNext(next);
        this.setPrevious(previous);
        this.setResults(results);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
