package com.example.pokdex.Model;

public class Stat {
    private int base_stat;
    private int effort;
    private Species stat;

    /**public Stat(int baseStat, int effort, Species stat){
     this.baseStat = baseStat;
     this.effort = effort;
     this.stat = stat;
     }**/

    public int getBaseStat() { return base_stat; }
    public void setBaseStat(int value) { this.base_stat = value; }

    public int getEffort() { return effort; }
    public void setEffort(int value) { this.effort = value; }

    public Species getStat() { return stat; }
    public void setStat(Species value) { this.stat = value; }
}
