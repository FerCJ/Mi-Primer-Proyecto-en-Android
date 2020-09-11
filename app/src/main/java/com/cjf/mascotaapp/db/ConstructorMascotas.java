package com.cjf.mascotaapp.db;

import android.app.usage.ConfigurationStats;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.cjf.mascotaapp.R;
import com.cjf.mascotaapp.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorMascotas
{
    private Context context;
    public static final int LIKE = 1;

    public ConstructorMascotas(Context context)
    {
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos()
    {
        final String TAG = "MyActivity";
        Log.d(TAG,"Paso: 4");
        /*ArrayList<Mascotas> mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Chupon",0,R.drawable.pet10));
        mascotas.add(new Mascotas("Pakkun",0,R.drawable.pet8));
        mascotas.add(new Mascotas("Asgard",0,R.drawable.pet9));
        */

        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarContactos(BaseDatos db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Chupón");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet10);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Pakkun");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet8);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Asgard");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet9);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Kobak");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet7);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Scarton");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet6);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Cabo");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet1);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Zeus");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet5);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Malak");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet3);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Puppy");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet2);

        db.insertarContacto(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Mila");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.pet4);

        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Mascotas mascota)
    {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascotas mascotas)
    {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascotas);
    }
}
