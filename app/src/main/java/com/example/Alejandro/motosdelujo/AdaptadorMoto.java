package com.example.Alejandro.motosdelujo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.Alejandro.motosdejujo.R;

import java.util.ArrayList;

/**
 * Created by Alejandro on 04/06/2017.
 */

public class AdaptadorMoto extends RecyclerView.Adapter<AdaptadorMoto.ApartamentoViewHolder>{

    private ArrayList<Moto> moto;
    private OnApartamentoClickListener clickListener;
    private String[] titulos;

    public AdaptadorMoto(ArrayList<Moto> moto, OnApartamentoClickListener clickListener, String[] titulos) {
        this.moto = moto;
        this.clickListener = clickListener;
        this.titulos = titulos;
    }

    @Override
    public AdaptadorMoto.ApartamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_moto,parent,false);
        return new ApartamentoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorMoto.ApartamentoViewHolder holder, int position) {
        final Moto a= moto.get(position);
        holder.foto.setImageResource(Integer.parseInt(a.getFoto()));
        holder.nom.setText(titulos[0]+": "+a.getNomenclatura());
        holder.piso.setText(titulos[1]+": "+a.getPiso());
        holder.precio.setText(titulos[2]+": $"+a.getPrecio());

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clickListener.onApartamentoClick(a);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moto.size();
    }

    public static class ApartamentoViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nom;
        private TextView piso;
        private TextView precio;
        private View view;

        public ApartamentoViewHolder(View itemView) {
            super(itemView);
            view= itemView;
            foto = (ImageView)itemView.findViewById(R.id.foto);
            nom = (TextView)itemView.findViewById(R.id.txtNomenclaturaP);
            piso = (TextView) itemView.findViewById(R.id.txtPisoP);
            precio = (TextView)itemView.findViewById(R.id.txtPrecioP);
        }
    }

    public interface OnApartamentoClickListener{
        void onApartamentoClick(Moto a);
    }
}