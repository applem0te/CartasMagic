package com.example.cartas.ui.main;

import java.io.Serializable;

public class Carta implements Serializable {
    private String name;
    private String type;
    private String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imageURL='" + imageURL +
                '}';
    }
}
