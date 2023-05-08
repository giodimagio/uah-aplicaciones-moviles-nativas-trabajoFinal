package com.example.trabajofinal.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trabajofinal.domain.model.Pelicula;
import com.example.trabajofinal.domain.repository.PeliculaRepository;

import java.util.List;

public class PeliculaViewModel extends AndroidViewModel {

    private final LiveData<List<Pelicula>> listaPeliculas;
    private final PeliculaRepository peliculaRepository;

    public PeliculaViewModel(@NonNull Application application) {
        super(application);
        peliculaRepository = new PeliculaRepository(application);
        listaPeliculas = peliculaRepository.obtenerListadoDePeliculas();
    }

    public LiveData<List< Pelicula>> obtenerTodasLasPeliculas() {
        return listaPeliculas;
    }

}
