package com.uah.trabajofinal.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uah.trabajofinal.R;
import com.uah.trabajofinal.utils.logger.Logger;

/**
 * @author Jorge Romero
 *
 * @clase MainActivity
 * @descripcion Actividad principal de la aplicación
 * @see AppCompatActivity
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Atributos de la clase
     */
    private NavController navController;
    private final Logger logger = new Logger(MainActivity.class);

    /**
     * @descripcion Método que se ejecuta cuando se crea la actividad
     * @param savedInstanceState Bundle que contiene el estado previamente guardado de esta actividad
     */
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

    /**
     * @descripcion Método para gestionar la navegación según que elemento del menú inferior de
     * navegación se seleccione
     * @param item El elemento del menú inferior de navegación seleccionado
     * @return true si se ha seleccionado un elemento del menú inferior de navegación,
     * false en caso contrario
     */
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

    /**
     * @descripcion Método para gestionar la opción de salir de la aplicación
     */
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