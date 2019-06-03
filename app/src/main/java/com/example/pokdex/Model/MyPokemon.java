package com.example.pokdex.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity(tableName = "my_pokemons")
public class MyPokemon implements Serializable {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "frontImage")
    private String frontImage;
    @ColumnInfo(name = "backImage")
    private String backImage;
    @ColumnInfo(name = "height")
    private double height;
    @ColumnInfo(name = "weight")
    private double weight;
    @ColumnInfo(name = "hp")
    private int hp;
    @ColumnInfo(name = "attack")
    private int attack;
    @ColumnInfo(name = "defence")
    private int defence;
    @ColumnInfo(name = "speed")
    private int speed;
    @ColumnInfo(name = "specialAttack")
    private int specialAttack;
    @ColumnInfo(name = "specialDefence")
    private int specialDefence;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "type2")
    private String type2;
    @ColumnInfo(name = "color")
    private String color;
    @ColumnInfo(name = "description")
    private String description;

    public MyPokemon(int id, String name, String frontImage, @Nullable String backImage, double height, double weight, int hp, int attack, int defence, int speed, int specialAttack, int specialDefence, String type, @Nullable String type2, String color, @Nullable String description){
        this.setId(id);
        this.setName(name);
        this.setFrontImage(frontImage);
        this.setBackImage(backImage);
        this.setHeight(height);
        this.setWeight(weight);
        this.setHp(hp);
        this.setAttack(attack);
        this.setDefence(defence);
        this.setSpeed(speed);
        this.setSpecialAttack(specialAttack);
        this.setSpecialDefence(specialDefence);
        this.setType(type);
        this.setType2(type2);
        this.setColor(color);
        this.setDescription(description);
    }


    public int getId() {
        return id;
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

    public String getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(String frontImage) {
        this.frontImage = frontImage;
    }

    public String getBackImage() {
        return backImage;
    }

    public void setBackImage(String backImage) {
        this.backImage = backImage;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefence() {
        return specialDefence;
    }

    public void setSpecialDefence(int specialDefence) {
        this.specialDefence = specialDefence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
