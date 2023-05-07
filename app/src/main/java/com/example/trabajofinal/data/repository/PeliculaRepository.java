package com.example.trabajofinal.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.trabajofinal.data.local.dao.IPeliculaDao;
import com.example.trabajofinal.data.local.db.PeliculaDatabase;
import com.example.trabajofinal.domain.model.Pelicula;

import java.util.List;

public class PeliculaRepository {
    private final LiveData<List<Pelicula>> listaPeliculas;
    private final IPeliculaDao peliculaDao;

    public PeliculaRepository(Context context) {
        PeliculaDatabase peliculaDatabaseInstance = PeliculaDatabase.obtenerInstancia(context);
        peliculaDao = peliculaDatabaseInstance.peliculaDao();
        listaPeliculas = peliculaDao.obtenerListaDePeliculasEnDatabase();
    }

    public LiveData<List<Pelicula>> obtenerListadoDePeliculas() {
        return listaPeliculas;
    }

    public void guardarPelicula(Pelicula Pelicula) {
        PeliculaDatabase.obtenerEjecutorDeEscrituraEnDatabase().execute(
                () -> peliculaDao.insertarPeliculaEnDatabase(Pelicula)
        );
    }
}
