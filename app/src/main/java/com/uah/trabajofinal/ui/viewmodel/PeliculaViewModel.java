package com.uah.trabajofinal.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.uah.trabajofinal.domain.model.Pelicula;
import com.uah.trabajofinal.data.repository.PeliculaRepository;

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
