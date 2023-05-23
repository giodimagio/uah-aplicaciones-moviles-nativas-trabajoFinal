package com.uah.trabajofinal.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uah.trabajofinal.R;
import com.uah.trabajofinal.data.remote.api.RetrofitController;

public class BarraBusquedaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barra_busqueda, container, false);

        RetrofitController controller = new RetrofitController();
        controller.start();

        return view;
    }
}
