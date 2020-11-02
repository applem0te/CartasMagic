package com.example.cartas.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cartas.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainFragment extends Fragment {

    private ArrayList<Carta> items;
    private CartasAdapter adapter;

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lv_cartas, container, false);

        ListView lvCartas = view.findViewById(R.id.lvCartas);

        items = new ArrayList<>();
        adapter = new CartasAdapter(
                getContext(),
                R.layout.lv_cartas_row,
                items
        );
        lvCartas.setAdapter(adapter);

        return view;
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Carta>> {

        @Override
        protected ArrayList<Carta> doInBackground(Void... voids) {
            CartaAPI api = new CartaAPI();
            ArrayList<Carta> result = api.getCartas();
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Carta> cartas) {
            adapter.clear();
            for (Carta cart : cartas) {
                adapter.add(cart);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cartas_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}