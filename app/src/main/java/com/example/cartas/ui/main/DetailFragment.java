package com.example.cartas.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cartas.R;
import com.example.cartas.SharedViewModel;

public class DetailFragment extends Fragment {

    private View view;
    private ImageView ivImage;
    private TextView tvCarta;
    private TextView tvType;

    private DetailViewModel mViewModel;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_fragment, container, false);

        Intent i = getActivity().getIntent();

        if (i != null) {
            Carta carta = (Carta) i.getSerializableExtra("carta");

            if (carta != null) {
                updateUi(carta);
            }
        }

        SharedViewModel sharedModel = ViewModelProviders.of(
                getActivity()
        ).get(SharedViewModel.class);
        sharedModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Carta>() {
            @Override
            public void onChanged(@Nullable Carta carta) {
                updateUi(carta);
            }
        });


        return view;
    }

    private void updateUi(Carta carta) {
        Log.d("CARTA", carta.toString());

        ivImage = view.findViewById(R.id.ivImage);
        tvCarta =  view.findViewById(R.id.tvCarta);
        tvType = view.findViewById(R.id.tvType);

        tvCarta.setText(carta.getName());
        tvType.setText(carta.getType());

        Glide.with(getContext()).load(carta.getImageURL()).into(ivImage);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
        // TODO: Use the ViewModel
    }

}