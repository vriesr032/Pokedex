package com.example.pokdex.DB;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.pokdex.Model.MyPokemon;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyPokemonRepository {
    private MyPokemonDatabase myPokemonDatabase;
    private MyPokemonDao myPokemonDao;
    private LiveData<List<MyPokemon>> myPokemonList;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public MyPokemonRepository(Context context) {
        myPokemonDatabase = MyPokemonDatabase.getDatabase(context);
        myPokemonDao = myPokemonDatabase.MyPokemonDao();
        myPokemonList = myPokemonDao.getAllPokemons();
    }

    public LiveData<List<MyPokemon>> getAllPokemons() {
        return myPokemonList;
    }

    public void insert(final MyPokemon pokemon) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myPokemonDao.insert(pokemon);
            }
        });
    }

    public void update(final MyPokemon pokemon) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myPokemonDao.update(pokemon);
            }
        });
    }

    public void delete(final MyPokemon pokemon) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myPokemonDao.delete(pokemon);
            }
        });
    }

    public void deleteAllPokemons(final List<MyPokemon> pokemonList) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myPokemonDao.delete(pokemonList);
            }
        });
    }
}
