package com.uah.trabajofinal.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.uah.trabajofinal.data.repository.PeliculaRepository;
import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.List;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaViewModel
 * @descripcion Clase ViewModel para la entidad Pelicula que llama al repositorio para obtener los
 * datos
 * @see AndroidViewModel
 */
public class PeliculaViewModel extends AndroidViewModel {

    /**
     * @descripcion Atributos y constructor de la clase
     */
    private final LiveData<List<Pelicula>> listaPeliculasLiveData;
    private final PeliculaRepository peliculaRepository;

    public PeliculaViewModel(@NonNull Application application) {
        super(application);
        peliculaRepository = new PeliculaRepository(application);
        listaPeliculasLiveData = peliculaRepository.obtenerListaDePeliculas();
    }

    /**
     * @descripcion Obtiene la lista observable de peliculas
     * @return listaPeliculasLiveData Lista observable de peliculas
     */
    public LiveData<List<Pelicula>> obtenerTodasLasPeliculas() {
        return listaPeliculasLiveData;
    }

    /**
     * @descripcion Guarda una pelicula en la base de datos a través del repositorio
     */
    public void guardarPelicula(Pelicula pelicula) {
        peliculaRepository.guardarPelicula(pelicula);
    }

    /**
     * @descripcion Borra una pelicula de la base de datos a través del repositorio
     */
    public void borrarPelicula(Pelicula pelicula) {
        peliculaRepository.borrarPelicula(pelicula);
    }
}
