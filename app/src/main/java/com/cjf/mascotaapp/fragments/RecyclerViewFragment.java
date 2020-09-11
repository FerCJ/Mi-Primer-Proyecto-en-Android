package com.cjf.mascotaapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjf.mascotaapp.pojo.Mascotas;
import com.cjf.mascotaapp.R;
import com.cjf.mascotaapp.adaptader.MascotaAdaptador;
import com.cjf.mascotaapp.presentador.IRecyclerViewFragmentPresenter;
import com.cjf.mascotaapp.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView
{
    ArrayList<Mascotas> mascotas;
    private RecyclerView lstMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        lstMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        lstMascotas.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical()
    {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascota)
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota);

        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        lstMascotas.setAdapter(adaptador);
    }
}
