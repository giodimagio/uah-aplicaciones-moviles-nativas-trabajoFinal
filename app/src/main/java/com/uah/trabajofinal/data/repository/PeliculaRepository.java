package com.uah.trabajofinal.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.uah.trabajofinal.data.local.dao.IPeliculaDao;
import com.uah.trabajofinal.data.local.db.PeliculaDatabase;
import com.uah.trabajofinal.domain.model.Pelicula;
import com.uah.trabajofinal.utils.logger.Logger;

import java.util.List;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaRepository
 * @descripcion Patrón repositorio para la clase Pelicula
 */
public class PeliculaRepository {

    /**
     * @descripcion Atributos, constantes y constructor de la clase
     */
    private final LiveData<List<Pelicula>> listaPeliculas;
    private final IPeliculaDao peliculaDao;

    private static final Logger logger = new Logger(PeliculaRepository.class);

    public PeliculaRepository(Context context) {
        PeliculaDatabase peliculaDatabaseInstance = PeliculaDatabase.obtenerInstancia(context);
        peliculaDao = peliculaDatabaseInstance.peliculaDao();
        listaPeliculas = peliculaDao.obtenerListaDePeliculasEnDatabase();
    }

    /**
     * @descripcion Métodos de la clase
     * @return listaPeliculas Objeto observable que contiene la lista de películas
     */
    public LiveData<List<Pelicula>> obtenerListaDePeliculas() {
        logger.i("Obtenida lista de películas");
        return listaPeliculas;
    }

    /**
     * @descripcion Inserta una película en la base de datos local o actualiza una existente.
     * @param pelicula El objeto película a insertar/actualizar.
     */
    public void guardarPelicula(Pelicula pelicula) {
        PeliculaDatabase.obtenerEjecutorDeEscrituraEnDatabase().execute(
                () -> {
                    peliculaDao.insertarPeliculaEnDatabase(pelicula);
                    logger.i("Película " + pelicula.getTitulo() + " guardada en BBDD");
                }
        );
    }

    /**
     * @descripcion Borra una película de la base de datos local.
     * @param pelicula El objeto película a borrar.
     */
    public void borrarPelicula(Pelicula pelicula) {
        PeliculaDatabase.obtenerEjecutorDeEscrituraEnDatabase().execute(
                () -> {
                    peliculaDao.borrarPeliculaDeDatabase(pelicula);
                    logger.i("Película '" + pelicula.getTitulo() + "' borrada de la BBDD");
                }
        );
    }
}
