package com.uah.trabajofinal.data.remote.api;

import androidx.annotation.NonNull;

import com.uah.trabajofinal.domain.model.PeliculaApiResponse;
import com.uah.trabajofinal.utils.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController implements Callback<PeliculaApiResponse> {

    private static final String BASE_URL = "http://www.omdbapi.com/";
    private static final String API_KEY = "c6191c2b";
    private static final Logger logger = new Logger(RetrofitController.class);

    private final IOMDbApiClient apiClient;

    public RetrofitController() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiClient = retrofit.create(IOMDbApiClient.class);
    }

    public void busquedaPorTitulo(String titulo) {
        Call<PeliculaApiResponse> call = apiClient.getPeliculaByTitle(titulo, API_KEY);
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<PeliculaApiResponse> call, Response<PeliculaApiResponse> response) {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                PeliculaApiResponse pelicula = new PeliculaApiResponse();
                pelicula.setTitle(response.body().getTitle());
                pelicula.setYear(response.body().getYear());
                pelicula.setRuntime(response.body().getRuntime());
                pelicula.setCountry(response.body().getCountry());
                pelicula.setDirector(response.body().getDirector());
                pelicula.setActors(response.body().getActors());
                pelicula.setPlot(response.body().getPlot());
                pelicula.setPoster(response.body().getPoster());
                logger.i("Retrofit2 - onSuccessfulResponse: " + pelicula);
            }
        } else {
            logger.i("Retrofit2 - onServerErrorResponse: " + response.errorBody());
        }
    }

    @Override
    public void onFailure(@NonNull Call<PeliculaApiResponse> call, Throwable t) {
        logger.i("Retrofit2 - onFailureResponse: " + t.getMessage());
    }
}
