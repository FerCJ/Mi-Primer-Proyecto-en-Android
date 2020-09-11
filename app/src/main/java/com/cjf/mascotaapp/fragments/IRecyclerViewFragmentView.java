package com.cjf.mascotaapp.fragments;

import com.cjf.mascotaapp.pojo.Mascotas;
import com.cjf.mascotaapp.adaptader.MascotaAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView
{

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascota);
    public void inicializarAdaptador(MascotaAdaptador adaptador);
}
