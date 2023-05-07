package com.example.trabajofinal.data.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trabajofinal.data.local.dao.IPeliculaDao;
import com.example.trabajofinal.domain.model.Pelicula;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Pelicula.class}, version = 1, exportSchema = false)
public abstract class PeliculaDatabase extends RoomDatabase {

    public abstract IPeliculaDao peliculaDao();

    private static final String NOMBRE_DATABASE = "peliculasdb";
    private static final int NUM_HILOS = 4;
    private static volatile PeliculaDatabase instanciaPeliculaDatabase;

    private static final ExecutorService ejecutorDeEscrituraEnDatabase =
            Executors.newFixedThreadPool(NUM_HILOS);

    public static ExecutorService obtenerEjecutorDeEscrituraEnDatabase() {
        return ejecutorDeEscrituraEnDatabase;
    }

    public static PeliculaDatabase obtenerInstancia(Context context) {
        if (instanciaPeliculaDatabase == null) {
            synchronized (PeliculaDatabase.class) {
                if (instanciaPeliculaDatabase == null) {
                    instanciaPeliculaDatabase = Room.databaseBuilder(
                                    context.getApplicationContext(), PeliculaDatabase.class,
                                    NOMBRE_DATABASE)
                            .build();
                }
            }
        }
        return instanciaPeliculaDatabase;
    }
}