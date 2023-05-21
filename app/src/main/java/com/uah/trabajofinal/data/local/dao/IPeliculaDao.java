package com.uah.trabajofinal.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.List;

/**
 * @author Jorge Romero
 *
 * @interfaz IPeliculaDao
 * @descripcion Interfaz de acceso a datos (DAO) para la entidad Pelicula. Define los métodos para
 * realizar operaciones CRUD en la base de datos local Room (SQLite), 'peliculasdb'.
 * @see Dao
 * @see Insert
 */
@Dao
public interface IPeliculaDao {

    /**
     * @descripcion Obtiene una lista de todas las películas almacenadas en la base de datos.
     * @return LiveData<List<Pelicula>> una lista observable de objetos Pelicula.
     * @see Query
     */
    @Query("SELECT * FROM peliculasTabla")
    LiveData<List<Pelicula>> obtenerListaDePeliculasEnDatabase();

    /**
     * @descripcion Inserta una película en la base de datos local o actualiza una existente.
     * @param pelicula El objeto película a insertar/actualizar.
     * @see Insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertarPeliculaEnDatabase(Pelicula pelicula);

    /**
     * @descripcion Borra una película de la base de datos local.
     * @param pelicula El objeto película a borrar.
     * @see Delete
     */
    @Delete
    void borrarPeliculaDeDatabase(Pelicula pelicula);
}
