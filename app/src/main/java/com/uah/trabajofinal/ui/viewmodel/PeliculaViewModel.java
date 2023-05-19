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

    public PeliculaViewModel(@NonNull Application application) {
        super(application);
        PeliculaRepository peliculaRepository = new PeliculaRepository(application);
        listaPeliculas = peliculaRepository.obtenerListaDePeliculas();
    }

    public LiveData<List<Pelicula>> obtenerTodasLasPeliculas() {
        return listaPeliculas;
    }

}
