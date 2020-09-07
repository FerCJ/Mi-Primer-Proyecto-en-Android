package com.cjf.mascotaapp.optionsmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cjf.mascotaapp.R;

public class ActivityContacto extends AppCompatActivity {
    private EditText mEmail;
    private EditText mNombre;
    private EditText mMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        mEmail = (EditText) findViewById(R.id.etEmail);
        mNombre = (EditText) findViewById(R.id.etNombre);
        mMensaje = (EditText) findViewById(R.id.etMensaje);

    }

    public void enviarMail(View v)
    {
        String correo = mEmail.getText().toString().trim();
        String mensaje = mNombre.getText().toString().trim();
        String nombre = mMensaje.getText().toString();

        JavaMailAPI javaMail = new JavaMailAPI(this,correo,mensaje,nombre);
        javaMail.execute();
    }
}