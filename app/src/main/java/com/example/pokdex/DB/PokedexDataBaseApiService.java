package com.example.pokdex.DB;

import com.example.pokdex.Model.PokemonDetail;
import com.example.pokdex.Model.PokemonResponse;
import com.example.pokdex.Model.PokemonSpecies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokedexDataBaseApiService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemons(@Query("limit") int limit, @Query("offset") int offset);
    @GET("pokemon/{name}")
    Call<PokemonDetail> getPokemon(@Path("name") String name);
    @GET("pokemon-species/{name}")
    Call<PokemonSpecies> getPokemonSpecies(@Path("name") String name);
}