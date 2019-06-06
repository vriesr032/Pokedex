package com.example.pokdex.UI;

import android.app.Service;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
import com.example.pokdex.Model.MyPokemon;
import com.example.pokdex.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyDetailActivity extends AppCompatActivity implements SensorEventListener {

    final String ID = "#ID ";
    private Executor executor = Executors.newSingleThreadExecutor();
    private MyPokemonViewModel myPokemonViewModel;
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyPokemon pokemon;
    private ImageView pokeFrontImage;
    private ImageView pokeBackImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my_detail);
            Toolbar toolbar = findViewById(R.id.toolbarMyDetail);
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
            initViews();
    }

    private void initViews() {
        myPokemonViewModel = ViewModelProviders.of(this).get(MyPokemonViewModel.class);
        pokemon = (MyPokemon) getIntent().getSerializableExtra("pokemon");
        TextView name = findViewById(R.id.myPokeName);
        TextView id = findViewById(R.id.myId);
        TextView weight = findViewById(R.id.myWeight);
        TextView height = findViewById(R.id.myHeight);
        TextView hp = findViewById(R.id.myHp);
        TextView attack = findViewById(R.id.myAttack);
        TextView defence = findViewById(R.id.myDefence);
        TextView speed = findViewById(R.id.mySpeed);
        TextView specialAttack = findViewById(R.id.mySpecialAttack);
        TextView specialDefence = findViewById(R.id.mySpecialDefence);
        pokeFrontImage = findViewById(R.id.myPokeFrontImage);
        pokeBackImage = findViewById(R.id.myPokeBackImage);
        TextView type = findViewById(R.id.myTypeTv);
        TextView type1 = findViewById(R.id.myType1);
        TextView type2 = findViewById(R.id.myType2);
        TextView description = findViewById(R.id.myDescription);
        TextView color = findViewById(R.id.myColor);
        FloatingActionButton addPokemon = findViewById(R.id.deletePokemon);
        sensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        name.setText(pokemon.getName());
        id.setText(ID + String.valueOf(pokemon.getId()));
        weight.setText(String.valueOf(pokemon.getWeight()));
        height.setText(String.valueOf(pokemon.getHeight()));
        hp.setText(String.valueOf(pokemon.getHp()));
        attack.setText(String.valueOf(pokemon.getAttack()));
        defence.setText(String.valueOf(pokemon.getDefence()));
        speed.setText(String.valueOf(pokemon.getSpeed()));
        specialAttack.setText(String.valueOf(pokemon.getSpecialAttack()));
        specialDefence.setText(String.valueOf(pokemon.getSpecialDefence()));
        type1.setText(pokemon.getType());
        type2.setText(pokemon.getType2());
        color.setText(pokemon.getColor());
        description.setText(pokemon.getDescription());
        if (type2 == null){
            type.setText(R.string.type);
            type2.setVisibility(View.INVISIBLE);
        } else if (type != null){
            type.setText(R.string.types);
        }
        Glide.with(getApplicationContext())
                .load(pokemon.getFrontImage())
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokeFrontImage);
        Glide.with(getApplicationContext())
                .load(pokemon.getBackImage())
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokeBackImage);
        addPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MyDetailActivity.this, R.style.MyDialogTheme);
                alert.setTitle(R.string.myPokemon)
                        .setMessage("Are you sure you want to delete " + pokemon.getName().toUpperCase() + " from your Pokédex?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deletePokemon(pokemon);
                                finish();
                                showToast(pokemon.getName().toUpperCase() + " is deleted from your Pokédex.");
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();
            }
        });

    }

    private void deletePokemon(final MyPokemon pokemon){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                myPokemonViewModel.delete(pokemon);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] > 20000){
            Glide.with(getApplicationContext())
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/" + pokemon.getId() + ".png")
                    .centerCrop()
                    .transition(new DrawableTransitionOptions().crossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(pokeFrontImage);
            Glide.with(getApplicationContext())
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/" + pokemon.getId() + ".png")
                    .centerCrop()
                    .transition(new DrawableTransitionOptions().crossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(pokeBackImage);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
