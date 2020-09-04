package com.cjf.mascotaapp;

import android.util.Log;

public class Mascotas {
    private String nombre;
    private int likes;
    private int foto;

    public int getFoto() {
        final String TAG = "MyActivity";
        Log.d(TAG,"Positon antes: " + foto);
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Mascotas(String nombre, int likes, int foto)
    {
        this.nombre = nombre;
        this.likes = likes;
        this.foto = foto;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
