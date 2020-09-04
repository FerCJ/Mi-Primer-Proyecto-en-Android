package com.cjf.mascotaapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascotas> mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Accion todavía no disponible", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lstMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        lstMascotas.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        LinearLayoutManager llm = new LinearLayoutManager(this);
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
    }

    public void inicializarAdaptador()
    {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        lstMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cincoMascotas(View v)
    {
        Intent intent = new Intent(MainActivity.this,FivePets.class);
        startActivity(intent);
    }
}