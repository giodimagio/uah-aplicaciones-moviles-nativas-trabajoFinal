package com.uah.trabajofinal.data.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.uah.trabajofinal.data.local.dao.IPeliculaDao;
import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaDatabase
 * @descripcion Clase abstracta que representa una base de datos local Room (SQLite) para almacenar
 * peliculas y sus metadatos.
 * @see RoomDatabase
 * @see Database
 */
@Database(entities = {Pelicula.class}, version = 1, exportSchema = false)
public abstract class PeliculaDatabase extends RoomDatabase {

    /**
     * @descripcion Método abstracto que obtiene una instancia de la interfaz IPeliculaDao para
     * acceder a las operaciones CRUD en la base de datos 'peliculasdb'. Este método permite
     * desacoplar la capa de aplicación de la capa de persistencia, proporcionando un objeto DAO
     * (Objeto de Acceso a Datos) que facilita la interacción con la tabla 'peliculasTabla'.
     * @return Una instancia de la interfaz IPeliculaDao que proporciona métodos para realizar
     * operaciones CRUD en la base de datos Room.
     * @see IPeliculaDao
     */
    public abstract IPeliculaDao peliculaDao();

    /**
     * @descripcion Constante con el nombre de la base de datos.
     */
    private static final String NOMBRE_DATABASE = "peliculasdb";

    /**
     * @descripcion Número de hilos del ejecutor.
     */
    private static final int NUM_HILOS = 4;

    /**
     * @descripcion Instancia única de la base de datos.
     */
    private static volatile PeliculaDatabase instanciaPeliculaDatabase;

    /**
     * @descripcion Ejecutor de escritura en la base de datos.
     */
    private static final ExecutorService ejecutorDeEscrituraEnDatabase =
            Executors.newFixedThreadPool(NUM_HILOS);

    /**
     * @descripcion Obtiene el ejecutor de escritura en la base de datos.
     */
    public static ExecutorService obtenerEjecutorDeEscrituraEnDatabase() {
        return ejecutorDeEscrituraEnDatabase;
    }

    /**
     * @descripcion Método estático que obtiene una instancia única de la base de datos.
     * @param context El contexto de la aplicación.
     * @return La instancia única de la base de datos Room.
     * @see Context
     * @see Room
     * @see PeliculaDatabase
     */
    public static synchronized PeliculaDatabase obtenerInstancia(Context context) {
        if (instanciaPeliculaDatabase == null) {
            instanciaPeliculaDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PeliculaDatabase.class,
                    NOMBRE_DATABASE
            ).build();
        }
        return instanciaPeliculaDatabase;
    }
}