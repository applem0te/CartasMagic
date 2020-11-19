package com.example.cartas.ui.main;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Carta implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String type;
    private String imageURL;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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
