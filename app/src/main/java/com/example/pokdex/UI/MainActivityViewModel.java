package com.example.pokdex.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.pokdex.DB.PokedexRepository;
import com.example.pokdex.Model.Pokemon;
import com.example.pokdex.Model.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private PokedexRepository pokedexRepository = new PokedexRepository();

    private MutableLiveData<List<Pokemon>> pokemon = new MutableLiveData<>();

    public int count;

    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<List<Pokemon>> getPokemon() {
        return pokemon;
    }

    public void getPokemons(final int limit) {
        pokedexRepository
                .getPokemons(limit)
                .enqueue(new Callback<PokemonResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<PokemonResponse> call, @NonNull Response<PokemonResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            pokemon.setValue(response.body().getResults());
                            count = response.body().getCount();
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<PokemonResponse> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }
}
