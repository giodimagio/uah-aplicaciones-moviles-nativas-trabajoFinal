package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.search.SearchView;
import com.uah.trabajofinal.R;
import com.uah.trabajofinal.data.remote.api.RetrofitController;

public class BarraBusquedaFragment extends Fragment {

    private SearchView barraBusquedaView;
    private RetrofitController controller;
    private PeliculaCardFragment peliculaCardFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barra_busqueda, container, false);

        barraBusquedaView = view.findViewById(R.id.barraBusquedaSearchView);
        peliculaCardFragment = new PeliculaCardFragment();

        buscarPeliculaDesdeBarraDeBusqueda();

        return view;
    }

    private void buscarPeliculaDesdeBarraDeBusqueda() {
        barraBusquedaView.getEditText().setOnEditorActionListener(
                (view, actionId, event) -> {
                    barraBusquedaView.setText(barraBusquedaView.getText());
                    barraBusquedaView.hide();
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        controller = new RetrofitController();
                        controller.busquedaPorTitulo(String.valueOf(barraBusquedaView.getText()));
                        peliculaCardFragment.mostrarPeliculaEncontrada("Gladiatoooooor");
                    }
                    return false;
                });
    }
}
