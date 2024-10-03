package com.dam2.retoindividual1.ui.Inicio;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dam2.retoindividual1.R;
import com.dam2.retoindividual1.databinding.FragmentInicioBinding;

import java.util.List;
import java.util.Objects;

public class InicioFragment extends Fragment {

    private FragmentInicioBinding binding;
    private InicioViewModel inicioViewModel;
    private ListView listaPersonas;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        inicioViewModel = new ViewModelProvider(this).get(InicioViewModel.class);

        //binding = FragmentInicioBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        View root = inflater.inflate(R.layout.fragment_inicio, container, false);

        listaPersonas = root.findViewById(R.id.lvCursos);

        //inicializo el adapter y paso la lista de cursos por mi ListView
        inicioViewModel.getCursos().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> cursos) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(InicioFragment.this.requireContext(),
                        android.R.layout.simple_dropdown_item_1line, cursos);

                listaPersonas.setAdapter(adapter);
            }
        });

        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.slider));
        setEnterTransition(inflater1.inflateTransition(R.transition.slider));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}