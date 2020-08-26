package com.cjf.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        TextView textView = findViewById(R.id.textView);
        textView.setText(nombre);

        String fecha = "Fecha de nacimiento: " + intent.getStringExtra("Fecha");
        textView = findViewById(R.id.textView2);
        textView.setText(fecha);

        String telefono = "Tel: " + intent.getStringExtra("Telefono");
        textView = findViewById(R.id.textView3);
        textView.setText(telefono);

        String correo = "E-mail: " + intent.getStringExtra("Correo");
        textView = findViewById(R.id.textView4);
        textView.setText(correo);

        String descripcion = "Descripción: " + intent.getStringExtra("Descripcion");
        textView = findViewById(R.id.textView5);
        textView.setText(descripcion);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void editarDatos(View v)
    {
       finish();

    }
}