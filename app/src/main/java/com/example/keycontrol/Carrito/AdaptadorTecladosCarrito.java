package com.example.keycontrol.Carrito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

import java.util.ArrayList;

public class AdaptadorTecladosCarrito extends RecyclerView.Adapter<TecladosCarritoViewHolder> {

    private ArrayList<Teclado> teclados;
    private Context context;

    public AdaptadorTecladosCarrito(Context context, ArrayList<Teclado> teclados){

        this.context = context;
        this.teclados = teclados;

    }

    @Override
    public TecladosCarritoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.elemento_carrito, viewGroup, false);

        TecladosCarritoViewHolder viewHolder = new TecladosCarritoViewHolder(itemView, context);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(TecladosCarritoViewHolder viewHolder, int posicion){

        Teclado teclado = teclados.get(posicion);
        viewHolder.bindTecladoCarrito(teclado);

    }

    @Override
    public int getItemCount(){

        return teclados.size();

    }
}