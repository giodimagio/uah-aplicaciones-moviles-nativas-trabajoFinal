package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uah.trabajofinal.R;
import com.uah.trabajofinal.domain.model.Pelicula;
import com.uah.trabajofinal.ui.adapter.PeliculaCardListAdapter;
import com.uah.trabajofinal.ui.viewmodel.PeliculaViewModel;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaCardListFragment
 * @descripcion Fragmento que muestra una lista de películas de tipo card
 * @see Fragment
 * @see PeliculaCardListAdapter
 * @see com.uah.trabajofinal.ui.adapter.PeliculaCardListAdapter.OnMaterialButtonClickListener
 */
public class PeliculaCardListFragment extends Fragment implements PeliculaCardListAdapter.OnMaterialButtonClickListener {

    /**
     * Atributos privados
     */
    private PeliculaCardListAdapter adapter;
    private PeliculaViewModel peliculaViewModel;

    /**
     * @descripcion Método que se ejecuta cuando se crea la vista del fragmento
     * @param inflater El LayoutInflater que se usa para inflar la vista
     * @param container El ViewGroup al que se adjuntará la vista una vez inflada
     * @param savedInstanceState Bundle que contiene el estado previamente guardado de este fragmento
     * @return view La vista que se infla
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pelicula_card_list, container, false);

        instanciarViewModel();
        configurarRecyclerView(view);
        observarPeliculas();

        return view;
    }

    /**
     * @descripcion Método que instancia el ViewModel
     */
    private void instanciarViewModel() {
        peliculaViewModel = new ViewModelProvider(this).get(PeliculaViewModel.class);
    }

    /**
     * @descripcion Método que configura el RecyclerView
     * @param view La vista que se infla
     */
    private void configurarRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.peliculaCardListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PeliculaCardListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * @descripcion Método para observar las películas
     */
    private void observarPeliculas() {
        peliculaViewModel.obtenerTodasLasPeliculas().observe(getViewLifecycleOwner(), peliculas -> {
            if (peliculas != null) {
                adapter.setPeliculas(peliculas);
            }
        });
    }

    /**
     * @descripcion Método que se ejecuta cuando se hace click sobre un botón de tipo MaterialButton
     * @param position La posición de la película en la lista
     * @param actionType El tipo de acción que se realiza sobre la película
     */
    @Override
    public void onMaterialButtonClick(int position, int actionType) {
        Pelicula pelicula = adapter.getPeliculaEnPosicionActual(position);
        if (pelicula != null && actionType == 1) {
            peliculaViewModel.guardarPelicula(pelicula);
            Toast.makeText(requireContext(), "Película guardada correctamente", Toast.LENGTH_SHORT).show();
        } else if (pelicula != null && actionType == 2) {
            peliculaViewModel.borrarPelicula(pelicula);
            Toast.makeText(requireContext(), "Película borrada correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}
