package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uah.trabajofinal.R;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaCardFragment
 * @descripcion Fragmento que muestra la información de una película
 * @see Fragment
 */
public class PeliculaCardFragment extends Fragment {

    /**
     * Atributo privado
     */
    private TextView peliculaCardTitleText;

    /**
     * @descripcion Método que se ejecuta cuando se crea la vista del fragmento
     * @param inflater El LayoutInflater que se usa para inflar la vista
     * @param container El ViewGroup al que se adjuntará la vista
     * @param savedInstanceState Bundle que contiene el estado previamente guardado de este fragmento
     * @return view La vista que se infla
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pelicula_card, container, false);

        peliculaCardTitleText = view.findViewById(R.id.peliculaCardTitleText);

        return view;
    }

    /*public void mostrarPeliculaEncontrada(Pelicula pelicula) {
        peliculaCardTitleText.setText(pelicula.getTitulo());
    }*/

    /**
     * @descripcion Método que muestra el título de la película encontrada
     * @param titulo El título de la película encontrada
     */
    public void mostrarPeliculaEncontrada(String titulo) {
        //peliculaCardTitleText.setText(titulo);
    }

}
