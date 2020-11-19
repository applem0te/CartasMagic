package com.example.cartas;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cartas.ui.main.Carta;

import java.util.List;

@Dao
public interface CartaDAO {
    @Query("select * from carta")
    LiveData<List<Carta>> getCartas();

    @Insert
    void addCarta(Carta carta);

    @Insert
    void addCartas(List<Carta> cartas);

    @Delete
    void deleteCarta(Carta carta);

    @Query("DELETE FROM carta")
    void deleteCartas();
}