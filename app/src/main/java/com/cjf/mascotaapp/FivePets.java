package com.cjf.mascotaapp;

import android.os.Bundle;

import com.cjf.mascotaapp.adaptader.MascotaAdaptador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class FivePets extends AppCompatActivity {

    ArrayList<Mascotas> mascotas2;
    private RecyclerView lstMascotas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_pets);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        lstMascotas2 = (RecyclerView) findViewById(R.id.rvMascotas2);
        lstMascotas2.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas2.setLayoutManager(llm);

        mascotas2 = new ArrayList<Mascotas>();
        mascotas2.add(new Mascotas("Chupon",15,R.drawable.pet10));
        mascotas2.add(new Mascotas("Pakkun",13,R.drawable.pet8));
        mascotas2.add(new Mascotas("Malak",5,R.drawable.pet3));
        mascotas2.add(new Mascotas("Puppy",6,R.drawable.pet2));
        mascotas2.add(new Mascotas("Mila",1,R.drawable.pet4));
        inicializarAdaptador();
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas2);
        lstMascotas2.setAdapter(adaptador);
    }


    public void bckPrincipal(View v)
    {
        finish();
    }
}