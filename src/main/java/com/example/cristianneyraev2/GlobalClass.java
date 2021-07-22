package com.example.cristianneyraev2;

import android.app.Application;

public class GlobalClass extends Application {
    private String nombre;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pasoNombre) {
        this.nombre = pasoNombre;
    }


}
