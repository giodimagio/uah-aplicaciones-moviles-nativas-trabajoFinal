package com.uah.trabajofinal.data.remote.api;

import com.uah.trabajofinal.domain.model.PeliculaApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jorge Romero
 *
 * @interfaz IOMDbApiClient
 * @descripcion Interfaz de acceso a la API de OMDb
 * @see Call
 */
public interface IOMDbApiClient {

    /**
     * @descripcion Obtiene una película de la API OMDb por su título.
     * @param movieTitle Título de la película.
     * @param apiKey Clave de autorización de la API OMDb.
     * @return PeliculaApiResponse Un objeto PeliculaApiResponse con la información de la película.
     */
    @GET("/")
    Call<PeliculaApiResponse> getPeliculaByTitle(@Query("t") String movieTitle, @Query("apikey") String apiKey);
}
