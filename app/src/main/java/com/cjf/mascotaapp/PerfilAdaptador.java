package com.cjf.mascotaapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjf.mascotaapp.adaptader.MascotaAdaptador;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>
{
    private ArrayList<MascotaPerfil> mascota;
    Context context;

    public PerfilAdaptador(ArrayList<MascotaPerfil> mascota)
    {
        this.mascota = mascota;
    }

    public  static class PerfilViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgPet;
        private ImageView   imgLikes;
        private TextView    tvLike;


        public PerfilViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgPet = (ImageView) itemView.findViewById(R.id.imgPetPerfil);
            imgLikes = (ImageView) itemView.findViewById(R.id.imgLikesPerfil);
            tvLike = (TextView) itemView.findViewById(R.id.tvLikePerfil);
        }
    }

    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perfil_cardview,parent,false);
         context = parent.getContext();
        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilAdaptador.PerfilViewHolder holder, int position)
    {
        final MascotaPerfil mascotas = mascota.get(position);
        holder.tvLike.setText(Integer.toString(mascotas.getLikes()));
        holder.imgPet.setImageResource(mascotas.getFoto());
        holder.imgLikes.setImageResource(R.drawable.icons8_dog_bone_48);

    }

    @Override
    public int getItemCount() {
        return (mascota == null) ? 0 : mascota.size();
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
