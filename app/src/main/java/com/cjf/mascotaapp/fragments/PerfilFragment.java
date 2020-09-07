package com.cjf.mascotaapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjf.mascotaapp.MascotaPerfil;
import com.cjf.mascotaapp.Mascotas;
import com.cjf.mascotaapp.PerfilAdaptador;
import com.cjf.mascotaapp.R;
import com.cjf.mascotaapp.adaptader.MascotaAdaptador;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
public class PerfilFragment extends Fragment {

    ArrayList<MascotaPerfil> mascota;
    private RecyclerView lstFotosPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        lstFotosPerfil= (RecyclerView) v.findViewById(R.id.rvFotosPerfil);
        lstFotosPerfil.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        lstFotosPerfil.setLayoutManager(glm);

        mascota = new ArrayList<MascotaPerfil>();
        mascota.add(new MascotaPerfil(10,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(8,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(26,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(15,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(19,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(23,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(36,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(21,R.drawable.sncperfil));
        mascota.add(new MascotaPerfil(54,R.drawable.sncperfil));

        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador()
    {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascota);
        lstFotosPerfil.setAdapter(adaptador);
    }
}