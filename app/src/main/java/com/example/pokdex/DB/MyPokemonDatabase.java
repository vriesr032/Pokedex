package com.example.pokdex.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pokdex.Model.MyPokemon;

@Database(entities = {MyPokemon.class}, version = 1, exportSchema = false)
public abstract class MyPokemonDatabase extends RoomDatabase {
    private final static String NAME_DATABASE = "my_pokemon_database";
    public abstract MyPokemonDao MyPokemonDao();


    private static volatile MyPokemonDatabase INSTANCE;

    static MyPokemonDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyPokemonDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyPokemonDatabase.class, NAME_DATABASE)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
