package com.dam2.retoindividual1.ui.Galeria;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dam2.retoindividual1.R;
import com.dam2.retoindividual1.databinding.FragmentGaleriaBinding;

public class GaleriaFragment extends Fragment {

    private FragmentGaleriaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GaleriaViewModel galeriaViewModel = new ViewModelProvider(this).get(GaleriaViewModel.class);

        //binding = FragmentGaleriaBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();


        //inflo las transiciones
        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.slider));
        setEnterTransition(inflater1.inflateTransition(R.transition.slider));

        return inflater.inflate(R.layout.fragment_galeria, container, false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //TAB LAYOUT MEDIATOR
}