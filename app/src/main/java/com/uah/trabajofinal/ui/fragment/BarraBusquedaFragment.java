package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.search.SearchView;
import com.uah.trabajofinal.R;
import com.uah.trabajofinal.data.remote.api.RetrofitController;

/**
 * @author Jorge Romero
 *
 * @clase BarraBusquedaFragment
 * @descripcion Fragmento que contiene la barra de búsqueda de películas
 * @see Fragment
 */
public class BarraBusquedaFragment extends Fragment {

    /**
     * Atributos privados de la clase
     */
    private SearchView barraBusquedaView;
    private RetrofitController controller;
    private PeliculaCardFragment peliculaCardFragment;

    /**
     * @descripcion Método que se ejecuta al crear la vista del fragmento
     * @param inflater El LayoutInflater que se usa para inflar la vista
     * @param container El ViewGroup al que se adjuntará la vista
     * @param savedInstanceState Bundle que contiene el estado previamente guardado de la actividad
     * @return view La vista que se ha creado
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barra_busqueda, container, false);

        barraBusquedaView = view.findViewById(R.id.barraBusquedaSearchView);
        peliculaCardFragment = new PeliculaCardFragment();

        buscarPeliculaDesdeBarraDeBusqueda();

        return view;
    }

    /**
     * @descripcion Método para la búsqueda de películas con Retrofit desde la barra de búsqueda
     */
    private void buscarPeliculaDesdeBarraDeBusqueda() {
        barraBusquedaView.getEditText().setOnEditorActionListener(
                (view, actionId, event) -> {
                    barraBusquedaView.setText(barraBusquedaView.getText());
                    barraBusquedaView.hide();
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        controller = new RetrofitController();
                        controller.busquedaPorTitulo(String.valueOf(barraBusquedaView.getText()));
                        peliculaCardFragment.mostrarPeliculaEncontrada("Gladiator");
                    }
                    return false;
                });
    }
}
