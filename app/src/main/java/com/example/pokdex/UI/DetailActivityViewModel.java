package com.example.pokdex.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.pokdex.DB.PokedexRepository;
import com.example.pokdex.Model.PokemonDetail;
import com.example.pokdex.Model.PokemonSpecies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivityViewModel extends AndroidViewModel {

    private PokedexRepository pokedexRepository = new PokedexRepository();

    private MutableLiveData<PokemonDetail> pokemon = new MutableLiveData<>();

    private MutableLiveData<PokemonSpecies> pokemonSpecies = new MutableLiveData<>();

    private MutableLiveData<String> error = new MutableLiveData<>();

    public DetailActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<PokemonDetail> getPokemon() {
        return pokemon;
    }

    public MutableLiveData<PokemonSpecies> getPokemonSpecie() {
        return pokemonSpecies;
    }

    public void getPokemons(String name) {
        pokedexRepository
                .getPokemon(name)
                .enqueue(new Callback<PokemonDetail>() {
                    @Override
                    public void onResponse(@NonNull Call<PokemonDetail> call, @NonNull Response<PokemonDetail> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            pokemon.setValue(response.body());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<PokemonDetail> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }

    public void getPokemonSpecies(String name){
        pokedexRepository
                .getPokemonSpecies(name)
                .enqueue(new Callback<PokemonSpecies>() {
                    @Override
                    public void onResponse(Call<PokemonSpecies> call, Response<PokemonSpecies> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            pokemonSpecies.setValue(response.body());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<PokemonSpecies> call, Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }
}
