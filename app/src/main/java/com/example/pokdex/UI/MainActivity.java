package com.example.pokdex.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pokdex.Model.Pokemon;
import com.example.pokdex.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private List<Pokemon> sortedList = new ArrayList<>();
    private List<Pokemon> filteredList = new ArrayList<>();
    private PokedexAdapter pokedexAdapter;
    private MainActivityViewModel viewModel;
    private int limit;
    public boolean isLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.pokedexNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_MyPokemon){
                        Intent intent = new Intent(MainActivity.this, MyPokemon.class);
                        startActivity(intent);
                }
                return false;
            }
        });

        initObservers();
        initRecyclerView();
        sort();
    }

    private void initRecyclerView() {
        pokedexAdapter = new PokedexAdapter(this, pokemonList);
        recyclerView = findViewById(R.id.pokeList);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pokedexAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (isLimit){
                        if (visibleItemCount + pastVisibleItems >= totalItemCount){
                            isLimit = false;
                            limit = viewModel.count;
                            viewModel.getPokemons(limit);
                        }
                    }
                }
            }
        });

        isLimit = true;
        limit = 20;
        viewModel.getPokemons(limit);
    }

    private void initObservers() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showToast(s);
            }
        });
        viewModel.getPokemon().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(@Nullable List<Pokemon> pokemons) {
                pokemonList = pokemons;
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (pokedexAdapter == null) {
            pokedexAdapter = new PokedexAdapter(this, pokemonList);
            recyclerView.setAdapter(pokedexAdapter);
        } else {
            pokedexAdapter.swapList(pokemonList);
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG)
                .show();
    }

    private void filter(String query) {
        List<Pokemon> filteredPokemon = new ArrayList<>();

        if (pokemonList.size() < 150){
            filteredList = pokemonList;
        } else {
            filteredList = sortedList;
        }

        for (Pokemon pokemon : filteredList){
            if (pokemon.getName().toLowerCase().contains(query.toLowerCase())){
                filteredPokemon.add(pokemon);
            }
        }

        pokedexAdapter.filteredPokemon(filteredPokemon);
    }

    private void sort(){
        Spinner spinner = (Spinner) findViewById(R.id.typeFilter);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.sort_types, R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (pokemonList.size() < 150){
                    viewModel.getPokemons(viewModel.count);
                } else{
                    switch (position) {
                        default: case 0: sortedList = pokemonList;
                            pokedexAdapter.filteredPokemon(pokemonList);
                            break;
                        case 1: sortedList = pokemonList.subList(0, 151);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 2: sortedList = pokemonList.subList(151, 251);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 3: sortedList = pokemonList.subList(251, 386);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 4: sortedList = pokemonList.subList(386, 493);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 5: sortedList = pokemonList.subList(493, 649);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 6: sortedList = pokemonList.subList(649, 721);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 7: sortedList = pokemonList.subList(721, 807);
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                        case 8: sortedList = pokemonList.subList(807, pokemonList.size());
                            pokedexAdapter.filteredPokemon(sortedList);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pokedexAdapter.filteredPokemon(pokemonList);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem menuSearch = menu.findItem(R.id.action_search);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) menuSearch.getActionView();

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
