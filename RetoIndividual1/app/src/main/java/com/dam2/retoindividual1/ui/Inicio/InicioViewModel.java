package com.dam2.retoindividual1.ui.Inicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class InicioViewModel extends ViewModel {

    private final MutableLiveData<List<String>> cursos;

    public InicioViewModel() {
        cursos = new MutableLiveData<>();
        rellenarCursos();
    }

    public LiveData<List<String>> getCursos() {
        return cursos;
    }


    private void rellenarCursos(){

        List<String> listaCursos = new ArrayList<>();
        //añado los cursos
        listaCursos.add("DAM 1");
        listaCursos.add("DAM 2");
        listaCursos.add("SMR 1");
        listaCursos.add("SMR 2");
        listaCursos.add("GA 1");
        listaCursos.add("GA 2");

        cursos.setValue(listaCursos);
    }
}