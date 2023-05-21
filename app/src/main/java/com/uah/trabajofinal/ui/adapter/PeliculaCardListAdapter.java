package com.uah.trabajofinal.ui.adapter;

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
    private final OnMaterialButtonClickListener materialButtonClickListener;

    public PeliculaCardListAdapter(OnMaterialButtonClickListener materialButtonClickListener) {
        this.listaPeliculas = new ArrayList<>();
        this.materialButtonClickListener = materialButtonClickListener;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.listaPeliculas = peliculas;
        notifyDataSetChanged();
    }

    public Pelicula getPeliculaEnPosicionActual(int posicion) {
        if (listaPeliculas != null && posicion < listaPeliculas.size()) {
            return listaPeliculas.get(posicion);
        } else {
            return null;
        }
    }

    @NonNull
    @Override
    public PeliculaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pelicula_card, parent, false);
        return new PeliculaCardViewHolder(view, materialButtonClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaCardViewHolder holder, int posicion) {
        if (listaPeliculas != null && posicion < listaPeliculas.size()) {
            Pelicula pelicula = listaPeliculas.get(posicion);
            holder.bind(pelicula);
        }
    }

    @Override
    public int getItemCount() {
        return listaPeliculas != null ? listaPeliculas.size() : 0;
    }

    public interface OnMaterialButtonClickListener {
        void onMaterialButtonClick(int posicion, int tipoAccion);
    }
}