package com.cjf.mascotaapp.adaptader;

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

import com.cjf.mascotaapp.FivePets;
import com.cjf.mascotaapp.db.ConstructorMascotas;
import com.cjf.mascotaapp.pojo.Mascotas;
import com.cjf.mascotaapp.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascotas> mascotas;
    public static ArrayList<Mascotas> mascotasFive = new ArrayList<Mascotas>();
    private int bandera = 0;
    Context context;


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


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        context = parent.getContext();

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position)
    {
            final String TAG = "MyActivity";
            final Mascotas mascota = mascotas.get(position);
            holder.tvLike.setText(Integer.toString(mascota.getLikes()));
            holder.imgGLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
                constructorMascotas.darLikeContacto(mascota);
                int likes = constructorMascotas.obtenerLikesMascota(mascota);
                holder.tvLike.setText(Integer.toString(likes));

                ArrayList<Mascotas> aux = new ArrayList<Mascotas>();

                if (mascotasFive != null && mascotasFive.size() > 4 )
                {
                    int pos2 = -1;
                    for (int i = 0; i < mascotasFive.size(); i++)
                    {
                        if (mascotasFive.get(i).getNombre() == mascota.getNombre())
                        {
                            pos2 = i;
                        }
                    }
                    if (pos2 != -1)
                    {
                        aux.add(new Mascotas(mascota.getNombre(),likes,mascota.getFoto()));
                        mascotasFive.remove(pos2);
                        aux.add(mascotasFive.get(0));
                        aux.add(mascotasFive.get(1));
                        aux.add(mascotasFive.get(2));
                        aux.add(mascotasFive.get(3));

                        mascotasFive = aux;
                    }
                    else
                    {
                        aux.add(new Mascotas(mascota.getNombre(),likes,mascota.getFoto()));
                        aux.add(mascotasFive.get(0));
                        aux.add(mascotasFive.get(1));
                        aux.add(mascotasFive.get(2));
                        aux.add(mascotasFive.get(3));

                        mascotasFive = aux;
                    }

                }
                else
                {
                    int pos = -1;
                    if (bandera == 0)
                    {

                        mascotasFive.add(new Mascotas(mascota.getNombre(),likes,mascota.getFoto()));
                        bandera = 1;
                    }
                    else
                    {

                        for (int i = 0; i < mascotasFive.size(); i++)
                        {
                            if (mascotasFive.get(i).getNombre() == mascota.getNombre())
                            {
                                pos = i;
                            }
                        }
                        if (pos != -1)
                        {
                            mascotasFive.set(pos, new Mascotas(mascota.getNombre(), likes, mascota.getFoto()));
                        }
                        else
                        {
                            mascotasFive.add(new Mascotas(mascota.getNombre(),likes,mascota.getFoto()));
                        }
                    }

                }

            }
        });
        holder.imgPet.setImageResource(mascota.getFoto());
        //
        holder.imgLikes.setImageResource(R.drawable.icons8_dog_bone_48);
        holder.tvNombre.setText(mascota.getNombre());
        //sdfsdfs

    }

    @Override
    public int getItemCount()
    {
        return (mascotas == null) ? 0 : mascotas.size();
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
