package com.cjf.mascotaapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjf.mascotaapp.Mascotas;
import com.cjf.mascotaapp.R;
import com.cjf.mascotaapp.adaptader.MascotaAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment
{
    ArrayList<Mascotas> mascotas;
    private RecyclerView lstMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        lstMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        lstMascotas.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);

        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas("Chupon",0,R.drawable.pet10));
        mascotas.add(new Mascotas("Pakkun",0,R.drawable.pet8));
        mascotas.add(new Mascotas("Asgard",0,R.drawable.pet9));
        mascotas.add(new Mascotas("Kobak",0,R.drawable.pet7));
        mascotas.add(new Mascotas("Scarton",0,R.drawable.pet6));
        mascotas.add(new Mascotas("Cabo",0,R.drawable.pet1));
        mascotas.add(new Mascotas("Zeus",0,R.drawable.pet5));
        mascotas.add(new Mascotas("Malak",0,R.drawable.pet3));
        mascotas.add(new Mascotas("Puppy",0,R.drawable.pet2));
        mascotas.add(new Mascotas("Mila",0,R.drawable.pet4));
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        lstMascotas.setAdapter(adaptador);
    }
}
