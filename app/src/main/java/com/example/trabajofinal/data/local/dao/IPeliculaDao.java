package com.example.trabajofinal.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.trabajofinal.domain.model.Pelicula;

import java.util.List;

@Dao
public interface IPeliculaDao {

    @Query("SELECT * FROM peliculasTabla")
    LiveData<List<Pelicula>> obtenerListaDePeliculas();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void guardarPelicula(Pelicula pelicula);
}
