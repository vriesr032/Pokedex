package com.example.pokdex.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.pokdex.DB.MyPokemonRepository;
import com.example.pokdex.Model.MyPokemon;

import java.util.List;

public class MyPokemonViewModel extends AndroidViewModel {

    private MyPokemonRepository myPokemonRepository;
    private LiveData<List<MyPokemon>> pokemonList;

    public MyPokemonViewModel(@NonNull Application application) {
        super(application);
        myPokemonRepository = new MyPokemonRepository(application.getApplicationContext());
        pokemonList = myPokemonRepository.getAllPokemons();
    }

    public LiveData<List<MyPokemon>> getPokemons() {
        return pokemonList;
    }

    public void insert(MyPokemon pokemon) {
        myPokemonRepository.insert(pokemon);
    }

    public void update(MyPokemon pokemon) {
        myPokemonRepository.update(pokemon);
    }

    public void delete(MyPokemon pokemon) {
        myPokemonRepository.delete(pokemon);
    }

    public void deleteAllPokemons(List<MyPokemon> pokemonList){
        myPokemonRepository.deleteAllPokemons(pokemonList);
    }
}
