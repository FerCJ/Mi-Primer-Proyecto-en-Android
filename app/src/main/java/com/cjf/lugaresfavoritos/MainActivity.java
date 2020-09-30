package com.cjf.lugaresfavoritos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ubicacion;
    private double lat;
    private double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void CambiarUbicacion1(View v) {
        ubicacion = (Button) v.findViewById(R.id.btnLugar1);
        lat = 19.4363791;
        lon = -99.1417979;
        Intent intent = new Intent(MainActivity.this, Ubicaciones.class);
        intent.putExtra("Latitud", lat);
        intent.putExtra("Longitud", lon);
        startActivity(intent);
    }

    public void CambiarUbicacion2(View v) {
        ubicacion = (Button) v.findViewById(R.id.btnLugar2);
        lat = 19.4321911;
        lon = -99.1344757;
        Intent intent = new Intent(MainActivity.this, Ubicaciones.class);
        intent.putExtra("Latitud", lat);
        intent.putExtra("Longitud", lon);
        startActivity(intent);
    }

    public void CambiarUbicacion3(View v) {
        ubicacion = (Button) v.findViewById(R.id.btnLugar3);
        lat = 19.4204397;
        lon = -99.181935;
        Intent intent = new Intent(MainActivity.this, Ubicaciones.class);
        intent.putExtra("Latitud", lat);
        intent.putExtra("Longitud", lon);
        startActivity(intent);
    }

    public void CambiarUbicacion4(View v) {
        ubicacion = (Button) v.findViewById(R.id.btnLugar4);
        lat = 19.2850197;
        lon = -99.1107548;
        Intent intent = new Intent(MainActivity.this, Ubicaciones.class);
        intent.putExtra("Latitud", lat);
        intent.putExtra("Longitud", lon);
        startActivity(intent);
    }

}