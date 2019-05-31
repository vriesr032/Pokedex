package com.example.pokdex.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokdex.Model.PokemonDetail;
import com.example.pokdex.Model.PokemonSpecies;
import com.example.pokdex.R;

public class DetailActivity extends AppCompatActivity {

    private DetailActivityViewModel viewModel;
    private TextView name;
    private TextView id;
    private TextView height;
    private TextView weight;
    private TextView hp;
    private TextView attack;
    private TextView defence;
    private TextView speed;
    private TextView specialAttack;
    private TextView specialDefence;
    private TextView type;
    private TextView type1;
    private TextView type2;
    private TextView description;
    private TextView color;
    private ImageView pokeFrontImage;
    private ImageView pokeBackImage;
    private String pokemonName;
    private PokemonDetail pokemonDetail = new PokemonDetail();
    private PokemonSpecies pokemonSpecie = new PokemonSpecies();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        initViews();
        initObservers();
        viewModel.getPokemons(pokemonName);
        viewModel.getPokemonSpecies(pokemonName);
    }

    private void initViews() {
        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        hp = findViewById(R.id.hp);
        attack = findViewById(R.id.attack);
        defence = findViewById(R.id.defence);
        speed = findViewById(R.id.speed);
        specialAttack = findViewById(R.id.specialAttack);
        specialDefence = findViewById(R.id.specialDefence);
        pokeFrontImage = findViewById(R.id.pokeFrontImage);
        pokeBackImage = findViewById(R.id.pokeBackImage);
        type = findViewById(R.id.typeTv);
        type1 = findViewById(R.id.type1);
        type2 = findViewById(R.id.type2);
        description = findViewById(R.id.description);
        color = findViewById(R.id.color);
        if (getIntent().hasExtra("name")){
            pokemonName = getIntent().getStringExtra("name");
        }
    }

    private void initObservers() {
        viewModel = ViewModelProviders.of(this).get(DetailActivityViewModel.class);
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showToast(s);
            }
        });
        viewModel.getPokemon().observe(this, new Observer<PokemonDetail>() {
            @Override
            public void onChanged(@Nullable PokemonDetail pokemonDetails) {
                pokemonDetail = pokemonDetails;
                name.setText(pokemonDetail.getName());
                id.setText(String.valueOf("ID #" + pokemonDetail.getID()));
                Glide.with(getApplicationContext())
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonDetail.getID() + ".png")
                        .centerCrop()
                        .transition(new DrawableTransitionOptions().crossFade())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(pokeFrontImage);
                Glide.with(getApplicationContext())
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/" + pokemonDetail.getID() + ".png")
                        .centerCrop()
                        .transition(new DrawableTransitionOptions().crossFade())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(pokeBackImage);
                height.setText(String.valueOf(pokemonDetail.getHeight() + " DM"));
                weight.setText(String.valueOf(pokemonDetail.getWeight() + " HG"));
                hp.setText(String.valueOf(pokemonDetail.getStats().get(5).getBaseStat()));
                attack.setText(String.valueOf(pokemonDetail.getStats().get(4).getBaseStat()));
                defence.setText(String.valueOf(pokemonDetail.getStats().get(3).getBaseStat()));
                speed.setText(String.valueOf(pokemonDetail.getStats().get(0).getBaseStat()));
                specialAttack.setText(String.valueOf(pokemonDetail.getStats().get(2).getBaseStat()));
                specialDefence.setText(String.valueOf(pokemonDetail.getStats().get(1).getBaseStat()));
                if (pokemonDetail.getTypes().size() > 1) {
                    type.setText(getString(R.string.types));
                    type1.setText(pokemonDetail.getTypes().get(0).getType().getName());
                    type2.setText(pokemonDetail.getTypes().get(1).getType().getName());
                } else {
                    type.setText(getString(R.string.type));
                    type1.setText(pokemonDetail.getTypes().get(0).getType().getName());
                    type2.setVisibility(View.INVISIBLE);
                }
            }
        });
        viewModel.getPokemonSpecie().observe(this, new Observer<PokemonSpecies>() {
            @Override
            public void onChanged(@Nullable PokemonSpecies pokemonSpecies) {
                pokemonSpecie = pokemonSpecies;
                if (pokemonSpecie.getFlavorTextEntries().size() < 60){
                    description.setText(pokemonSpecie.getFlavorTextEntries().get(1).getFlavorText());
                } else if (pokemonSpecie.getFlavorTextEntries().size() > 60){
                    description.setText(pokemonSpecie.getFlavorTextEntries().get(2).getFlavorText());
                }
                color.setText(pokemonSpecie.getColor().getName());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(DetailActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
