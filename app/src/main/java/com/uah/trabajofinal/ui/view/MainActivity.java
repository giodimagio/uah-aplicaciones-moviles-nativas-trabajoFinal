package com.uah.trabajofinal.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uah.trabajofinal.R;
import com.uah.trabajofinal.data.repository.PeliculaRepository;
import com.uah.trabajofinal.utils.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private final Logger logger = new Logger(MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtner la instancia de NavHostFragment y NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragmentContainer);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Configura el BottomNavigationView con un listener para que al pulsarlo pueda navegar a los distintos fragmentos
        BottomNavigationView menuInferiorNavegacion = findViewById(R.id.menuInferiorNavegacion);
        menuInferiorNavegacion.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int idElementoMenuSeleccionado = item.getItemId();

        if (idElementoMenuSeleccionado == R.id.menuInferiorNavegacionElemento1) {
            navController.navigate(R.id.peliculaCardListFragment);
            logger.i("Navegando a la vista de 'Home'");
            return true;
        } else if (idElementoMenuSeleccionado == R.id.menuInferiorNavegacionElemento2) {
            navController.navigate(R.id.barraBusquedaFragment);
            logger.i("Navegando a la vista de 'Buscar película'");
            return true;
        } else if (idElementoMenuSeleccionado == R.id.menuInferiorNavegacionElemento3) {
            logger.i("Diálogo 'Salir de la app' seleccionado");
            onSalirMenuItemSelected();
            return true;
        }
        return false;
    }

    private void onSalirMenuItemSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salir de la app")
                .setMessage("¿Estás seguro de que quieres salir de la aplicación?")
                .setPositiveButton("Aceptar", (DialogInterface dialog, int which) -> {
                    logger.i("Diálogo 'Salir de la app': Seleccionada la opción 'Aceptar'. Saliendo...");
                    finish();
                })
                .setNegativeButton("Cancelar", (DialogInterface dialog, int which) -> {
                    logger.i("Diálogo 'Salir de la app': Seleccionada la opción 'Cancelar'. Cancelando...");
                    dialog.cancel();
                })
                .setCancelable(true).setOnCancelListener((DialogInterface dialog) -> {
                    logger.i("Diálogo 'Salir de la app': Cancelado");
                    dialog.cancel();
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}