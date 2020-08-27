package com.cjf.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplayDate;
    private Button siguiente;
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
            mes = mes+1;
            String fecha = dia + "/" + mes + "/" + año;
            mDisplayDate.setText(fecha);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate = (TextView) findViewById(R.id.fechanacimiento);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                ,mDateSetListener,año,mes,dia);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


    }

    public void confirmarDatos(View v)
    {
        Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String nombre = editText.getText().toString();
        intent.putExtra("Nombre",nombre);

        TextView textView = (TextView) findViewById(R.id.fechanacimiento);
        String fecha = textView.getText().toString();
        intent.putExtra("Fecha",fecha);

        editText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String correo = editText.getText().toString();
        intent.putExtra("Correo",correo);

        editText = (EditText) findViewById(R.id.editTextPhone);
        String telefono = editText.getText().toString();
        intent.putExtra("Telefono",telefono);

        editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        String descripcion = editText.getText().toString();
        intent.putExtra("Descripcion",descripcion);

        startActivity(intent);
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}