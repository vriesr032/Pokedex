package com.example.pokdex.Model;

public class Type {
    private int slot;
    private Species type;

    /**public Type(int slot, Species type){
        this.slot = slot;
        this.type = type;
    }**/

    public int getSlot() { return slot; }
    public void setSlot(int value) { this.slot = value; }

    public Species getType() { return type; }
    public void setType(Species value) { this.type = value; }
}
