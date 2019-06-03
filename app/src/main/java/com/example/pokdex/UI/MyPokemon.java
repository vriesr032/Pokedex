package com.example.pokdex.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pokdex.R;

import java.util.ArrayList;
import java.util.List;

public class MyPokemon extends AppCompatActivity implements MyPokedexAdapter.OnItemClickListner {

    private MyPokedexAdapter pokedexAdapter;
    private RecyclerView recyclerView;
    private MyPokemonViewModel viewModel;
    private List<com.example.pokdex.Model.MyPokemon> pokemonList = new ArrayList<>();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pokemon);
        Toolbar toolbar = findViewById(R.id.toolbarMyPokemon);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.myPokemonNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_Pokedex){
                    finish();
                }
                return false;
            }
        });
        initObservers();
        initRecyclerView();
    }


    private void initRecyclerView() {
        pokedexAdapter = new MyPokedexAdapter(this, pokemonList);
        pokedexAdapter.setOnItemClickListner(this);
        recyclerView = findViewById(R.id.myPokeList);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pokedexAdapter);
        viewModel.getPokemons();
    }

    private void initObservers() {
        viewModel = ViewModelProviders.of(this).get(MyPokemonViewModel.class);
        viewModel.getPokemons().observe(this, new Observer<List<com.example.pokdex.Model.MyPokemon>>() {
            @Override
            public void onChanged(@Nullable List<com.example.pokdex.Model.MyPokemon> pokemons) {
                pokemonList = pokemons;
                updateUI();
            }
        });
    }

    private void updateUI() {
        if (pokedexAdapter == null) {
            pokedexAdapter = new MyPokedexAdapter(this, pokemonList);
            recyclerView.setAdapter(pokedexAdapter);
        } else {
            pokedexAdapter.swapList(pokemonList);
        }
    }

    private void filter(String query) {
        List<com.example.pokdex.Model.MyPokemon> filteredPokemon = new ArrayList<>();

        for (com.example.pokdex.Model.MyPokemon pokemon : pokemonList){
            if (pokemon.getName().toLowerCase().contains(query.toLowerCase())){
                filteredPokemon.add(pokemon);
            }
        }

        pokedexAdapter.filteredPokemon(filteredPokemon);
    }

    private void showToast(String message) {
        Toast.makeText(MyPokemon.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_pokemon, menu);

        MenuItem menuSearch = menu.findItem(R.id.action_my_search);
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
        if (id == R.id.action_delete) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this, R.style.MyDialogTheme);
            alert.setTitle(R.string.myPokemon)
                    .setMessage("Are you sure you want to delete your Pokédex?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            viewModel.deleteAllPokemons(pokemonList);
                            showToast("Pokédex deleted.");
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(this, MyDetailActivity.class);
        com.example.pokdex.Model.MyPokemon myPokemon = pokemonList.get(position);
        intent.putExtra("pokemon", myPokemon);
        startActivity(intent);
    }
}
