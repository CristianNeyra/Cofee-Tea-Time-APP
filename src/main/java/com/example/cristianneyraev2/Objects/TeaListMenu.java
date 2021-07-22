package com.example.cristianneyraev2.Objects;


import java.io.Serializable;

public class TeaListMenu implements Serializable {
    public int image;
    public String nombre;

    public TeaListMenu(int image, String nombre) {
        this.image = image;
        this.nombre = nombre;
    }

    public int getImge() {
        return image;
    }

    public String getNombre() {
        return nombre;
    }



}



