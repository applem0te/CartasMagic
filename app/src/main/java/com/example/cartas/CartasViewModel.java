package com.example.cartas;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.preference.PreferenceManager;

import com.example.cartas.ui.main.Carta;
import com.example.cartas.ui.main.CartaAPI;

import java.util.ArrayList;
import java.util.List;

public class CartasViewModel extends AndroidViewModel {
    private final Application app;
    private final AppDatabase appDatabase;
    private final CartaDAO cartaDao;
    private LiveData<List<Carta>> cartas;

    public CartasViewModel(Application application) {
        super(application);

        this.app = application;
        this.appDatabase = AppDatabase.getDatabase(
                this.getApplication());
        this.cartaDao = appDatabase.getCartaDAO();
    }

    public LiveData<List<Carta>> getCartas() {

        return cartaDao.getCartas();
    }


    public void reload() {
        // do async operation to fetch users
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                    app.getApplicationContext()
            );

            CartaAPI api = new CartaAPI();
            ArrayList<Carta> result;
            result = api.getCartas();

            cartaDao.deleteCartas();
            cartaDao.addCartas(result);

            return null;
        }

    }

}