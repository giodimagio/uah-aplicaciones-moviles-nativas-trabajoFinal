package com.uah.trabajofinal.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.List;

@Dao
public interface IPeliculaDao {

    @Query("SELECT * FROM peliculasTabla")
    LiveData<List<Pelicula>> obtenerListaDePeliculasEnDatabase();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarPeliculaEnDatabase(Pelicula pelicula);
}
