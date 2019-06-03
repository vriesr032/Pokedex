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
import com.example.pokdex.Model.MyPokemon;
import com.example.pokdex.R;

import java.util.List;

public class MyPokedexAdapter extends RecyclerView.Adapter<MyPokedexAdapter.ViewHolder> {

    private List<MyPokemon> pokemonList;
    private Context context;
    private OnItemClickListner onItemClickListner;

    public interface OnItemClickListner{
        void OnItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner){
        this.onItemClickListner = onItemClickListner;
    }

    public MyPokedexAdapter(Context context, List<MyPokemon> pokemonList){
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.grid_cell, viewGroup, false);
        return new MyPokedexAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.name.setText(pokemonList.get(viewHolder.getAdapterPosition()).getName());

        Glide.with(context)
                .load(pokemonList.get(viewHolder.getAdapterPosition()).getFrontImage())
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.image);

        viewHolder.pokedexCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListner != null){
                    int position = viewHolder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        onItemClickListner.OnItemClick(position);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void swapList (List<MyPokemon> newList) {
        pokemonList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public void filteredPokemon(List<MyPokemon> filteredPokemon){
        pokemonList = filteredPokemon;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout pokedexCell;
        private TextView name;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokedexCell = itemView.findViewById(R.id.pokedexCell);
            name = itemView.findViewById(R.id.pokemonName);
            image = itemView.findViewById(R.id.pokemonImage);
        }
    }
}
