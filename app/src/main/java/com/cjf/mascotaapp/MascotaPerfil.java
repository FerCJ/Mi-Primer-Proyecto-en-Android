package com.cjf.mascotaapp;

public class MascotaPerfil {

    private int likes;
    private int foto;

    public  MascotaPerfil(int likes, int foto)
    {
        this.foto = foto;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
