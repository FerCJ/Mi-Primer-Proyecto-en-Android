package com.cjf.mascotaapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    public MascotaAdaptador(ArrayList<Mascotas> mascotas)
    {
        this.mascotas = mascotas;
    }

    public  static class MascotaViewHolder extends RecyclerView.ViewHolder{
         private ImageView   imgPet;
         private ImageView   imgLikes;
         private Button      imgGLike;
         private TextView    tvNombre;
         private TextView    tvLike;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPet = (ImageView) itemView.findViewById(R.id.imgPet);
            imgLikes = (ImageView) itemView.findViewById(R.id.imgLikes);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLike = (TextView) itemView.findViewById(R.id.tvLike);
            imgGLike = (Button) itemView.findViewById(R.id.imgGLike);
        }
    }

    private ArrayList<Mascotas> mascotas;
    private int posicion;
    Context context;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        context = parent.getContext();
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position)
    {
            final String TAG = "MyActivity";
            Log.d(TAG,"Positon antes: " + position);
            final Mascotas mascota = mascotas.get(position);
            holder.tvLike.setText(Integer.toString(mascota.getLikes()));
            holder.imgGLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int likes = mascota.getLikes();
                likes = likes + 1;
                mascota.setLikes(likes);
                holder.tvLike.setText(Integer.toString(mascota.getLikes()));
            }

        });
        holder.imgPet.setImageResource(mascota.getFoto());


        Log.d(TAG,"Numero de imagen: " + mascota.getFoto());

        holder.imgLikes.setImageResource(R.drawable.icons8_dog_bone_48);
        holder.tvNombre.setText(mascota.getNombre());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
