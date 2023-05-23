package com.uah.trabajofinal.data.remote.api;

import com.uah.trabajofinal.domain.model.PeliculaApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IOMDbApiClient {

    @GET("/")
    Call<PeliculaApiResponse> getPeliculaByTitle(@Query("t") String movieTitle, @Query("apikey") String apiKey);
}
