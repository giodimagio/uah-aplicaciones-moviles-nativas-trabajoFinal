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

/**
 * @author Jorge Romero
 *
 * @clase PeliculaCardListAdapter
 * @descripcion Adaptador para el RecyclerView de la lista de peliculas
 * @see RecyclerView.Adapter
 * @see PeliculaCardViewHolder
 */
public class PeliculaCardListAdapter extends RecyclerView.Adapter<PeliculaCardViewHolder> {

    /**
     * Atributos, constantes y constructor del adaptador
     */
    private List<Pelicula> listaPeliculas;
    private final OnMaterialButtonClickListener materialButtonClickListener;

    public PeliculaCardListAdapter(OnMaterialButtonClickListener materialButtonClickListener) {
        this.listaPeliculas = new ArrayList<>();
        this.materialButtonClickListener = materialButtonClickListener;
    }

    /**
     * @descripcion Metodo para actualizar la lista de peliculas
     * @param peliculas Lista de peliculas
     */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.listaPeliculas = peliculas;
        notifyDataSetChanged();
    }

    /**
     * @descripcion Metodo para obtener una pelicula de la lista según su posición en ella
     * @param posicion Posición de la pelicula en la lista
     * @return listaPeliculas Lista de peliculas
     */
    public Pelicula getPeliculaEnPosicionActual(int posicion) {
        if (listaPeliculas != null && posicion < listaPeliculas.size()) {
            return listaPeliculas.get(posicion);
        } else {
            return null;
        }
    }

    /**
     * @descripcion ViewHolder que se encarga de inflar la vista de cada fragmento de pelicula
     * @return PeliculaCardViewHolder Vista de cada fragmento de pelicula
     */
    @NonNull
    @Override
    public PeliculaCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_pelicula_card, parent, false);
        return new PeliculaCardViewHolder(view, materialButtonClickListener);
    }

    /**
     * @descripcion Metodo para enlazar los datos de cada pelicula con su vista
     * @param holder Vista de cada fragmento de pelicula
     * @param posicion Posición de la pelicula en la lista
     */
    @Override
    public void onBindViewHolder(@NonNull PeliculaCardViewHolder holder, int posicion) {
        if (listaPeliculas != null && posicion < listaPeliculas.size()) {
            Pelicula pelicula = listaPeliculas.get(posicion);
            holder.bind(pelicula);
        }
    }

    /**
     * @descripcion Metodo para obtener el número de peliculas de la lista
     * @return itemCount Número de peliculas de la lista
     */
    @Override
    public int getItemCount() {
        return listaPeliculas != null ? listaPeliculas.size() : 0;
    }

    /**
     * @descripcion Interfaz para manejar los eventos de los botones de cada fragmento de pelicula
     */
    public interface OnMaterialButtonClickListener {
        void onMaterialButtonClick(int posicion, int tipoAccion);
    }
}