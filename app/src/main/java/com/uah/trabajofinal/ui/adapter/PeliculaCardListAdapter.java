package com.uah.trabajofinal.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uah.trabajofinal.R;
import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class PeliculaCardListAdapter extends RecyclerView.Adapter<PeliculaCardViewHolder> {

    private List<Pelicula> listaPeliculas;

    public PeliculaCardListAdapter() {
        this.listaPeliculas = new ArrayList<>();
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.listaPeliculas = peliculas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PeliculaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pelicula_card, parent, false);
        return new PeliculaCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaCardViewHolder holder, int position) {
        if (listaPeliculas != null && position < listaPeliculas.size()) {
            Pelicula pelicula = listaPeliculas.get(position);
            holder.bind(pelicula);
        }
    }

    @Override
    public int getItemCount() {
        return listaPeliculas != null ? listaPeliculas.size() : 0;
    }
}