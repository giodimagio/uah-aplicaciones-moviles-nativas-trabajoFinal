package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uah.trabajofinal.R;
import com.uah.trabajofinal.ui.adapter.PeliculaCardListAdapter;
import com.uah.trabajofinal.ui.viewmodel.PeliculaViewModel;


public class PeliculaCardListFragment extends Fragment {

    private PeliculaCardListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pelicula_card_list, container, false);

        // Montamos el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.peliculaCardListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new PeliculaCardListAdapter();
        recyclerView.setAdapter(adapter);

        // Creamos una instancia de PeliculaViewModel y observamos los cambios en la lista
        PeliculaViewModel peliculaViewModelInstance = new ViewModelProvider(this).get(PeliculaViewModel.class);
        peliculaViewModelInstance.obtenerTodasLasPeliculas().observe(getViewLifecycleOwner(),
                peliculas -> adapter.setPeliculas(peliculas));

        return view;
    }
}
