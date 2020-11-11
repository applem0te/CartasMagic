package com.example.cartas.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cartas.R;

import java.util.List;

public class CartasAdapter extends ArrayAdapter<Carta> {

    public CartasAdapter(Context context, int resource, List<Carta> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Carta carta = getItem(position);
        Log.w("XXXX", carta.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_cartas_row, parent, false);
        }

        TextView tvCarta = convertView.findViewById(R.id.tvCarta);
        TextView tvType = convertView.findViewById(R.id.tvType);
        ImageView ivImage = convertView.findViewById(R.id.ivImage);

        tvCarta.setText(carta.getName());
        tvType.setText(carta.getType());

        Glide.with(getContext()).load(carta.getImageURL()).into(ivImage);

        return convertView;
    }

}
