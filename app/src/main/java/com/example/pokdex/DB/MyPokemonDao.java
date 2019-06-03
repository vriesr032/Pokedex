package com.example.pokdex.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pokdex.Model.MyPokemon;

import java.util.List;

@Dao
public interface MyPokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyPokemon pokemon);

    @Delete
    void delete(MyPokemon pokemon);

    @Delete
    void delete(List<MyPokemon> pokemonList);

    @Update
    void update(MyPokemon pokemon);

    @Query("SELECT * FROM my_pokemons")
        //List<Game> getAllGames();
    LiveData<List<MyPokemon>> getAllPokemons();
}
