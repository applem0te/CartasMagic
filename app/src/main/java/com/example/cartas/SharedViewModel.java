package com.example.cartas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cartas.ui.main.Carta;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Carta> selected = new MutableLiveData<Carta>();

    public void select(Carta carta) {
        selected.setValue(carta);
    }

    public LiveData<Carta> getSelected() {
        return selected;
    }
}
