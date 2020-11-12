package com.example.cartas.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cartas.R;

public class DetailFragment extends Fragment {

    private View view;
    private ImageView ivImage;
    private TextView tvCarta;
    private TextView tvType;
    private TextView tvFlavor;
    private TextView tvText;

    public DetailFragment() {
    }

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

        return view;
    }

    private void updateUi(Carta carta) {
        Log.d("CARTA", carta.toString());

        ivImage = view.findViewById(R.id.ivImage);
        tvCarta =  view.findViewById(R.id.tvCarta);
        tvType = view.findViewById(R.id.tvType);
        tvFlavor =   view.findViewById(R.id.tvFlavor);
        tvText = view.findViewById(R.id.tvText);

        tvCarta.setText(carta.getName());
        tvType.setText(carta.getType());
        tvFlavor.setText(carta.getFlavor());
        tvText.setText(Html.fromHtml("<b>Synopsis:</b> " + carta.getText()));
        try{
            Glide.with(getContext()).load(carta.getImageURL()).into(ivImage);
        }
        catch(Exception e){
            System.out.println("No image");
        }

    }
}