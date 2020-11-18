package com.example.cartas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cartas.ui.main.DetailFragment;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance())
                    .commitNow();
        }
    }
}