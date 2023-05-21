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

public class PeliculaCardListFragment extends Fragment implements PeliculaCardListAdapter.OnMaterialButtonClickListener {

    private PeliculaCardListAdapter adapter;
    private PeliculaViewModel peliculaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pelicula_card_list, container, false);

        instanciarViewModel();
        configurarRecyclerView(view);
        observarPeliculas();

        return view;
    }

    // Instanciamos el ViewModel
    private void instanciarViewModel() {
        peliculaViewModel = new ViewModelProvider(this).get(PeliculaViewModel.class);
    }

    // Configuramos el RecyclerView
    private void configurarRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.peliculaCardListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PeliculaCardListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    // Observamos los cambios en la lista de películas
    private void observarPeliculas() {
        peliculaViewModel.obtenerTodasLasPeliculas().observe(getViewLifecycleOwner(), peliculas -> {
            if (peliculas != null) {
                adapter.setPeliculas(peliculas);
            }
        });
    }

    // Manejador de eventos de click sobre un botón de tipo MaterialButton
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
