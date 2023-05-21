package com.uah.trabajofinal.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.uah.trabajofinal.data.local.dao.IPeliculaDao;
import com.uah.trabajofinal.data.local.db.PeliculaDatabase;
import com.uah.trabajofinal.domain.model.Pelicula;
import com.uah.trabajofinal.utils.logger.Logger;

import java.util.List;

public class PeliculaRepository {
    private final LiveData<List<Pelicula>> listaPeliculas;
    private final IPeliculaDao peliculaDao;

    private static final Logger logger = new Logger(PeliculaRepository.class);

    public PeliculaRepository(Context context) {
        PeliculaDatabase peliculaDatabaseInstance = PeliculaDatabase.obtenerInstancia(context);
        peliculaDao = peliculaDatabaseInstance.peliculaDao();
        listaPeliculas = peliculaDao.obtenerListaDePeliculasEnDatabase();
    }

    public LiveData<List<Pelicula>> obtenerListaDePeliculas() {
        logger.i("Obtenida lista de películas");
        return listaPeliculas;
    }

    public void guardarPelicula(Pelicula pelicula) {
        PeliculaDatabase.obtenerEjecutorDeEscrituraEnDatabase().execute(
                () -> {
                    peliculaDao.insertarPeliculaEnDatabase(pelicula);
                    logger.i("Película " + pelicula.getTitulo() + " guardada en BBDD");
                }
        );
    }

    public void borrarPelicula(Pelicula pelicula) {
        PeliculaDatabase.obtenerEjecutorDeEscrituraEnDatabase().execute(
                () -> {
                    peliculaDao.borrarPeliculaDeDatabase(pelicula);
                    logger.i("Película '" + pelicula.getTitulo() + "' borrada de la BBDD");
                }
        );
    }
}
