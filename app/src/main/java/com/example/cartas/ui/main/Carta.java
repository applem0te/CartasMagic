package com.example.cartas.ui.main;

import java.io.Serializable;

public class Carta implements Serializable {
    private String name;
    private String type;
    private String imageURL;
    private String text;
    private String flavor;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", text='" + text + '\'' +
                ", flavor='" + flavor + '\'' +
                '}';
    }
}
