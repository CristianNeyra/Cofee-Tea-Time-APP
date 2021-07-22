package com.example.cristianneyraev2.Objects;

public class CardContacts {
    public int image;
    public String nombre, contacto;

    public CardContacts(int image, String nombre, String contacto) {
        this.image = image;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public int getImge() {
        return image;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }
}
