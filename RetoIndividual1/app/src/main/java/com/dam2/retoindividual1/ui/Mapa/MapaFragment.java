package com.dam2.retoindividual1.ui.Mapa;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.dam2.retoindividual1.R;
import com.dam2.retoindividual1.databinding.FragmentMapaBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private FragmentMapaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMapaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapView);

        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setExitTransition(inflater1.inflateTransition(R.transition.slider));
        setEnterTransition(inflater1.inflateTransition(R.transition.slider));

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }


        return root;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng almiLocation = new LatLng(43.27194410993097, -2.948690282430884); //coordenadas de Almi
        googleMap.addMarker(new MarkerOptions().position(almiLocation).title("Almi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(almiLocation, 15f));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}