package com.example.trabajofinal.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.domain.repository.PeliculaRepository;
import com.example.trabajofinal.domain.model.Pelicula;
import com.example.trabajofinal.ui.viewmodel.PeliculaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PeliculaViewModel peliculaViewModelInstance;
    private PeliculaRepository peliculaRepository;

    //TODO mostrarObjetoPeliculaTextView de momento, solo para mostrar el toString() de prueba
    private TextView mostrarObjetoPeliculaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostrarObjetoPeliculaTextView = findViewById(R.id.mainActivityTextView);
        peliculaRepository = new PeliculaRepository(getApplicationContext());

        peliculaViewModelInstance = new ViewModelProvider(this).get(PeliculaViewModel.class);
        peliculaViewModelInstance.obtenerTodasLasPeliculas().observe(this, this::mostrarTodasLasPeliculas);
    }

    private void mostrarTodasLasPeliculas(List<Pelicula> peliculas) {
        mostrarObjetoPeliculaTextView.setText(TextUtils.join("\n\n", peliculas));
    }

}