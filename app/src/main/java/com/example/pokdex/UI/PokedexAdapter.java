package com.example.pokdex.UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokdex.Model.Pokemon;
import com.example.pokdex.R;

import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {

    private List<Pokemon> pokemonList;
    private Context context;

    public PokedexAdapter(Context context, List<Pokemon> pokemonList){
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.grid_cell, viewGroup, false);
        return new PokedexAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.pokemonName.setText(pokemonList.get(viewHolder.getAdapterPosition()).getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemonList.get(viewHolder.getAdapterPosition()).getId() + ".png")
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.pokemonImage);

        viewHolder.pokedexCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", pokemonList.get(viewHolder.getAdapterPosition()).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void swapList (List<Pokemon> newList) {
        pokemonList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public void filteredPokemon(List<Pokemon> filteredPokemon){
        pokemonList = filteredPokemon;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout pokedexCell;
        private ImageView pokemonImage;
        private TextView pokemonName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pokedexCell = itemView.findViewById(R.id.pokedexCell);
            pokemonImage = itemView.findViewById(R.id.pokemonImage);
            pokemonName = itemView.findViewById(R.id.pokemonName);
        }
    }
}
