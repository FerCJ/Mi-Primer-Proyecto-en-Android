package com.cjf.mascotaapp.presentador;

import android.content.Context;
import android.util.Log;

import com.cjf.mascotaapp.db.ConstructorMascotas;
import com.cjf.mascotaapp.fragments.IRecyclerViewFragmentView;
import com.cjf.mascotaapp.pojo.Mascotas;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter
{
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,Context context)
    {
      this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
      this.context = context;
        final String TAG = "MyActivity";
        Log.d(TAG,"Paso: 2");
      obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos()
    {
        constructorMascotas = new ConstructorMascotas(context);

        mascotas = constructorMascotas.obtenerDatos();


        mostrarMascotcas();
    }

    @Override
    public void mostrarMascotcas()
    {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascotas));

        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
