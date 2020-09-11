package com.cjf.mascotaapp;

import android.os.Bundle;

import com.cjf.mascotaapp.adaptader.MascotaAdaptador;
import com.cjf.mascotaapp.pojo.Mascotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

import static com.cjf.mascotaapp.adaptader.MascotaAdaptador.mascotasFive;

public class FivePets extends AppCompatActivity {

    ArrayList<Mascotas> mascotas2;
    private RecyclerView lstMascotas2;
    private MascotaAdaptador mascotaAdaptador;


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

        mascotas2 = mascotasFive;

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