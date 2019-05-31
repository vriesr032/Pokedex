package com.example.pokdex.DB;

import com.example.pokdex.Model.PokemonDetail;
import com.example.pokdex.Model.PokemonResponse;
import com.example.pokdex.Model.PokemonSpecies;

import retrofit2.Call;

public class PokedexRepository {

    private final int OFFSET = 0;
    private PokedexDataBaseApiService pokedexDataBaseApiService = PokedexDatabaseApi.create();

    public Call<PokemonResponse> getPokemons(int limit) {
        return pokedexDataBaseApiService.getPokemons(limit, OFFSET);
    }

    public Call<PokemonDetail> getPokemon(String name) {
        return pokedexDataBaseApiService.getPokemon(name);
    }

    public Call<PokemonSpecies> getPokemonSpecies(String name) {
        return pokedexDataBaseApiService.getPokemonSpecies(name);
    }
}