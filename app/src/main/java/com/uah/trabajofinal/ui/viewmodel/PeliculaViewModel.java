package com.uah.trabajofinal.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.uah.trabajofinal.data.repository.PeliculaRepository;
import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.List;

public class PeliculaViewModel extends AndroidViewModel {

    private final LiveData<List<Pelicula>> listaPeliculasLiveData;
    private final PeliculaRepository peliculaRepository;

    public PeliculaViewModel(@NonNull Application application) {
        super(application);
        peliculaRepository = new PeliculaRepository(application);
        listaPeliculasLiveData = peliculaRepository.obtenerListaDePeliculas();
    }

    public LiveData<List<Pelicula>> obtenerTodasLasPeliculas() {
        return listaPeliculasLiveData;
    }

    public void guardarPelicula(Pelicula pelicula) {
        peliculaRepository.guardarPelicula(pelicula);
    }

    public void borrarPelicula(Pelicula pelicula) {
        peliculaRepository.borrarPelicula(pelicula);
    }
}
