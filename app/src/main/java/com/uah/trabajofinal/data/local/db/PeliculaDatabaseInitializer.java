package com.uah.trabajofinal.data.local.db;

import com.uah.trabajofinal.domain.model.Pelicula;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PeliculaDatabaseInitializer {

    public static void insertarDatosIniciales(PeliculaDatabase database) {
        ExecutorService ejecutorDeEscrituraEnDatabase = Executors.newSingleThreadExecutor();
        ejecutorDeEscrituraEnDatabase.execute(() -> {
            Pelicula pelicula1 = new Pelicula(1, "Prueba1", 1991,
                    "2019-04-03", "Madrid", 5,
                    120, "SPA", "Manolo", "Terror",
                    "Pruébala", "IMAGEN_PNG1", "Rigoberto");

            Pelicula pelicula2 = new Pelicula(2, "Prueba2", 1992,
                    "2020-04-03", "Vigo", 6,
                    180, "ENG", "Paco", "Thriller",
                    "Mírala", "IMAGEN_PNG2", "Gumersinda");

            database.peliculaDao().insertarPeliculaEnDatabase(pelicula1);
            database.peliculaDao().insertarPeliculaEnDatabase(pelicula2);

            ejecutorDeEscrituraEnDatabase.shutdown();
        });
    }
}
