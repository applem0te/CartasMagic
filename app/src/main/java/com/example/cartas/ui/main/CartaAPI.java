package com.example.cartas.ui.main;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CartaAPI {

    private final String BASE_URL = "https://api.magicthegathering.io/";
    private final String API_KEY = "<api-key>";

    public ArrayList<Carta> getCartas() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("v1")
                .appendPath("cards")
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private ArrayList<Carta> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Carta> processJson(String jsonResponse) {
        ArrayList<Carta> cartas = new ArrayList<>();
        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");
            for (int i = 0; i < jsonCartas.length(); i++) {
                JSONObject jsonCarta = jsonCartas.getJSONObject(i);

                Carta carta = new Carta();
                carta.setName(jsonCarta.getString("name"));
                carta.setType(jsonCarta.getString("type"));

                try{
                    carta.setImageURL(jsonCarta.getString("imageUrl"));
                }
                catch(Exception e){
                    System.out.println("Null image");
                }
                cartas.add(carta);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cartas;
    }
}
